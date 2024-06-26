package main.java.com.cdal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipe implements Participant{
     /**
     * Nom de l'équipe
     */
    private String nomEquipe;

    /**
     * Liste des épreuves auxquelles l'équipe participe
     */
    private Epreuve ep;

    /**
     * Liste des athlètes de l'équipe
     */
    private List<Athlete> lesAthletes;
 
     /**
     * Nom de l'équipe
     */
     private Pays pays;

    /**
     * Constructeur de la classe Equipe.
     * @param nomEquipe Le nom de l'équipe.
     */
    public Equipe(String nomEquipe, Epreuve ep, Pays p) {
        this.nomEquipe = nomEquipe;
        this.lesAthletes = new ArrayList<>();
        this.ep = ep;
        this.pays = p;
    }

    /**
     * Obtient le nom de l'équipe.
     * @return Le nom de l'équipe.
     */
    @Override
    public String getNom() {
        return this.nomEquipe;
    }

    public Pays getPays(){
        return this.pays;
    }

    /**
     * Définit le nom de l'équipe.
     * @param newNomEquipe Le nouveau nom de l'équipe.
     */
    @Override
    public void setNom(String newNomEquipe) {
        this.nomEquipe = newNomEquipe;
    }

    /**
     * Obtient la liste des athlètes de l'équipe.
     * @return La liste des athlètes de l'équipe.
     */
    public List<Athlete> getAthletes() {
        return this.lesAthletes;
    }

    /**
     * Ajoute un athlète à l'équipe si l'athlète n'est pas déjà présent dans l'équipe.
     * @param ath L'athlète à ajouter.
     */
    public void ajouteAthlete(Athlete ath) {
        if (!(this.lesAthletes.contains(ath))) {
            this.lesAthletes.add(ath);
        }
    }

    public Epreuve getEpreuves() {
        return this.ep;
    }

    /**
     * Trie la liste des athlètes de l'équipe en utilisant l'ordre naturel défini dans la classe Athlete.
     */
    public void trierListe() {
        Collections.sort(this.lesAthletes);
    }

   /**
    * Obtient l'athlète le plus fort de l'équipe en fonction de la force.
    * @return L'athlète le plus fort.
    */
   public Athlete plusFort() {
       Athlete athletePlusFort = null;
       int maxForce = Integer.MIN_VALUE;
       for (Athlete a : this.lesAthletes) {
           if (a.getForce() > maxForce) {
               maxForce = a.getForce();
               athletePlusFort = a;
           }
       }
       return athletePlusFort;
   }

   /**
    * Obtient l'athlète le plus endurant de l'équipe en fonction de l'endurance.
    * @return L'athlète le plus endurant.
    */
   public Athlete plusEndurant() {
       Athlete athletePlusEndurant = null;
       int maxEndurance = Integer.MIN_VALUE;
       for (Athlete a : this.lesAthletes) {
           if (a.getEndurance() > maxEndurance) {
               maxEndurance = a.getEndurance();
               athletePlusEndurant = a;
           }
       }
       return athletePlusEndurant;
   }

   /**
    * Obtient l'athlète le plus agile de l'équipe en fonction de l'agilité.
    * @return L'athlète le plus agile.
    */
   public Athlete plusAgile() {
       Athlete athletePlusAgile = null;
       int maxAgilite = Integer.MIN_VALUE;
       for (Athlete a : this.lesAthletes) {
           if (a.getAgilite() > maxAgilite) {
               maxAgilite = a.getAgilite();
               athletePlusAgile = a;
           }
       }
       return athletePlusAgile;
   }

   @Override
   public double participer(Epreuve ep){
       double scoreEquipe = 0;
       double cpt_sport = 0;
       for(Athlete ath : lesAthletes){
           if(ath.getEpreuve().equals(ep)){
               scoreEquipe += ath.participer(ep);
               cpt_sport++;
           }
       }
       if (cpt_sport > 0){
           return scoreEquipe/cpt_sport;
       }
       else{
           return 0;
       }
   }

   /**
    * Retourne une représentation textuelle de l'équipe.
    * @return Une chaîne de caractères représentant l'équipe et ses athlètes.
    */
   @Override
   public String toString() {
       return "" + this.nomEquipe + " (" + this.pays.getNom() + ")";
   }

   /**
    * Redéfinition de la méthode equals pour utiliser les méthodes contains, indexOf etc...
    */
   @Override
   public boolean equals(Object objet){
       if(objet == null){return false;}

       if(objet==this){return true;}

       if(!(objet instanceof Equipe)){return false;}

       Equipe tmp = (Equipe) objet;
       return tmp.getNom().equals(this.nomEquipe);
   }

}
