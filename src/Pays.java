import java.util.List;
import java.util.ArrayList;

public class Pays {
    private String nom;
    private List<Equipe> lesEquipes;
    private int nbAthletesPays;

    public Pays(String nom, int nbAthletesPays) {
        this.nom = nom;
        this.lesEquipes = new ArrayList<>();
        this.nbAthletesPays = nbAthletesPays;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public List<Equipe> getEquipes() {
        return this.lesEquipes;
    }

    @Override
    public String toString(){
        return "Le pays " + this.nom + " possède un total de " + this.lesEquipes.size() + " équipes et de "  + this.nbAthletesPays + " athlètes ";
    }

     /**
     * Redéfinition de la méthode equals pour utiliser les méthodes contains, indexOf etc...
     */
    @Override
    public boolean equals(Object objet){
        if(objet == null){return false;}

        if(objet==this){return true;}

        if(!(objet instanceof Pays)){return false;}

        Pays tmp = (Pays) objet;
        return tmp.getNom().equals(this.nom);
    }
}
