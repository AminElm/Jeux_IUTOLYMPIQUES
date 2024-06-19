package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette classe représente une épreuve sportive
 */
public class Epreuve {
    /**
     *  Liste des équipes participant à l'épreuve
     */
    private List<Participant> participants;
    /**
    * Nom de l'épreuve
    */
    private String nom;
    /**
    * Sport de l'épreuve
    */
    private Sport sportEpreuve;

    private boolean colectif;
    /**
     * Constructeur de la classe Epreuve
     * @param participants Liste des équipes participant à l'épreuve
     * @param nom Nom de l'épreuve
     * @param sp Sport de l'épreuve
     */
    public Epreuve(List<Participant> participants, String nom, Sport sp, boolean colectif){
        this.participants = participants;
        this.nom = nom;
        this.sportEpreuve = sp;
        this.colectif = colectif;
    }
    /**
     * Constructeur de la classe Epreuve
     * @param nom Nom de l'épreuve
     * @param sp Sport de l'épreuve
     */
    public Epreuve(String nom, Sport sp, boolean colectif){
        this.participants = new ArrayList<>();
        this.nom = nom;
        this.sportEpreuve = sp;
        this.colectif = colectif;
    }
    /**
     * Getter de la liste des équipes participant à l'épreuve
     * @return Liste des équipes participant à l'épreuve
     */
    public List<Participant> getparticipants() {
        return participants;
    }

    public boolean isColectif(){
        return this.colectif;
    }
    /**
     * Définit la liste des équipes participant à l'épreuve
     * @param participants Liste des équipes participant à l'épreuve
     */
    public void setparticipants(List<Participant> participants) {
        this.participants = participants;
    }
    /**
     * ajoute le participant dans la liste
     */
    public void ajouteParticipant(Participant p){
        this.participants.add(p);
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

    public Map<Participant, Double> classement(){
        Map<Participant, Double> classement = new HashMap<>();
        for(Participant part : participants){
            classement.put(part, part.participer(this));
        }
        return classement;
    }
    @Override
    public String toString() {
        return "Epreuve [participants=" + participants + ", nom=" + nom + ", discipline=" + sportEpreuve + "]";
    }
    @Override 
    public boolean equals(Object obj) { 
        if (this == obj) return true; 
        if (obj == null) return false; 
        if (!(obj instanceof Epreuve))return false; 
        Epreuve tmp = (Epreuve) obj; 
        return this.nom == tmp.nom;
           
    } 
}

