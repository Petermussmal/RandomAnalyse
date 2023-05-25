import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static Hashtable<String, int[]> RandomListe = new Hashtable<String, int[]>();

    public static ArrayList<AnalyseRandom> ThreadList = new ArrayList<>();

    public static void main(String[] args) {
        for(int i = 0; i < 200; i++){
            AnalyseRandom d = new AnalyseRandom();
            d.start();
            ThreadList.add(d);
        }

        int allDead = 0;
        do{
            allDead = 0;
            for(AnalyseRandom d : ThreadList){
                if(d.isAlive()){
                    allDead += 1;
                }
            }
        }while(allDead != 0);


        FileExport obj = new FileExport(RandomListe, "DatenExport.txt");
        obj.start();

        for(String s : RandomListe.keySet()){
            int[] temp = RandomListe.get(s);
            double d = (double)temp[1]/(double)temp[0];
            System.out.format(s + " | %.4f \n", d);
        }
    }
}