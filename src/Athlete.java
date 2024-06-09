import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Athlete implements Comparable<Athlete>, Participant{
    private String nom;
    private final String prenom;
    private final String sexe;
    private final String nationalite;
    private int force;
    private int agilite;
    private int endurance;
    private List<Epreuve> lesEpreuves;

    /** 
     * Constructeur de la classe Athlète. 
     * @param nom Chaîne de caractère indiquant le nom d'un athlète.
     * @param prenom Chaîne de caractère indiquant le prénom d'un athlète.
     * @param sexe Chaîne de caractère indiquant le sexe d'un athlète.
     * @param nationalite Chaîne de caractère indiquant la nationalité d'un athlète.
     * @param force Entier indiquant la valeur de force d'un athlète.
     * @param agilite Entier indiquant la valeur d'agilité d'un athlète.
     * @param endurance Entier indiquant la valeur d'endurance d'un athlète.
     */
    public Athlete(String nom, String prenom, String sexe, String nationalite, int force, int agilite, int endurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.lesEpreuves = new ArrayList<>();
    }

    /**
     * Retourne le nom de l'athlète.
     * @return Le nom de l'athlète.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Modifie le nom d'un athlète
     * @param newNomAthlete Le nouveau nom à assigner à l'athlète.
    */
    public void setNom(String newNomAthlete){
        this.nom = newNomAthlete;
    }

    /**
     * Retourne le prénom de l'athlète.
     * @return Le prénom de l'athlète.
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Retourne le sexe de l'athlète.
     * @return Le sexe de l'athlète.
     */
    public String getSexe() {
        return this.sexe;
    }

    /**
     * Retourne la nationalité de l'athlète.
     * @return La nationalité de l'athlète.
     */
    public String getNationalite(){
        return this.nationalite;
    }

    /**
     * Retourne la force de l'athlète.
     * @return La force de l'athlète.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Modifie la force de l'athlète.
     * @param force La nouvelle valeur de force de l'athlète.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Retourne l'agilité de l'athlète.
     * @return L'agilité de l'athlète.
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Modifie l'agilité de l'athlète.
     * @param agilite La nouvelle valeur d'agilité de l'athlète.
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * Retourne l'endurance de l'athlète.
     * @return L'endurance de l'athlète.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Modifie l'endurance de l'athlète.
     * @param endurance La nouvelle valeur d'endurance de l'athlète.
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    // private double calculerScore(Epreuve ep){
    //     if(ep.getTypeEpreuve().equals("athletisme")){
    //         return ((force + agilite + endurance) * ;
    //     }
    // }
        
    // /**
    // * Simule la participation d'un athlète à une épreuve
    // * @return 
    // */
    @Override
    public double participer(){
        return 1;
    //     Map<Epreuve, Double> scores = new HashMap<>();
    //     for(Epreuve ep : lesEpreuves){
    //         double scoreAthlete = calculerScore(ep);
    //         scores.put(ep, scoreAthlete);
    //         ep.enregistrerResultat(this, scoreAthlete);
    //     }
    //     return classement(scoreAthlete);
    }

    /**
     * Retourne une représentation textuelle de l'objet Athlete.
     * @return Une chaîne de caractères décrivant l'athlète avec son nom, prénom, sexe, force, agilité et endurance.
     */
    @Override
    public String toString() {
        return "L'athlète " + this.nationalite + " " + this.prenom + " " + this.nom + ", de sexe " + this.sexe + " est doté d'une force de " + this.force + ", d'une agilité de " + this.agilite + " et d'une endurance de " + this.endurance + ".";
    }


    /**
     * Redéfinition de la méthode equals pour utiliser les méthodes contains, indexOf etc...
     */
    @Override
    public boolean equals(Object objet){
        if(objet == null){return false;}

        if(objet==this){return true;}

        if(!(objet instanceof Athlete)){return false;}

        Athlete tmp = (Athlete) objet;
        return tmp.getNom().equals(this.nom) && tmp.getPrenom().equals(this.prenom);
    }

    /**
     * Redéfinition de l'ordre naturel de tri comme étant la somme de la force, de l'agilité et de l'endurance d'un athlète
     */
    @Override
    public int compareTo(Athlete ath){
        return (this.force + this.agilite + this.endurance) - (ath.getForce() + ath.getAgilite() + ath.getEndurance());
    }

}