package main.java.com.cdal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import java.sql.SQLException;
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
        view.getLancerEp().setOnAction(e -> lancerEpreuve());
        view.getBtnEnregistrer().setOnAction(e -> enregistrerEpreuve());
        view.getInfoButton().setOnAction(e -> popUpInfo());
    }

    private void remplirComboBoxEpreuves() throws SQLException {
        List<Epreuve> epreuves = requete.ToutLesEpreuves();
        view.getChoixEpreuve().getItems().addAll(epreuves);
    }

    private void lancerEpreuve() {
        Epreuve epreuve = view.getChoixEpreuve().getValue();
        String sport = view.getChoixSport().getValue();
        if (epreuve != null && sport != null) {
            // Logique pour lancer l'épreuve
            System.out.println("L'épreuve " + epreuve.getNom() + " a été lancée.");
        }
    }

    private void enregistrerEpreuve() {
        Epreuve epreuve = view.getChoixEpreuve().getValue();
        String sport = view.getChoixSport().getValue();
        if (epreuve != null && sport != null) {
            // Logique pour enregistrer l'épreuve
            view.getEpreuves().add(epreuve);
            System.out.println("L'épreuve " + epreuve.getNom() + " a été enregistrée.");
            view.getChoixEpreuve().setValue(null);
            view.getChoixSport().setValue(null);
        }
    }

    private void popUpInfo() {
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
