package main.java.com.cdal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new FenetreConnexion(this);
        this.scene = new Scene(root, 900, 700);
        stage.setScene(scene);
        stage.setTitle("Jeux IUT'Olympiques");
        stage.show();
    }

    public void afficherConnexion() {
        Pane root = new FenetreConnexion(this);
        scene.setRoot(root);
    }

    public void afficherInscription() {
        Pane root = new FenetreInscription(this);
        scene.setRoot(root);
    }

    public void afficherOrganisateur() {
        FenetreOrganisateur fenetreOrganisateur = new FenetreOrganisateur(this);
        new ControleurFenetreOrga(fenetreOrganisateur);
        scene.setRoot(fenetreOrganisateur);
    }

    public void afficherAdministrateur(){
        FenetreAdministrateur fenetreadministrateur = new FenetreAdministrateur(this);
        scene.setRoot(fenetreadministrateur);
    }

    public void afficherFentreAjouterAthlete(){
        FenetreAjouterAthlete afficherFentreAjouterAthlete = new FenetreAjouterAthlete(this);
        scene.setRoot(afficherFentreAjouterAthlete);
    }
}
