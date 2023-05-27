
package Metier;

import DAO.DAO;
import DAO.IDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Biblio extends  DAO implements IDAO<Document>{
    String sql=null;
    @Override
    public int insert(Document D) {
      int res=0;
    try {
        if(D instanceof Livre ) {
           
         sql="insert into livre values('"+D.getCode()+"','"+D.getTitre()+"',"
                +"'"+((Livre) D).getAuteur()+"',"+((Livre) D).getNbr_pages()+")";  
        } else {
            sql="insert into dictionnaire values('"+D.getCode()+"','"+D.getTitre()+"',"
                +"'"+((Dictionnaire) D).getLangue()+"',"+((Dictionnaire) D).getNbr_def_mots()+")";

        }
        res=super.Set(sql);
    } catch (Exception ex) {
     System.out.println("Erreur liée à l'éxecution de la req !!!");
    }
    return res;
    }

    @Override
    public int update(Document D) {
        int res=0;
    try {
        if(D instanceof Livre ) {
            //Livres(int reference, String titre, String autheur, int pages)
        sql="update livre set titre='"+D.getTitre()+"', auteur="
                +"'"+((Livre) D).getAuteur()+"', nbr_pages="+((Livre) D).getNbr_pages()+" where code='"+D.getCode()+"'";
        } else {
            sql="update  dictionnaire set titre='"+D.getTitre()+"',langue="
                +"'"+((Dictionnaire) D).getLangue()+"', nbr_def_mots="+((Dictionnaire) D).getNbr_def_mots()+" where code='"+D.getCode()+"'";  
        }
                res=super.Set(sql);
         } catch (Exception ex) {
             System.out.println("Erreur liée à l'éxecution de la req !!!");
         }
    return res;
    }

    @Override
    public int delete(Document D) {
        int res=0;
    try {
        if(D instanceof Livre ) {
          sql="delete from livre  where code='"+D.getCode()+"'";  
        }else{
          sql="delete from dictionnaire  where code='"+D.getCode()+"'";  
        }  
        res=super.Set(sql);
    } catch (Exception ex) {
     System.out.println("Erreur liée à l'éxecution de la req !!!");
    }
    return res;
    }
    
     @Override
    public ArrayList Select(String type) {
         ArrayList<Dictionnaire> DictionList = new ArrayList();
         ArrayList<Livre> LiverList = new ArrayList();

         if(type.equals("livre") ) {
         try{
            ResultSet rs;
           
            sql="select * from livre ";
            
            rs=super.Get(sql);
             while(rs.next())
         {
             LiverList.add(new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
              //System.out.println(rs.getInt(1)+" "+rs.getString(2));
         }

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion Articles"); 
        }
        
        return LiverList;
    }else if (type.equals("dictionnaire")){
        
        
        try{
            ResultSet rs;
            
            sql="select * from dictionnaire";  
            rs=super.Get(sql);
            while(rs.next())
         {
             DictionList.add(new Dictionnaire(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
              //System.out.println(rs.getInt(1)+" "+rs.getString(2));
         }
            

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion Articles"); 
        }
        
        return DictionList;
       }
         return DictionList;
    }
    
 

    
    public Document find(String type,String code) {
         
        
        Document doc = null;

         if(type.equals("livre") ) {
             
         try{
            ResultSet rs;
           
            sql="select * from livre where code='" + code + "'";
            
            rs=super.Get(sql);
             while(rs.next())
         {
             doc = new Livre(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
              //System.out.println(rs.getInt(1)+" "+rs.getString(2));
         }

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion Articles"); 
        }
        
   
    }else if (type.equals("dictionnaire")){
        
         
        try{
            ResultSet rs;
            
            sql="select * from dictionnaire where code='" + code + "'";
            rs=super.Get(sql);
            while(rs.next())
         {
             doc=new Dictionnaire(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            
         }
            

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion Articles"); 
        }
        
    
       }
         return doc;
    }
    
    
}
