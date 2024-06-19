import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Contrôleur à activer lorsque l'on clique sur le bouton info
 */
public class ControleurInfoAccueil implements EventHandler<ActionEvent> {

    private FenetreAdministrateur app;

    /**
     * @param p vue du jeu
     */
    public ControleurInfoAccueil(FenetreAdministrateur app) {
        this.app = app;
    }

    /**
     * L'action consiste à afficher une fenêtre popup précisant les règles du jeu.
     * @param actionEvent l'événement action
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        this.app.popUpInfoAccueil().showAndWait();
    }
}
