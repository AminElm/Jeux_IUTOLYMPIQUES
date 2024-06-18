package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;

public class Resultat {


    private Map<Participant, Integer> scores;
    private Epreuve epreuve;

    public Resultat(List<Participant> participants, Epreuve epreuve) {
        this.epreuve = epreuve;
        this.scores = new HashMap<>();
        for (Participant participant : participants) {
            this.scores.put(participant, (int) participant.participer(epreuve));
        }
    }

    public Participant meilleurParticipant() {
        Participant meilleur = null;
        int meilleurScore = Integer.MIN_VALUE;
        for (Map.Entry<Participant, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > meilleurScore) {
                meilleurScore = entry.getValue();
                meilleur = entry.getKey();
            }
        }
        return meilleur;
    }

    public Participant pireParticipant() {
        Participant pire = null;
        int pireScore = Integer.MAX_VALUE;
        for (Map.Entry<Participant, Integer> entry : scores.entrySet()) {
            if (entry.getValue() < pireScore) {
                pireScore = entry.getValue();
                pire = entry.getKey();
            }
        }
        return pire;
    }

    public String attribuerMedaille() {
        if (scores.size() < 3) {
            return "Il n'y a pas assez de participants pour attribuer des médailles.";
        }

        List<Map.Entry<Participant, Integer>> list = new ArrayList<>(scores.entrySet());
        list.sort(new ScoreComparator());

        StringBuilder result = new StringBuilder();
        result.append("Médaille d'or: ").append(list.get(0).getKey().getNom()).append("\n");
        result.append("Médaille d'argent: ").append(list.get(1).getKey().getNom()).append("\n");
        result.append("Médaille de bronze: ").append(list.get(2).getKey().getNom()).append("\n");
        return result.toString();
    }

    public String participantExiste(String nom) {
        for (Participant participant : scores.keySet()) {
            if (participant.getNom().equalsIgnoreCase(nom)) {

                return "Le participant " + nom + " est bien dans la liste des résultats";
            }
        }
        return "Le participant " + nom + " n'est pas dans la liste des résultats";
    }

    public void supprimerParticipant(String nomParticipant) {

        List<Participant> participantsToRemove = new ArrayList<>();
        for (Participant participant : scores.keySet()) {
            if (participant.getNom().equalsIgnoreCase(nomParticipant)) {
                participantsToRemove.add(participant);
            }
        }
        for (Participant participant : participantsToRemove) {
            scores.remove(participant);
        }
    }

    public void trierResultatsParScore() {
        Map<Participant, Integer> sortedScores = new LinkedHashMap<>();
        List<Map.Entry<Participant, Integer>> entryList = new ArrayList<>(scores.entrySet());
        entryList.sort(new ScoreComparator());
        for (Map.Entry<Participant, Integer> entry : entryList) {
            sortedScores.put(entry.getKey(), entry.getValue());
        }
        scores = sortedScores;

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Participant, Integer> entry : scores.entrySet()) {
            result.append(entry.getKey().getNom()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }
}

