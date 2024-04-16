import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Equipe {
    private String nomEquipe; // Le nom de l'équipe
    private List<Athlete> lesAthletes; // La liste des athlètes de l'équipe

    /**
     * Constructeur de la classe Equipe.
     * @param nomEquipe Le nom de l'équipe.
     */
    public Equipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.lesAthletes = new ArrayList<>();
    }

    /**
     * Obtient le nom de l'équipe.
     * @return Le nom de l'équipe.
     */
    public String getNom() {
        return this.nomEquipe;
    }

    /**
     * Définit le nom de l'équipe.
     * @param newNomEquipe Le nouveau nom de l'équipe.
     */
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
}
