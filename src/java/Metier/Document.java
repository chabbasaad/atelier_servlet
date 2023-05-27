/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author Huawei
 */
public class Document {
    private String code;
    private String titre;

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
  public void afficher()
  {
      System.out.println("code : "+code);
       System.out.println("titre : "+titre);
  }
    
    public Document(String code, String titre) {
        this.code = code;
        this.titre = titre;
    }

    public Document() {
    }

    public Document(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    private String Ttire;
    
}
