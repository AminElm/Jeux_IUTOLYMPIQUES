import java.util.ArrayList;
import java.util.List;


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

    public List<Equipe> getEquipe() {
        return equipes;
    }

    public List<Integer> getScore() {
        return scores;
    }

    public Equipe meilleurEquipe() {
        if (equipes.isEmpty() || scores.isEmpty()){
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
        List<Equipe> equipesTriees = new ArrayList<>(equipes);
        List<Integer> scoresTries = new ArrayList<>(scores);

        for (int i = 0; i < scoresTries.size() - 1; i++) {
            for (int j = i + 1; j < scoresTries.size(); j++) {
                if (scoresTries.get(i) < scoresTries.get(j)) {
                    int tempScore = scoresTries.get(i);
                    scoresTries.set(i, scoresTries.get(j));
                    scoresTries.set(j, tempScore);

                    Equipe tempEquipe = equipesTriees.get(i);
                    equipesTriees.set(i, equipesTriees.get(j));
                    equipesTriees.set(j, tempEquipe);
                }
            }
        }

        equipes = equipesTriees;
        scores = scoresTries;
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

    public String attribuerMedaille() {
        trierEquipesParScores();
    
        if (equipes.size() < 3) {
            return "Il n'y a pas assez d'équipes pour attribuer des médailles.";
        }
    
        StringBuilder result = new StringBuilder();
        result.append("Médaille d'or: ").append(equipes.get(0).getNom()).append("\n");
        result.append("Médaille d'argent: ").append(equipes.get(1).getNom()).append("\n");
        result.append("Médaille de bronze: ").append(equipes.get(2).getNom()).append("\n");
    
        return result.toString();
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
                System.out.println("l'équipe "+nomEquipe+" à été supprimé");
            }
        }

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
