import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Resultat {
    private List<Equipe> equipes;
    private List<Integer> scores;

    public Resultat() {
        equipes = new ArrayList<>();
        scores = new ArrayList<>();
    }

    public void ajouteEquipe(String nomEquipe, int score) {
        Equipe equi = new Equipe(nomEquipe);
        equipes.add(equi);
        scores.add(score);
    }

    public List<Equipe> afficheEquipe() {
        return equipes;
    }

    public List<Integer> afficheScore() {
        return scores;
    }

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

    public Equipe rechercheEquipeParNom(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return equipe;
            }
        }
        return null;
    }

    public String equipeExiste(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return "L'equipe est bien dans la liste des résultats";
            }
        }
        return "L'equipe n'est pas dans la liste des résultats";
    }

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
