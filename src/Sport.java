import java.util.ArrayList;
import java.util.List;

public class Sport{
    protected List<Epreuve> epreuves;
    protected String nom;
    private double coeffForce;
    private double coeffAgilite;
    private double coeffEndurance;
    
    /**
     * Constructeur de la classe Sport
     * @param nom Nom du sport
     * @param coeffForce Coefficient de force pour ce sport
     * @param coeffAgilite Coefficient d'agilité pour ce sport
     * @param coeffEndurance Coefficient d'endurance pour ce sport
     */
    public Sport(String nom, double coeffForce, double coeffAgilite, double coeffEndurance) {
        this.epreuves = new ArrayList<>();
        this.nom = nom;
        this.coeffForce = coeffForce;
        this.coeffAgilite = coeffAgilite;
        this.coeffEndurance = coeffEndurance;
    }
    
    /**
     * getter pour le coeff de force
     * @return le coeff de force
     */
    public double getCoeffForce(){
        return this.coeffForce;
    }
    
    /**
     * getter pour le coeff d'agilité
     * @return le coeff d'agilité
     */
    public double getCoeffAgilite(){
        return this.coeffAgilite;
    }

    /**
     * getter pour le coeff d'endurance
     * @return le coeff d'endurance
     */
    public double getCoeffEndurance(){
        return this.coeffEndurance;
    }

    /**
     * permet d'ajouter une epreuve de ce sport
     * @param e une epreuve de ce sport
     */
    public void ajouteEpreuve(Epreuve e){
        this.epreuves.add(e);
    }

    /**
     * getter pour le nombre d'épreuve de ce sport
     * @return
     */
    public int nbDEpreuves(){
        return epreuves.size();
    } 
    
    @Override
    public String toString(){
        String res = "";
        for (Epreuve i : this.epreuves){
            res += i.toString();
        }

        return "Les épreuve de" + nom + "sont :" + res;
    }
    
}