package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerFichier implements EventHandler<ActionEvent> {

    private FenetreAdministrateur app;
    private ControleurChargerFichier fichier;

    public ControleurSupprimerFichier(FenetreAdministrateur app) {
        this.app = app;
        this.fichier = app.getFichier(); // Récupérez le contrôleur initialisé depuis FenetreAdministrateur
    }

    @Override
    public void handle(ActionEvent event) {
        if (fichier != null) {
            fichier.suppFichier(); // Assurez-vous que fichier n'est pas null avant d'appeler la méthode
        }
        app.setTextFichierCharger("Charger un fichier .CSV");
        app.activerBoutontSupp(false);
    }
}

