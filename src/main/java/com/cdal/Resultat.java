package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultat {
    private List<Participant> participants;
    private Epreuve epreuve;

    public Resultat(List<Participant> participants, Epreuve epreuve) {
        this.participants = participants;
        this.epreuve = epreuve;
    }

    public void ajouteParticipant(Participant p){
        this.participants.add(p);
    }



    public List<Participant> getParticipants() {
        return participants;
    }

    public Participant meilleurParticipant() {
        if (participants.isEmpty()) {
            return null;
        }

        double meilleurScore = Double.MIN_VALUE;
        Participant meilleurParticipant = null;

        for (Participant p : participants) {
            double score = p.participer(epreuve);
            if (score > meilleurScore) {
                meilleurScore = score;
                meilleurParticipant = p;
            }
        }

        return meilleurParticipant;
    }

    public Participant pireParticipant() {
        if (participants.isEmpty()) {
            return null;
        }

        double pireScore = Double.MAX_VALUE;
        Participant pireParticipant = null;

        for (Participant p : participants) {
            double score = p.participer(epreuve);
            if (score < pireScore) {
                pireScore = score;
                pireParticipant = p;
            }
        }

        return pireParticipant;
    }

    public String attribuerMedaille() {
        if (participants.size() < 3) {
            return "Il n'y a pas assez de participants pour attribuer des médailles.";
        }

        Map<Participant, Double> scores = new HashMap<>();
        for (Participant p : participants) {
            scores.put(p, p.participer(epreuve));
        }

        List<Participant> classement = new ArrayList<>(scores.keySet());
        classement.sort((p1, p2) -> scores.get(p2).compareTo(scores.get(p1)));

        StringBuilder result = new StringBuilder();
        result.append("Médaille d'or: ").append(classement.get(0).getNom()).append("\n");
        result.append("Médaille d'argent: ").append(classement.get(1).getNom()).append("\n");
        result.append("Médaille de bronze: ").append(classement.get(2).getNom()).append("\n");

        return result.toString();
    }

    public String participantExiste(String nom) {
        for (Participant p : participants) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return "Le participant " + nom + " est bien dans la liste des résultats";
            }
        }
        return "Le participant " + nom + " n'est pas dans la liste des résultats";
    }

    public void supprimerParticipant(String nomParticipant) {
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).getNom().equalsIgnoreCase(nomParticipant)) {
                participants.remove(i);
                System.out.println("Le participant " + nomParticipant + " a été supprimé");
                return;
            }
        }
        System.out.println("Le participant " + nomParticipant + " n'est pas dans la liste des résultats");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Participant p : participants) {
            result.append(p.getNom()).append(": ").append(p.participer(epreuve)).append("\n");
        }
        return result.toString();
    }
}