import Metier.*;
import java.util.ArrayList;

public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Biblio B = new Biblio();
        
     //   B.insert(new Dictionnaire("dico001","titre A","Langue francais",25000));
        
       //   ArrayList<Document> List = B.Select(new Livre());
       //   for (int i=0;i<List.size();i++)
       //   {
        //     ((Livre)List.get(i)).afficher();
        //  }
        
       /*  ArrayList<Document> List = B.Select("dico001");
          for (int i=0;i<List.size();i++)
         {
             ((Dictionnaire)List.get(i)).afficher();
          }*/
          
          
         System.out.println(B.find("livre","test").toString());
          
          
         
          
          
          
          
    }
    
}
