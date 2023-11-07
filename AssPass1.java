//   I KNOW IT'S A SILLY CODE, BUT IT DOES WORK
import java.io.*;
import java.util.*;
class AssPass1
{
 
 public static void main(String args[])throws Exception
 { 
  int loc=0;
  int j=0,k;
  FileReader f1=new FileReader("input.txt");
  BufferedReader b1=new BufferedReader(f1); 
  FileReader f2=new FileReader("optab.txt");
  BufferedReader b2=new BufferedReader(f2);
  FileWriter f3=new FileWriter("symtab.txt");
  BufferedWriter b3=new BufferedWriter(f3);
  FileWriter f4=new FileWriter("intermediate.txt");
  BufferedWriter  b4=new BufferedWriter(f4);
  FileWriter f5 = new FileWriter("littab.txt");
  BufferedWriter b5 = new BufferedWriter(f5);
  StringBuffer sb = new StringBuffer();
  String s,s3,s4,tmp,sd, sl;
  String s1[]=new String[3];
  String s2[]=new String[3];

    int lc = 0;

    List<String> symtab = new ArrayList<String>();
    List<String> littab = new ArrayList<String>();
    int symCounter = 0;
    int litCounter = 0;

  while((s=b1.readLine())!=null)
  { 
    lc++;
    System.out.println(s);
    int m=0;
   String[] line = s.split(" ", 10);
   System.out.println();
    for(String ss : line){
        System.out.print(ss+ " ");
    }
    System.out.println("-------------------------->"+line[0]);
    if(line.length == 2){
        System.out.println("HERERER");
        if(line[0].equals("START")){
            System.out.println("YES");
            int nn = Integer.parseInt(line[1]);
            b4.write("\t\t(AD 01) ("+nn+")\n");
            System.out.println("(AD 01) (C "+nn+")");
            lc = nn;

        }   // if
    }   // start check


    if(line.length == 3){
        String putString = "";
        System.out.println("**************** checking for MOVER ****************");

        if(line[0].equals("MOVER")){
            String ins = "NOINS";
            if(line[0].contains("STOP")){ ins = "(IS 00)"; }
            if(line[0].contains("ADD")){ ins = "(IS 01)"; }
            if(line[0].contains("SUB")){ ins = "(IS 02)"; }
            if(line[0].contains("MUL")){ ins = "(IS 03)"; }
            if(line[0].contains("MOVER")){ ins = "(IS 04)"; }
            if(line[0].contains("MOVEM")){ ins = "(IS 05)"; }
            if(line[0].contains("COMP")){ ins = "(IS 06)"; }
            if(line[0].contains("BC")){ ins = "(IS 07)"; }
            if(line[0].contains("DIV")){ ins = "(IS 08)"; }
            if(line[0].contains("READ")){ ins = "(IS 09)"; }
            if(line[0].contains("PRINT")){ ins = "(IS 10)"; }

            String reg = "NOREG";
            
            if(line[1].contains("AREG")){ reg = "(01)"; }
            if(line[1].contains("BREG")){ reg = "(02)"; }
            if(line[1].contains("CREG")){ reg = "(03)"; }
            if(line[1].contains("DREG")){ reg = "(04)"; }
            System.out.println("_____________________LINE ONE "+line[1]);

            
            // LITERALS
            if(line[2].contains("='")){
                String lit = line[2];
                String litString = lc + "\t\t" + (litCounter) + "\t" + line[2] + "\n";
                System.out.println("THE LITERAL TABLE ENTRY IS -----------> "+litString);
                b5.write(litString);

                String literalEntryString = "(L "+litCounter+")";

                putString = lc+"\t\t"+ins+" "+reg+" "+ literalEntryString +"\n";
                
                litCounter++;

            }





            // SYMBOLS
            else{
                String symString = lc + " "+ (symCounter)+" "+line[2]+"\n";
            b3.write(symString);
            String intString = "(S "+symCounter+")";
            symtab.add(symCounter, line[2]);
            System.out.println("------------------------------------------------>CURRENT LOC IS : "+lc);

            putString = lc+"\t\t"+ins+" "+reg+" "+intString+"\n";

            symCounter++;
            }       // else of checking for symbol and literals


            b4.write(putString);
            System.out.println(putString);

            
        }


    }   // check for MOVER / MOVEM



    if(line.length == 3){}




    if(line.length == 1){
        String ss = "";
        if(line[0].contains("LTORG")){ ss = "(AD 05)"; }

        b4.write("\t\t"+ss+"");
        
    }   // check LTORG


    if(line.length == 3){
        if(line[1].contains("DC") || line[1].contains("DS")){
            if(line[1].contains("DC")){
                b4.write("(DL 01) (C "+line[2]+")");
            }
            if(line[1].contains("DS")){
                b4.write(lc+"\t\t(DL 02) (C "+line[2]+")\n");
            }
        }   // if
    }   // check DS / DC


    if(line.length == 1){
        if(line[0].contains("END")){
            b4.write("\n\t\t(AD 02)\n");
        }
    }



 }
b1.close();
b2.close();
b4.close();
b3.close();
b5.close();
}
}
