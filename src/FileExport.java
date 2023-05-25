import java.io.FileWriter;
import java.util.HashMap;
import java.util.Hashtable;

public class FileExport extends Thread{
    private final Hashtable<String, int[]> data;
    private final String filename;
    public FileExport(Hashtable<String, int[]> Data, String Filename){
        data = Data;
        filename = Filename;
    }

    public void run() {
        try {
            FileWriter fwriter = new FileWriter(filename);

            for (String s : data.keySet()) {
                int[] temp = data.get(s);
                double d = (double) temp[1] / (double) temp[0];
                fwriter.write(s + ";" + d + "\n");
            }
            fwriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
