import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Cette classe représente les résultats d'une épreuve sportive, comprenant les équipes participantes et leurs scores.
 */
public class Resultat {
    private List<Equipe> equipes; // Liste des équipes participantes
    private List<Integer> scores; // Liste des scores des équipes

    /**
     * Constructeur par défaut de la classe Resultat
     */
    public Resultat() {
        equipes = new ArrayList<>();
        scores = new ArrayList<>();
    }

    /**
     * Ajoute une équipe et son score aux résultats
     * @param equipe L'équipe à ajouter
     * @param score Le score de l'équipe
     */
    public void ajouteEquipe(Equipe equipe, int score) {
        equipes.add(equipe);
        scores.add(score);
    }

    /**
     * Renvoie la liste des équipes participantes
     * @return La liste des équipes
     */
    public List<Equipe> afficheEquipe() {
        return equipes;
    }

    /**
     * Renvoie la liste des scores des équipes
     * @return La liste des scores
     */
    public List<Integer> afficheScore() {
        return scores;
    }

    /**
     * Détermine la meilleure équipe en fonction de son score
     * @return La meilleure équipe
     */
    public Equipe meilleurEquipe() {
        if (equipes.isEmpty() || scores.isEmpty()) {
            return null;
        }

        int meilleurScore = scores.get(0);
        Equipe meilleurEquipe = equipes.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if (meilleurScore < scores.get(i)) {
                meilleurScore = scores.get(i);
                meilleurEquipe = equipes.get(i);
            }
        }
        return meilleurEquipe;
    }

    /**
     * Détermine la pire équipe en fonction de son score
     * @return La pire équipe
     */
    public Equipe pireEquipe() {
        if (equipes.isEmpty() || scores.isEmpty()) {
            return null;
        }

        int pireScore = scores.get(0);
        Equipe pireEquipe = equipes.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if (pireScore > scores.get(i)) {
                pireScore = scores.get(i);
                pireEquipe = equipes.get(i);
            }
        }
        return pireEquipe;
    }

    /**
     * Trie les équipes par scores dans l'ordre décroissant
     */
    public void trierEquipesParScores() {
        List<Integer> indices = IntStream.range(0, scores.size())
                .boxed()
                .sorted((i, j) -> scores.get(j) - scores.get(i))
                .collect(Collectors.toList());

        List<Equipe> equipesTrie = new ArrayList<>();
        List<Integer> scoresTrie = new ArrayList<>();

        for (Integer index : indices) {
            equipesTrie.add(equipes.get(index));
            scoresTrie.add(scores.get(index));
        }

        equipes = equipesTrie;
        scores = scoresTrie;
    }

    /**
     * Recherche une équipe par son nom dans les résultats
     * @param nom Le nom de l'équipe à rechercher
     * @return L'équipe correspondante ou null si non trouvée
     */
    public Equipe rechercheEquipeParNom(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return equipe;
            }
        }
        return null;
    }

    /**
     * Vérifie si une équipe existe dans les résultats
     * @param nom Le nom de l'équipe à vérifier
     * @return Un message indiquant si l'équipe existe ou non
     */
    public String equipeExiste(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return "L'equipe est bien dans la liste des résultats";
            }
        }
        return "L'equipe n'est pas dans la liste des résultats";
    }

    /**
     * Supprime une équipe des résultats par son nom
     * @param nomEquipe Le nom de l'équipe à supprimer
     */
    public void supprimerEquipe(String nomEquipe) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getNom().equalsIgnoreCase(nomEquipe)) {
                equipes.remove(i);
                scores.remove(i);
            }
        }
        System.out.println("l'équipe "+nomEquipe+" à été supprimé");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < equipes.size(); i++) {
            result.append(equipes.get(i).getNom()).append(": ").append(scores.get(i)).append("\n");
        }
        return result.toString();
    }
    
}
