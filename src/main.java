import pyramids.*;


import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        PyramidsImp obj = new PyramidsImp();
        String path = "C:\\Users\\ZoudriX\\IdeaProjects\\pyramids\\pyramids.csv";
        List<Pyramid> pyramids= obj.readPyramidFromCSV(path);



        Collections.sort(pyramids, new Comparator<Pyramid>() {
            @Override
            public int compare(Pyramid o1, Pyramid o2) {
                return Double.compare((o2.getHeight()),(o1.getHeight()));
            }
        });
        int i=0;
        for(Pyramid p: pyramids){
            System.out.println("#"+(i++)+" "+p.getSite()+" - "+p.getModern_name()+" - "+p.getPharaoh()+" - "+p.getHeight());
        }

        Map<String,Integer> cSite= new LinkedHashMap<>();
        for(Pyramid p:pyramids){
            String site = p.getSite();
            Integer x= cSite.get(site);
            if(x==null){
                x =1;
            }
            else{
                x++;
            }
            cSite.put(site,x);
        }
        System.out.println(cSite);
    }
}
