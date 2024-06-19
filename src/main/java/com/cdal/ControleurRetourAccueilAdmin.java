package main.java.com.cdal;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;

public class ControleurRetourAccueilAdmin implements EventHandler<ActionEvent> {
    private FenetreAjouterAthlete app;

    public ControleurRetourAccueilAdmin(FenetreAjouterAthlete app){
        this.app=app;
    }

    @Override
    public void handle(ActionEvent arg0) {
        Optional<ButtonType> result = app.popUpRetourAccueil().showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.YES)) {
            app.getApp().afficherAdministrateur();
        }
    }
    
}
