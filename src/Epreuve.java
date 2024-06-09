import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente une épreuve sportive
 */
public class Epreuve {

    /**
     *  Liste des équipes participant à l'épreuve
     */
    private List<Equipe> equipes;

    /**
    * Nom de l'épreuve
    */
    private String nom;

    /**
    * Type de l'épreuve
    */
    private String typeEpreuve;

    /**
     * Constructeur de la classe Epreuve
     * @param equipes Liste des équipes participant à l'épreuve
     * @param nom Nom de l'épreuve
     * @param typeEpreuve Type de l'épreuve
     */
    public Epreuve(List<Equipe> equipes, String nom, String typeEpreuve){
        this.equipes = equipes;
        this.nom = nom;
        this.typeEpreuve = typeEpreuve;
    }

    /**
     * Constructeur de la classe Epreuve
     * @param nom Nom de l'épreuve
     * @param typeEpreuve Type de l'épreuve
     */
    public Epreuve(String nom, String typeEpreuve){
        this.equipes = new ArrayList<>();
        this.nom = nom;
        this.typeEpreuve = typeEpreuve;
    }

    /**
     * Getter de la liste des équipes participant à l'épreuve
     * @return Liste des équipes participant à l'épreuve
     */
    public List<Equipe> getEquipes() {
        return equipes;
    }

    /**
     * Définit la liste des équipes participant à l'épreuve
     * @param equipes Liste des équipes participant à l'épreuve
     */
    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
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
     * getter du type de l'épreuve
     * @return Le type de l'épreuve
     */
    public String getTypeEpreuve() {
        return typeEpreuve;
    }

    /**
     * Définit le type de l'épreuve
     * @param typeEpreuve Le type de l'épreuve
     */
    public void setTypeEpreuve(String typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    @Override
    public String toString() {
        return "Epreuve [equipes=" + equipes + ", nom=" + nom + ", typeEpreuve=" + typeEpreuve + "]";
    }
}