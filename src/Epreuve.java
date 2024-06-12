import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cette classe représente une épreuve sportive
 */
public class Epreuve {

    /**
     *  Liste des équipes participant à l'épreuve
     */
    private List<Athlete> athletes;

    /**
    * Nom de l'épreuve
    */
    private String nom;

    /**
    * Sport de l'épreuve
    */
    private Sport sportEpreuve;

    /**
     * Constructeur de la classe Epreuve
     * @param athletes Liste des équipes participant à l'épreuve
     * @param nom Nom de l'épreuve
     * @param sp Sport de l'épreuve
     */
    public Epreuve(List<Athlete> athletes, String nom, Sport sp){
        this.athletes = athletes;
        this.nom = nom;
        this.sportEpreuve = sp;
    }

    /**
     * Constructeur de la classe Epreuve
     * @param nom Nom de l'épreuve
     * @param sp Sport de l'épreuve
     */
    public Epreuve(String nom, Sport sp){
        this.athletes = new ArrayList<>();
        this.nom = nom;
        this.sportEpreuve = sp;
    }

    /**
     * Getter de la liste des équipes participant à l'épreuve
     * @return Liste des équipes participant à l'épreuve
     */
    public List<Athlete> getathletes() {
        return athletes;
    }

    /**
     * Définit la liste des équipes participant à l'épreuve
     * @param athletes Liste des équipes participant à l'épreuve
     */
    public void setathletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    /**
     * getter du nom de l'épreuve
     * @return Le nom de l'épreuve
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de l'épreuve
     * @param nom Le nom de l'épreuve
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * getter du sport de l'épreuve
     * @return Le sport de l'épreuve
     */
    public Sport getSportEpreuve() {
        return this.sportEpreuve;
    }

    /**
     * Définit le sport de l'épreuve
     * @param sp Le sport de l'épreuve
     */
    public void setSportEpreuve(Sport sp) {
        this.sportEpreuve = sp;
    }

    /**
     * Classe les athlètes en fonction de leurs performances dans l'épreuve
     * @return Liste triée des athlètes en fonction de leurs scores
     */
    public List<Athlete> classement(){
        List<Double> lesScores = new ArrayList<>();
        for(Athlete ath : athletes){
            lesScores.add(ath.participer(this));
        }
        Collections.sort(lesScores, Collections.reverseOrder());
        List<Athlete> classement = new ArrayList<>();
        for(double score : lesScores){
            for(Athlete ath : athletes){
                if(ath.participer(this) == score && (!(classement.contains(ath)))){
                    classement.add(ath);
                    break;
                }
            }
        }
        return classement;
    }

    @Override
    public String toString() {
        return "Epreuve [athletes=" + athletes + ", nom=" + nom + ", discipline=" + sportEpreuve + "]";
    }
}