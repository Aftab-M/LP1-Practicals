import java.io.*;
import java.util.*;
class AssPass2
{
 
 public static void main(String args[])throws Exception
 { 
  int loc=0;
  int j=0,k;
  FileReader ipfile=new FileReader("intermediatee.txt");
  BufferedReader ip=new BufferedReader(ipfile); 

  
  FileReader f3=new FileReader("symtab.txt");
  BufferedReader b3=new BufferedReader(f3);
  
  FileWriter f4=new FileWriter("op.txt");
  BufferedWriter  b4=new BufferedWriter(f4);
  
  FileReader f5 = new FileReader("littab.txt");
  BufferedReader b5 = new BufferedReader(f5);
  
  StringBuffer sb = new StringBuffer();
  String s,s3,s4,tmp,sd, sl;
  String s1[]=new String[3];
  String s2[]=new String[3];

    int lc = 0;

    List<String> symtab = new ArrayList<String>();
    List<String> littab = new ArrayList<String>();
    int symCounter = 0;
    int litCounter = 0;

    System.out.println("HERE HERE HERE HERE HERE HERE HERE HERE HERE HERE ");

  while((s=ip.readLine())!=null)
  { 
   
    lc++;
    // System.out.println(s);
    int m=0;
    String[] line = s.split(" ", 10);
    
    // System.out.println("AWLIHKBAW ");


    // for(String ss : line){
    //     System.out.println("|"+ss+ "|");
    // }
    
    
    if(s.contains("(IS") && !(s.contains("(IS 09)"))){
        System.out.println("We've got an imperative !!");

        String reg = s.charAt(8)+""+s.charAt(9)+s.charAt(10)+s.charAt(11);
        System.out.println(reg);

        String entry = s.charAt(13)+""+s.charAt(14)+s.charAt(15)+s.charAt(16)+s.charAt(17);
        System.out.println(entry);

        String op = "("+s.charAt(4) + "" + s.charAt(5)+")";

        String addr = "NOADDR";




        if(entry.charAt(1) == 'L'){
            System.out.println("ASLIHGNALIEKBKb");
            String ls;
            while((ls=b5.readLine())!=null){
                
                if(ls.contains(""+s.charAt(16))){
                    System.out.println(ls);

                    addr = ls.charAt(0)+""+ls.charAt(1)+ls.charAt(2);

                }
                // System.out.println(ls);
                String fin = op +" "+ reg +" "+ "("+addr+")\n";
                System.out.println(fin);
                b4.write(fin);
            }

        }
        if(entry.charAt(1) == 'S'){

            System.out.println("ASLIHGNALIEKBKb");
            String ls;
            while((ls=b3.readLine())!=null){
                
                if(ls.contains(" "+s.charAt(16)+" ")){
                    System.out.println("FOUND LINE IS "+ls);

                    addr = ls.charAt(0)+""+ls.charAt(1)+ls.charAt(2);

                }
                // System.out.println(ls);
                String fin = op +" "+ reg +" "+ "("+addr+")\n";
                System.out.println(fin);
                b4.write(fin);
            }
            



        }   // SYMBOL CHECK





    }
    // & IMPERATIVE CHECK ^

    if(s.contains("(IS 09)")){

        FileReader ff = new FileReader("symtab.txt");
        BufferedReader bb = new BufferedReader(ff);


        if(s.contains("(S ")){
            String ad = "";

            int aa = s.lastIndexOf('(');
            boolean single = (s.charAt(aa+4)==')');
            String asd = (single)? s.charAt(11)+"" : s.charAt(11)+s.charAt(12)+"";
            System.out.println("\n\n"+aa+" and "+asd+"\n\n");
            String sss;
            while((sss = bb.readLine())!= null){

                if(sss.contains(" "+asd+" ")){
                    ad = sss.substring(0, 3);
                }

                System.out.println("\n\n"+sss+"\n\n");
            }   // while

            

            System.out.println("(09) ("+ad+")");
            b4.write("(09) ("+ad+")\n");


        }


        bb.close();
    }   // if



    // System.out.println("\n\n-------------------------->"+line[0]);
    
 }
b4.close();
b3.close();
b5.close();
ip.close();
}
}









// START 500
// MOVER AREG X
// MOVER AREG ='2'
// MOVER AREG ='33'
// MOVER BREG R
// X DS 1
// LTORG
// END





// 		(AD 01) (500)
// 501		(IS 04) (01) (S 0)
// 502		(IS 04) (01) (L 0)
// 503		(IS 04) (01) (L 1)
// 504		(IS 04) (02) (S 1)
// 		(AD 05)		




// 501 0 X
// 504 1 R



// 502		0	='2'
// 503		1	='33'



