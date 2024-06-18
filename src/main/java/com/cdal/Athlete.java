package main.java.com.cdal;

import java.util.Random;


public class Athlete implements Comparable<Athlete>, Participant {
    /**
     * Nom de l'athlète
     */
    private String nom;
    /**
     * Prénom de l'athlète
     */
    private final String prenom;

    /**
     * Sexe de l'athlète ("H" ou "F"). Ce champ est final car il ne doit pas être modifié après l'initialisation.
     */
    private final String sexe;

    /**
     * Nationalité de l'athlète. Ce champ est final car il ne doit pas être modifié après l'initialisation.
     */
    private final String nationalite;

    /**
     * Force de l'athlète, représentée par un entier.
     */
    private int force;

    /**
     * Agilité de l'athlète, représentée par un entier.
     */
    private int agilite;

    /**
     * Endurance de l'athlète, représentée par un entier.
     */
    private int endurance;

    /**
     * Liste des épreuves auxquelles l'athlète participe.
     */
    private Epreuve ep;

    /**
     * Constructeur de la classe Athlète.
     *
     * @param nom         Chaîne de caractère indiquant le nom d'un athlète.
     * @param prenom      Chaîne de caractère indiquant le prénom d'un athlète.
     * @param sexe        Chaîne de caractère indiquant le sexe d'un athlète.
     * @param nationalite Chaîne de caractère indiquant la nationalité d'un athlète.
     * @param force       Entier indiquant la valeur de force d'un athlète.
     * @param agilite     Entier indiquant la valeur d'agilité d'un athlète.
     * @param endurance   Entier indiquant la valeur d'endurance d'un athlète.
     * @param ep          l'épreuve à laquelle l'athlète participe.
     */
    public Athlete(String nom, String prenom, String sexe, String nationalite, int force, int agilite, int endurance, Epreuve ep) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.ep = ep;
    }

    /**
     * Retourne le nom de l'athlète.
     *
     * @return Le nom de l'athlète.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Modifie le nom d'un athlète
     *
     * @param newNomAthlete Le nouveau nom à assigner à l'athlète.
     */
    public void setNom(String newNomAthlete) {
        this.nom = newNomAthlete;
    }

    /**
     * Retourne le prénom de l'athlète.
     *
     * @return Le prénom de l'athlète.
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Retourne le sexe de l'athlète.
     *
     * @return Le sexe de l'athlète.
     */
    public String getSexe() {
        return this.sexe;
    }

    /**
     * Retourne la nationalité de l'athlète.
     *
     * @return La nationalité de l'athlète.
     */
    public String getNationalite() {
        return this.nationalite;
    }

    /**
     * Retourne la force de l'athlète.
     *
     * @return La force de l'athlète.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Modifie la force de l'athlète.
     *
     * @param force La nouvelle valeur de force de l'athlète.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Retourne l'agilité de l'athlète.
     *
     * @return L'agilité de l'athlète.
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Modifie l'agilité de l'athlète.
     *
     * @param agilite La nouvelle valeur d'agilité de l'athlète.
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * Retourne l'endurance de l'athlète.
     *
     * @return L'endurance de l'athlète.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Modifie l'endurance de l'athlète.
     *
     * @param endurance La nouvelle valeur d'endurance de l'athlète.
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Epreuve getEpreuve() {
        return this.ep;
    }

    /**
     * Simule la participation d'un athlète à une épreuve
     *
     * @return
     */
    @Override
    public double participer(Epreuve ep) {
        Random rm = new Random();
        int res = rm.nextInt(10) + 1;
        Sport sport = ep.getSportEpreuve();
        return (force * sport.getCoeffForce()) + (agilite * sport.getCoeffAgilite()) + (endurance * sport.getCoeffEndurance()) * res;
    }

    /**
     * Retourne une représentation textuelle de l'objet Athlete.
     *
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
    public boolean equals(Object objet) {
        if (objet == null) {
            return false;
        }

        if (objet == this) {
            return true;
        }

        if (!(objet instanceof Athlete)) {
            return false;
        }

        Athlete tmp = (Athlete) objet;
        return tmp.getNom().equals(this.nom) && tmp.getPrenom().equals(this.prenom);
    }

    /**
     * Redéfinition de l'ordre naturel de tri comme étant la somme de la force, de l'agilité et de l'endurance d'un athlète
     */
    @Override
    public int compareTo(Athlete ath) {
        return (this.force + this.agilite + this.endurance) - (ath.getForce() + ath.getAgilite() + ath.getEndurance());
    }
}