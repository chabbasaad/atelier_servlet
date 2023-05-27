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
public class Livre extends Document{

    private String auteur;
    private int nbr_pages;
    public Livre(String code, String Ttire,String auteur,int nb) {
        super(code, Ttire);
        this.auteur=auteur;
        this.nbr_pages=nb;
    }
    
      public Livre() {
        super("", "");
         this.auteur="";
          this.nbr_pages=0;
    }

    public Livre(String code) {
        super(code);
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbr_pages() {
        return nbr_pages;
    }

    public void setNbr_pages(int nbr_pages) {
        this.nbr_pages = nbr_pages;
    }
    
    
    public void afficher()
    {
        super.afficher();
       System.out.println("auteur : "+auteur);
       System.out.println("nbr de pages : "+nbr_pages);

    }

    @Override
    public String toString() {
        return "Livre{" + "auteur=" + auteur + ", nbr_pages=" + nbr_pages + '}';
    }
    
    
}
