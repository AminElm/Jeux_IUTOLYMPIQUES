import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Resultat {

    /**
     * Liste des équipes participant aux épreuves
     */
    private List<Equipe> equipes;

    /**
     * Liste des scores correspondant à chaque équipe
     */
    private List<Integer> scores;

    /**
     * Constructeur de la classe Resultat
     */
    public Resultat() {
        equipes = new ArrayList<>();
        scores = new ArrayList<>();
    }

    /**
     * Ajoute une équipe et son score aux résultats
     * @param nomEquipe Le nom de l'équipe
     * @param score Le score de l'équipe
     */
    public void ajouteEquipe(String nomEquipe, int score) {
        Equipe equi = new Equipe(nomEquipe);
        equipes.add(equi);
        scores.add(score);
    }

    /**
     * Retourne la liste des équipes participant aux épreuves
     * @return La liste des équipes
     */
    public List<Equipe> afficheEquipe() {
        return equipes;
    }

    /**
     * Retourne la liste des scores des équipes
     * @return La liste des scores
     */
    public List<Integer> afficheScore() {
        return scores;
    }

    /**
     * Retourne l'équipe ayant le meilleur score
     * @return L'équipe avec le meilleur score, ou null si aucune équipe n'est présente
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
     * Retourne l'équipe ayant le pire score
     * @return L'équipe avec le pire score, ou null si aucune équipe n'est présente
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
     * Trie les équipes par leurs scores de manière décroissante
     */
    public void trierEquipesParScores() {
        List<Integer> indices = IntStream.range(0, scores.size()).boxed().sorted((i, j) -> scores.get(j) - scores.get(i))
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
     * Vérifie si une équipe existe dans les résultats
     * @param nom Le nom de l'équipe à vérifier
     * @return Un message indiquant si l'équipe est présente ou non
     */
    public String equipeExiste(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return "L'équipe est bien dans la liste des résultats";
            }
        }
        return "L'équipe n'est pas dans la liste des résultats";
    }

    /**
     * Supprime une équipe et son score des résultats
     * @param nomEquipe Le nom de l'équipe à supprimer
     */
    public void supprimerEquipe(String nomEquipe) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getNom().equalsIgnoreCase(nomEquipe)) {
                equipes.remove(i);
                scores.remove(i);
                System.out.println("L'équipe " + nomEquipe + " a été supprimée");
                return;
            }
        }
    }

    /**
     * Ajoute un score à une équipe existante, ou ajoute l'équipe si elle n'existe pas
     * @param nomEquipe Le nom de l'équipe
     * @param score Le score à ajouter
     */
    public void ajouterScoreEquipe(String nomEquipe, int score) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getNom().equalsIgnoreCase(nomEquipe)) {
                scores.set(i, scores.get(i) + score);
                return;
            }
        }
        ajouteEquipe(nomEquipe, score);
    }

    /**
     * Retourne une représentation textuelle de l'objet Resultat
     * @return Une chaîne de caractères représentant les équipes et leurs scores
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < equipes.size(); i++) {
            result.append(equipes.get(i).getNom()).append(": ").append(scores.get(i)).append("\n");
        }
        return result.toString();
    }
}