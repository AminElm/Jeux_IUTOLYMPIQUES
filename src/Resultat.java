import java.util.ArrayList;
import java.util.List;



public class Resultat {
    private List<Equipe> equipes;
    private List<Integer> scores;

    public Resultat(){
        equipes = new ArrayList<>();
        scores = new ArrayList<>();
    }

    public void ajouteEquipe(String nomEquipe, int score){
        Equipe equi = new Equipe(nomEquipe);
        equipes.add(equi);
        scores.add(score);
    }
    

    public List<Equipe> afficheEquipe(){
        return equipes;
    }

    public List<Integer> afficheScore(){
        return scores;
    }

    public Equipe meilleurEquipe(){
        if(equipes.isEmpty() || scores.isEmpty()){
            return null;
        }

        int meilleurScore = scores.get(0);
        Equipe meilleurEquipe = equipes.get(0);

        for(int i = 1; i < scores.size(); i++){
            if(meilleurScore < scores.get(i)){
                meilleurScore = scores.get(i);
                meilleurEquipe = equipes.get(i);
            }
        }
        return meilleurEquipe;
    }

    public Equipe pireEquipe(){
        if(equipes.isEmpty() || scores.isEmpty()){
            return null;
        }

        int pireScore = scores.get(0);
        Equipe pireEquipe = equipes.get(0);

        for(int i = 1; i < scores.size(); i++){
            if(pireScore > scores.get(i)){
                pireScore = scores.get(i);
                pireEquipe = equipes.get(i);
            }
        }
        return pireEquipe;
    }


    public void trierEquipesParScores() {
        
        List<Equipe> equipesTrier = new ArrayList<>(equipes);
        List<Integer> scoresTrier = new ArrayList<>(scores);
    
        for (int i = 0; i < scoresTrier.size()-1; i++) {
            for (int j = i + 1; j < scoresTrier.size(); j++) {
                if (scoresTrier.get(i) < scoresTrier.get(j)) {
                    int score = scoresTrier.get(i);
                    scoresTrier.set(i, scoresTrier.get(j));
                    scoresTrier.set(j, score);
    
                    Equipe equipe = equipesTrier.get(i);
                    equipesTrier.set(i, equipesTrier.get(j));
                    equipesTrier.set(j, equipe);
                }
            }
        }
    
        equipes = equipesTrier;
        scores = scoresTrier;
    }
    


    public Equipe rechercheEquipeParNom(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return equipe;
            }
        }
        return null;
    }
    



    public boolean equipeExiste(String nom) {
        for (Equipe equipe : equipes) {
            if (equipe.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }
    

    


    public void supprimerEquipe(String nomEquipe) {
        for (int i = 0; i < equipes.size(); i++) {
            if (equipes.get(i).getNom().equalsIgnoreCase(nomEquipe)) {
                equipes.remove(i);
                scores.remove(i);
            }
        }

    }
    
    



    @Override
    public String toString() {
        try {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < equipes.size(); i++) {
                result.append(equipes.get(i)).append(": ").append(scores.get(i)).append("\n");
            }
            return result.toString();
        } catch (Exception e) {
            return "Erreur: " + e.getMessage();
        }
    }
    
    
}
