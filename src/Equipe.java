import java.util.List;
import java.util.ArrayList;

public class Equipe{
    // private Pays p = null;
    private String nomEquipe;
    private List<Athlete> lesAthletes;
    //private List<Epreuve> lesEpreuves;


    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.lesAthletes = new ArrayList<>();
    }

    // public Pays getPays(){
    //     return this.p
    // }

    public List<Athlete> getAthletes(){
        return this.lesAthletes;
    }

    // public List<Epreuve> getEpreuves(){
    //     return this.lesEpreuves;
    // }

    public Athlete plusFort() {
        Athlete athletePlusFort = null;
        // utilisation de la valeur minimale pour un entier en java pour initialiser le maximum
        int maxForce = Integer.MIN_VALUE;        
        for (Athlete a : this.lesAthletes) {
            if (a.getForce() > maxForce) {
                maxForce = a.getForce();
                athletePlusFort = a;
            }
        }
        return athletePlusFort;
    }

    public Athlete plusEndurant() {
        Athlete athletePlusEndurant = null;
        // utilisation de la valeur minimale pour un entier en java pour initialiser le maximum
        int maxEndurance = Integer.MIN_VALUE;
        for (Athlete a : this.lesAthletes) {
            if (a.getEndurance() > maxEndurance) {
                maxEndurance = a.getEndurance();
                athletePlusEndurant = a;
            }
        }
        return athletePlusEndurant;
    }

    public Athlete plusAgile() {
        Athlete athletePlusAgile = null;
        // utilisation de la valeur minimale pour un entier en java pour initialiser le maximum
        int maxAgilite = Integer.MIN_VALUE;
        for (Athlete a : this.lesAthletes) {
            if (a.getAgilite() > maxAgilite) {
                maxAgilite = a.getAgilite();
                athletePlusAgile = a;
            }
        }
        return athletePlusAgile;
    }    
}