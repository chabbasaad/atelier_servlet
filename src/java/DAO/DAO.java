/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Huawei
 */
public class DAO {
Statement stm=null;
 // constructor
public DAO(){
 try {
 stm=Connexion.connecter().createStatement();

 } catch (Exception ex) { System.out.println(ex.getMessage()); }
}
//method set pour excuter des requete insert delete update
public int Set(String sql) throws SQLException, Exception {
 return stm.executeUpdate(sql);
}


public ResultSet Get(String sql) throws SQLException { 
return stm.executeQuery(sql);
} 



// method qui renvoi une liste de map 
/*public ArrayList<Map<String,String>> Get(String sql) throws SQLException {
 ArrayList<Map<String,String>> list=new ArrayList();
 // exuction d une requete de type select 
 ResultSet rs=stm.executeQuery(sql);
 Map<String, String> dico;
 // recupere les caracteresitque d une table  (nbr de champ etc 
 ResultSetMetaData rsmd = rs.getMetaData();
 int nbr_champs = rsmd.getColumnCount();
 int i;
 while(rs.next())
 {
 dico=new HashMap<>();
 for( i=1;i<=nbr_champs;i++)
 dico.put(rsmd.getColumnName(i), rs.getString(i));
 list.add(dico);
 dico=null;

 }
 return list;

 
 
 
}*/


}