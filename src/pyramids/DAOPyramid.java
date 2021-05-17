package pyramids;

import pyramids.Pyramid;

import java.io.IOException;
import java.util.List;
public interface DAOPyramid {
    public List<Pyramid> readPyramidFromCSV(String path) throws IOException, InterruptedException;
    public List<Pyramid> createPyramid(String[] metadata);
}
