import java.util.ArrayList;
import java.util.List;

public class Epreuve {

    private List<Equipe> equipes;
    private String nom;
    private String typeEpreuve;

    public Epreuve(List<Equipe> equipes, String nom, String typeEpreuve){
        this.equipes = equipes;
        this.nom = nom;
        this.typeEpreuve = typeEpreuve;
    }

    public Epreuve(String nom, String typeEpreuve){
        this.equipes = new ArrayList<>();
        this.nom = nom;
        this.typeEpreuve = typeEpreuve;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeEpreuve() {
        return typeEpreuve;
    }

    public void setTypeEpreuve(String typeEpreuve) {
        this.typeEpreuve = typeEpreuve;
    }

    @Override
    public String toString() {
        return "Epreuve [equipes=" + equipes + ", nom=" + nom + ", typeEpreuve=" + typeEpreuve + "]";
    }
}