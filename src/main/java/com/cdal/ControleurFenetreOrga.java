package main.java.com.cdal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;

public class ControleurFenetreOrga{

    private FenetreOrganisateur view;

    public ControleurFenetreOrga(FenetreOrganisateur view){
        this.view = view;
        initControleur();
    }

    private void initControleur(){
        view.getLancerEp().setOnAction(e -> lancerEpreuve());
        view.getBtnEnregistrer().setOnAction(e -> enregistrerEpreuve());
        view.getInfoButton().setOnAction(e -> popUpInfo());
    }

    private void lancerEpreuve(){
        String nomEpreuve = view.getTfEpreuve().getText();
        String sport = view.getChoixSport().getValue();
        if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
            Sport sportEpreuve = getNomSport(sport);
            Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
            // lancement d'epreuve à ajouter
            System.out.println("L'épreuve " + nomEpreuve + " a été lancée.");
        }
    }

    private void enregistrerEpreuve(){
        String nomEpreuve = view.getTfEpreuve().getText();
        String sport = view.getChoixSport().getValue();
        if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
            Sport sportEpreuve = getNomSport(sport);
            Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
            view.getEpreuves().add(epreuve);
            System.out.println("L'épreuve " + nomEpreuve + " a été enregistrée.");
            view.getTfEpreuve().clear();
            view.getChoixSport().setValue(null);
        }
    }

    private Sport getNomSport(String sportName){
        switch (sportName){
            case "Athlétisme":
                return new Athletisme();
            case "Escrime":
                return new Escrime();
            case "VolleyBall":
                return new VolleyBall();
            case "Natation":
                return new Natation();
            case "Handball":
                return new Handball();
            default:
                return null;
        }
    }

    private void popUpInfo(){
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
