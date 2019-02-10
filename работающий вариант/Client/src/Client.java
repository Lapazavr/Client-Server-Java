import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) 
      throws IOException {
        
    InetAddress addr = InetAddress.getByName(null);
    System.out.println("addr = " + addr);
    Socket socket = new Socket("127.0.0.1", 12345);
    
     try {
      System.out.println("socket = " + socket);
      BufferedReader in =
        new BufferedReader(
          new InputStreamReader(
            socket.getInputStream()));
              
               PrintWriter out =
        new PrintWriter(
          new BufferedWriter(
            new OutputStreamWriter(
              socket.getOutputStream())), true);
         
      String str =in.readLine();
      System.out.println(str);
      out.println("13304111");
      
      int a=0,b=0,c=0,d=0,e=0,sum=0,i=1;
      
      while (true) {
          e=d;
          d=c;
          c=b;
          b=a;
                
         str =in.readLine(); 
         System.out.println("Next number: ");
         System.out.println(str);
      
         if(str.equals("END"))
          break;
         a=Integer.parseInt(str);
         out.println(a);
      
         if (i==5) {
         sum=a+b+c+d+e;
         out.println(sum);
         i=0;
         sum=0;}
         i++;}
      
      
       out.println("Finished");
       
        System.out.println(str);
        str =in.readLine();
        System.out.println(str);
//      out.println("Finished");
      
      //str =in.readLine(); 
      System.out.println(str);
      if(str.equals("OK"))
          out.print("Ура! Заработало!");
          else 
          out.print( "Еще подумаю...");     
          
   
         } finally {
      System.out.println("closing...");
      socket.close();
    }
  }
}