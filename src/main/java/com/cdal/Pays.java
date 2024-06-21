package main.java.com.cdal;

import java.util.List;
import java.util.ArrayList;

public class Pays {
    /**
     * Nom du pays
     */
    private String nom;

    /**
     * Liste des participants représentant le pays
     */
    private List<Participant> lesParticipants;

    /**
     * Nombre total d'athlètes du pays
     */
    private int nbAthletesPays;

    /**
     * Constructeur de la classe Pays.
     * @param nom Le nom du pays
     * @param nbAthletesPays Le nombre total d'athlètes du pays
     */

    public Pays(String nom) {
        this.nom = nom;
        this.lesParticipants = new ArrayList<>();
        this.nbAthletesPays = 0;

    }

    /**
     * getter du nom du pays
     * @return Le nom du pays.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * getter de la liste des participants du pays
     * @return La liste des participants.
     */
    public List<Participant> getParticipants() {
        return this.lesParticipants;
    }

    /**
     * Ajoute un participant à la liste des participants du pays
     * @param participant Le participant à ajouter
     */
    public void ajouterParticipant(Participant participant) {
        this.lesParticipants.add(participant);

        this.nbAthletesPays += 1;

    }

    @Override
    public String toString(){
        return this.nom;
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

