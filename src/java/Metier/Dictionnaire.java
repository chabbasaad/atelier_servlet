
package Metier;



public class Dictionnaire extends Document {
    
    String langue;
    int nbr_def_mots;

    public Dictionnaire( String code,String langue, String titre,int nbr_def_mots) {
        super(code, titre);
        this.langue = langue;
        this.nbr_def_mots = nbr_def_mots;
    }

    public Dictionnaire(String code) {
        super(code);
    }

    public Dictionnaire() {
          super("", "");
        this.langue = "";
        this.nbr_def_mots =0;
    }

  

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNbr_def_mots() {
        return nbr_def_mots;
    }

    public void setNbr_def_mots(int nbr_def_mots) {
        this.nbr_def_mots = nbr_def_mots;
    }
  
      public void afficher()
    {
        super.afficher();
       System.out.println("langue : "+langue);
       System.out.println("nbr def mots : "+nbr_def_mots);

    }
    
    
    
}
