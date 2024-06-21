package main.java.com.cdal;

import java.util.Random;

public class Athlete implements Comparable<Athlete>, Participant {
    private String nom;
    private Boolean enEquipe;
    private final String prenom;
    private final char sexe;
    private final Pays nationalite;
    private int force;
    private int agilite;
    private int endurance;
    private Epreuve ep;

    // Champs temporaires pour l'affichage
    private double score;
    private int place;

    public Athlete(String nom, String prenom, char sexe, Pays nationalite, int force, int agilite, int endurance, Boolean enEquipe, Epreuve ep) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.enEquipe = enEquipe;
        this.ep = ep;
    }

    public Athlete(String nom, String prenom, char sexe, Pays nationalite, int force, int agilite, int endurance, boolean enEquipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
        this.enEquipe = enEquipe;
    }

    public String getNom() {
        return this.nom;
    }

    public Boolean getEnEquipe() {
        return this.enEquipe;
    }

    public void setNom(String newNomAthlete) {
        this.nom = newNomAthlete;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public char getSexe() {
        return this.sexe;
    }

    public Pays getNationalite() {
        return this.nationalite;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgilite() {
        return this.agilite;
    }

    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Epreuve getEpreuve() {
        return this.ep;
    }

    public double participer(Epreuve ep) {
        Random rm = new Random();
        int res = rm.nextInt(10) + 1;
        Sport sport = ep.getSportEpreuve();
        return (force * sport.getCoeffForce()) + (agilite * sport.getCoeffAgilite()) + (endurance * sport.getCoeffEndurance()) * res;
    }

    @Override
    public String toString() {
        return this.prenom + " " + this.nom + " de " + this.nationalite;
    }

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
        return tmp.getNom().equals(this.nom) && tmp.getPrenom().equals(this.prenom) && tmp.getNationalite().equals(this.nationalite) && tmp.getSexe() == this.sexe;
    }

    @Override
    public int compareTo(Athlete ath) {
        return (this.force + this.agilite + this.endurance) - (ath.getForce() + ath.getAgilite() + ath.getEndurance());
    }

    // Méthodes pour le score et la place
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}
