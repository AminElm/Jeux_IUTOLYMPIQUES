package main.java.com.cdal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

    private Scene scene;

    public static void main(String[] args){
        launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Pane root = new FenetreConnexion(this);
        this.scene = new Scene(root, 900, 700);
        stage.setScene(scene);
        stage.setTitle("Appli avec plusieurs fenêtres");
        stage.show();
    }

    public void afficherConnexion(){
        Pane root = new FenetreConnexion(this);
        scene.setRoot(root);
    }

    public void afficherInscription(){
        Pane root = new FenetreInscription(this);
        scene.setRoot(root);
    }

    public void afficherOrganisateur() {
        FenetreOrganisateur fenetreOrganisateur = new FenetreOrganisateur();
        new ControleurFenetreOrga(fenetreOrganisateur);
        scene.setRoot(fenetreOrganisateur);
    }
    
}
