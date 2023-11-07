import java.util.*;
import java.io.*;


public class MacroPass2{

    public static void main(String args[]) throws Exception{

        FileWriter fr = new FileWriter("finop.txt");
        BufferedWriter buff = new BufferedWriter(fr);

        FileReader ff = new FileReader("op.txt");
        BufferedReader bb = new BufferedReader(ff);

      
        String s;

        while((s = bb.readLine())!=null){
            
            System.out.println(s);
            String[] sL = s.split(" ", 10);
            String ss;
            
            FileReader mnt = new FileReader("mnt.txt");
            BufferedReader mntB = new BufferedReader(mnt);

            while((ss = mntB.readLine()) != null){

                String[] ssL = ss.split(" ", 10);
                
                if(sL[0].equals(ssL[0])){

                    System.out.println("\nMACRO CALL FOUND !\n"+s);

                    FileReader mdt = new FileReader("mdt.txt");
                    BufferedReader mdtB = new BufferedReader(mdt);
                    String ms;
                    boolean nextLinee = false;
                    while((ms = mdtB.readLine()) != null ){
                        if(ms.contains(sL[0])){
                            nextLinee = true;
                        }   // check for name
                        if(nextLinee && !ms.contains("MEND") && !ms.contains(sL[0])){
                            buff.write(ms.substring(0, ms.length()-3)+"\n");
                        }   // add the line
                        if(ms.contains("MEND")){
                            nextLinee = false;
                        }   // check END
                    }

                    

                }   // macro call found
                else{
                    buff.write(s+"\n");
                }   // macro call not found

                // mntB.close();

            
            }   // inner while


        }   // while
        




        buff.close();
        bb.close();



    }   // psvm()

}
