
package DAO;

import java.sql.*;


public class Connexion {
    
   //public static String url="jdbc:mysql://localhost:3306/biblio",password="",user="root",driver="";
  public static String url="",password="",user="",driver="";
   static Connection cnx=null;
   
    public static void deconnect()
   {
       if(cnx!=null)
       {
           try{
                 cnx.close();
           cnx=null;
           }
           catch(Exception ex)
           {
                System.out.println("errur de cnx close"); 
           }
         
       }
   }
   
   public static Connection connecter()
   {
       if(cnx==null)
       {
           try{
              // Class.forName("com.mysql.jdbc.Driver");
                Class.forName(driver);
               cnx = DriverManager.getConnection(url,user,password);
  
           }catch(Exception ex)
           {
               System.out.println("ERRUR LIE au driver");
           }
                    
       }
       return cnx;
       
       
   }
   
  
    
}
