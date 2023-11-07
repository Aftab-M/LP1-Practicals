//   DO CREATE THE SPECIFIED FILES, IGNORE SOME DEBUG PRINT STATEMENTS
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class MacroPass1{

    public static void main(String args[]) throws Exception{

        FileReader ff = new FileReader("ip.txt");
        BufferedReader br = new BufferedReader(ff);


        FileWriter f = new FileWriter("mdt.txt");
        BufferedWriter b = new BufferedWriter(f);

        FileWriter fff = new FileWriter("op.txt");
        BufferedWriter bbb = new BufferedWriter(fff);


        int startAddress = 0, loc = 0, alaCounter = 1;
        String s;
        boolean readThis = false, first = false;

        while((s = br.readLine())!=null){
            loc++;
            String[] line = s.split(" ", 10);

            if(line[0].contains("START")){ startAddress = Integer.parseInt(line[1]); loc = startAddress; }



            if(line[0].contains("MACRO")){ readThis = true; first = true; }

            if(readThis){
                
                if(first == true && !line[0].contains("MACRO")){
                    FileWriter fw = new FileWriter("mnt.txt");
                    BufferedWriter bb = new BufferedWriter(fw);

                    FileWriter ala = new FileWriter("ala.txt");
                    BufferedWriter alab = new BufferedWriter(ala);

                    if(line.length == 1){}
                    
                    for(int i=1; i<line.length; i++){
                        alab.write(alaCounter+"\t"+line[i].replaceAll(",", "")+"\n");
                        alaCounter++;
                    }   // for - i
                    

                    bb.write(s+"\n");

                    first = false;
                    alab.close();
                    bb.close();
                }


                System.out.println("Putting ----> "+s+" <---- into MDT");
                b.write(s+"\t\t\t\t"+loc+"\n");

                
            }   // if

            if(line[0].contains("MEND")){ readThis = false; }



            if(readThis == false && !line[0].contains("MEND")){
                bbb.write(s+"\n");
            }


            // System.out.println();
            // for(String ss : line){
            //     System.out.print(ss + " ");
            // }   // for - s


        }   // while





        bbb.close();
        br.close();
        b.close();

    }   // psvm()

}   // p1
