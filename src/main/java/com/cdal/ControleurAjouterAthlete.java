import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouterAthlete implements EventHandler<ActionEvent> {
    private FenetreAdministrateur app;

    public ControleurAjouterAthlete( FenetreAdministrateur app){
        this.app=app;
    }

    @Override
    public void handle(ActionEvent event) {
        app.modeAjouterAthlete();
        app.activerBoutonMaison();
    }

    
}
