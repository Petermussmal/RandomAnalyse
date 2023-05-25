import java.util.Arrays;
import java.util.Random;

public class AnalyseRandom extends Thread{
    public AnalyseRandom(){

    }
    public void run(){
        int[] vorWerte = new int[8];

        for(int i = 0; i < 9 * Math.pow(10, 6); i++){
            int aktWurf = new Random().nextInt(1, 7);

            StringBuilder quadReihe = new StringBuilder();
            for(int intValue : vorWerte){
                quadReihe.append(intValue);
            }

            if(!Arrays.equals(Main.RandomListe.getOrDefault(quadReihe.toString(), new int[0]), new int[0])){
                if(aktWurf == 6){
                    int[] temp = Main.RandomListe.get(quadReihe.toString());
                    temp[0]++;
                    temp[1]++;
                    Main.RandomListe.put(quadReihe.toString(), temp);
                }else{
                    int[] temp = Main.RandomListe.get(quadReihe.toString());
                    temp[0]++;
                    Main.RandomListe.put(quadReihe.toString(), temp);
                }
            }else{
                if(aktWurf == 6){
                    Main.RandomListe.put(quadReihe.toString(), new int[]{1,1});
                }else{
                    Main.RandomListe.put(quadReihe.toString(), new int[]{1,0});
                }
            }
            ArrayPutValueLast(vorWerte, aktWurf);
        }
    }

    public static int[] ArrayPutValueLast(int[] DataArray, int value){
        for(int i = 1; i < DataArray.length; i++){
            DataArray[i-1] = DataArray[i];
        }
        DataArray[DataArray.length-1] = value;
        return DataArray;
    }
}
