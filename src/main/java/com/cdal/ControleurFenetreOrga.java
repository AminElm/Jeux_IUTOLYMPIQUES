package main.java.com.cdal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControleurFenetreOrga {

    private FenetreOrganisateur view;
    private Requete requete;

    public ControleurFenetreOrga(FenetreOrganisateur view) {
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
        view.getBoutonLancerEpreuve().setOnAction(e -> {
            try {
                lancerEpreuve();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        view.getBoutonEnregistrer().setOnAction(e -> enregistrerEpreuve());
        view.getBoutonInfo().setOnAction(e -> afficherInfo());
    }

    private void remplirComboBoxEpreuves() throws SQLException {
        List<Epreuve> epreuves = requete.ToutLesEpreuves();
        view.getComboBoxEpreuve().getItems().addAll(epreuves);
    }

    private void remplirTableAthletes(Epreuve epreuve) throws SQLException {
        if (epreuve != null) {
            List<Athlete> athletes = requete.touAthletesParEpreuve(epreuve);
            List<Athlete> athleteResults = new ArrayList<>();

            // Calcul des scores
            for (Athlete athlete : athletes) {
                double score = athlete.participer(epreuve);
                athlete.setScore(score); // Stockage temporaire du score
                athleteResults.add(athlete);
            }

            // Tri par score
            Collections.sort(athleteResults, (a1, a2) -> Double.compare(a2.getScore(), a1.getScore()));

            // Attribution des places
            int place = 1;
            for (Athlete athlete : athleteResults) {
                athlete.setPlace(place++);
            }

            // Mise à jour de la liste observable
            view.getListeAthletes().clear();
            view.getListeAthletes().addAll(athleteResults);
        }
    }

    private void lancerEpreuve() throws SQLException {
        Epreuve epreuve = view.getComboBoxEpreuve().getValue();
        if (epreuve != null) {
            System.out.println("L'épreuve " + epreuve.getNom() + " a été lancée.");
            remplirTableAthletes(epreuve);
        }
    }

    private void enregistrerEpreuve() {
        Epreuve epreuve = view.getComboBoxEpreuve().getValue();
        if (epreuve != null) {
            System.out.println("L'épreuve " + epreuve.getNom() + " a été enregistrée.");
            view.getComboBoxEpreuve().setValue(null);
            view.getComboBoxSport().setValue(null);
        }
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
}
