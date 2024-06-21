package main.java.com.cdal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControleurFenetreVisit {

    private FenetreVisiteur view;
    private Requete requete;

    public ControleurFenetreVisit(FenetreVisiteur view) {
        this.view = view;
        try {
            this.requete = new Requete();
            remplirComboBoxEpreuves();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        initControleur();
    }

    private void initControleur() {
        view.getboutonMontrerEpreuve().setOnAction(e -> {
            try {
                voirEpreuve();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        view.getBoutonInfo().setOnAction(e -> afficherInfo());
    }

    private void remplirComboBoxEpreuves() throws SQLException {
        List<Epreuve> epreuves = requete.ToutLesEpreuves();
        view.getComboBoxEpreuve().getItems().addAll(epreuves);
    }

    private void remplirTableAthletes(Epreuve epreuve) throws SQLException {
        if (epreuve != null) {
            List<Athlete> athletes = requete.touAthletesParEpreuve(epreuve);
            Resultat resultat = new Resultat(new ArrayList<>(athletes), epreuve);

            view.getListeAthletes().clear();
            int place = 1;
            for (Map.Entry<Participant, Integer> entry : resultat.getScores().entrySet()) {
                Participant participant = entry.getKey();
                double score = entry.getValue();
                AthleteTemp athleteTemp = new AthleteTemp((Athlete) participant, score, place++);
                view.getListeAthletes().add(athleteTemp);
            }
        }
    }

    private void voirEpreuve() throws SQLException {
        Epreuve epreuve = view.getComboBoxEpreuve().getValue();
        String sport = view.getComboBoxSport().getValue();
        remplirTableAthletes(epreuve);

    }

    private void afficherInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Fonctionnalités de l'Organisateur");
        alert.setContentText("Sur cette page, vous pouvez:\n\n" +
                "- Lancer une épreuve : Cette action consiste à calculer le score des participants et créer le classement pour l'épreuve donnée.\n" +
                "- Enregistrer une épreuve : Cette action consiste à sauvegarder l'épreuve dans le tableau.");
        alert.showAndWait();
    }

    // Classe temporaire pour afficher les résultats dans la table
    public static class AthleteTemp {
        private final Athlete athlete;
        private final double score;
        private final int place;

        public AthleteTemp(Athlete athlete, double score, int place) {
            this.athlete = athlete;
            this.score = score;
            this.place = place;
        }

        public String getNom() {
            return athlete.getNom();
        }

        public String getPrenom() {
            return athlete.getPrenom();
        }

        public String getNationalite() {
            return athlete.getNationalite().getNom();
        }

        public double getScore() {
            return score;
        }

        public int getPlace() {
            return place;
        }
    }
}
