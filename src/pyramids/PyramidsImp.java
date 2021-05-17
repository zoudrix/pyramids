package pyramids;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidsImp implements DAOPyramid{

    List<Pyramid> pyramids = new ArrayList<>();

    @Override
    public List<Pyramid> readPyramidFromCSV(String path) throws IOException, InterruptedException {
        BufferedReader br;
        br = new BufferedReader(new FileReader(path));

//        System.out.println(line);
        Thread th =new Thread(new Runnable() {
            @Override
            public void run() {
                try {


                    String line;
                    line = br.readLine();
                    while (line != null) {
                        line = br.readLine();
                        if (line != null) {
                            String[] row = line.split(",");
//                System.out.println(row[0]+row[2]+row[4]);
                            if (row[7] == "") {
                                row[7] = "0";
                            }
                            Pyramid pyrm = new Pyramid(row[0], row[2], row[4], Double.parseDouble(row[7]));
                            pyramids.add(pyrm);

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        th.start();
        th.join();


        return pyramids;
    }

    @Override
    public List<Pyramid> createPyramid(String[] metadata) {
        pyramids.add(new Pyramid(metadata[0],metadata[1],metadata[2],Double.parseDouble(metadata[3])));
        return  pyramids;
    }
}
