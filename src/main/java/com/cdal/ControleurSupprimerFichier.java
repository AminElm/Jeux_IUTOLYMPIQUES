package main.java.com.cdal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurSupprimerFichier implements EventHandler<ActionEvent> {

    private FenetreAdministrateur app;
    private ControleurChargerFichier controleurChargerFichier;

    public ControleurSupprimerFichier(FenetreAdministrateur app, ControleurChargerFichier controleurChargerFichier) {
        this.app = app;
        this.controleurChargerFichier = controleurChargerFichier;
    }

    @Override
    public void handle(ActionEvent event) {
        this.controleurChargerFichier.suppFichier();
    }

}
