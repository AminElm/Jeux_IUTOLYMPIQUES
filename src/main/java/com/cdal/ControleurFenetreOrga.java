package main.java.com.cdal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import java.sql.SQLException;
import java.util.List;

public class ControleurFenetreOrga {

    private FenetreOrganisateur view;
    private Main application;
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
        view.getBoutonLancerEpreuve().setOnAction(e -> lancerEpreuve());
        view.getBoutonEnregistrer().setOnAction(e -> enregistrerEpreuve());
        view.getBoutonInfo().setOnAction(e -> application.popUpInfoOrga());
    }

    private void remplirComboBoxEpreuves() throws SQLException {
        List<Epreuve> epreuves = requete.ToutLesEpreuves();
        view.getComboBoxEpreuve().getItems().addAll(epreuves);
    }

    private void lancerEpreuve() {
        Epreuve epreuve = view.getComboBoxEpreuve().getValue();
        String sport = view.getComboBoxSport().getValue();
        if (epreuve != null && sport != null) {
            // Logique pour lancer l'épreuve
            System.out.println("L'épreuve " + epreuve.getNom() + " a été lancée.");
        }
    }

    private void enregistrerEpreuve() {
        Epreuve epreuve = view.getComboBoxEpreuve().getValue();
        String sport = view.getComboBoxSport().getValue();
        if (epreuve != null && sport != null) {
            // Logique pour enregistrer l'épreuve
            view.getListeEpreuves().add(epreuve);
            System.out.println("L'épreuve " + epreuve.getNom() + " a été enregistrée.");
            view.getComboBoxEpreuve().setValue(null);
            view.getComboBoxSport().setValue(null);
        }
    }

}
