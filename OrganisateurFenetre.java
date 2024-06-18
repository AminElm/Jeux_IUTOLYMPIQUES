

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OrganisateurFenetre extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Épreuves");

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // UI Components
        Label epreuveLabel = new Label("Épreuve:");
        GridPane.setConstraints(epreuveLabel, 0, 0);

        ComboBox<String> epreuveComboBox = new ComboBox<>();
        epreuveComboBox.getItems().addAll("Épreuve 1", "Épreuve 2", "Épreuve 3");
        GridPane.setConstraints(epreuveComboBox, 1, 0);

        Label participantLabel = new Label("Participant:");
        GridPane.setConstraints(participantLabel, 0, 1);

        TextField participantTextField = new TextField();
        GridPane.setConstraints(participantTextField, 1, 1);

        Label resultatLabel = new Label("Résultat:");
        GridPane.setConstraints(resultatLabel, 0, 2);

        TextField resultatTextField = new TextField();
        GridPane.setConstraints(resultatTextField, 1, 2);

        Button lancerEpreuveButton = new Button("Lancer Épreuve");
        GridPane.setConstraints(lancerEpreuveButton, 1, 3);

        Button enregistrerResultatButton = new Button("Enregistrer Résultat");
        GridPane.setConstraints(enregistrerResultatButton, 1, 4);

        grid.getChildren().addAll(epreuveLabel, epreuveComboBox, participantLabel, participantTextField, resultatLabel, resultatTextField, lancerEpreuveButton, enregistrerResultatButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
