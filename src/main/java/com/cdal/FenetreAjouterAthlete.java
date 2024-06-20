package main.java.com.cdal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreAjouterAthlete extends BorderPane {
        /**
     * le titre
     */
    private Label titre;
    /**
     * le bouton info
     */
    private Button boutonInfo;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonDeconnexion;

    private Main application;

    /**
     * boutton pour cree l'athlete
     */ 
    private Button creeAthlete;

    public FenetreAjouterAthlete(Main app){
        super();
        this.application = app;

        this.setTop(creerEnTete());
        this.setCenter(modeAjouterAthlete());
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }


    
    private StackPane creerEnTete(){
        StackPane panneauEntete = new StackPane();
        panneauEntete.setPadding(new Insets(15, 12, 15, 12));
        panneauEntete.setStyle("-fx-background-color: #f0f0f0;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label labelTitre = new Label("Création d'athlète");
        labelTitre.setFont(new Font("System Bold", 24));
        labelTitre.setTextFill(Color.BLACK);

        boutonDeconnexion = new Button();
        ImageView imageDeconnexion = new ImageView(new Image("file:img/logout.png"));
        imageDeconnexion.setFitHeight(30);
        imageDeconnexion.setPreserveRatio(true);
        boutonDeconnexion.setGraphic(imageDeconnexion);
        boutonDeconnexion.setOnAction(e -> application.afficherConnexion());
        boutonDeconnexion.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonDeconnexion.setOnMouseEntered(e -> boutonDeconnexion.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 50%; -fx-padding: 8;"));
        boutonDeconnexion.setOnMouseExited(e -> boutonDeconnexion.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        boutonInfo = new Button();
        ImageView imageInfo = new ImageView(new Image("file:img/info.png"));
        imageInfo.setFitHeight(30);
        imageInfo.setPreserveRatio(true);
        boutonInfo.setOnAction(e -> application.popUpInfoAdmin());
        boutonInfo.setGraphic(imageInfo);
        boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonInfo.setOnMouseEntered(e -> boutonInfo.setStyle("-fx-background-radius: 50%; -fx-padding: 8;"));
        boutonInfo.setOnMouseExited(e -> boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));
        boutonInfo.setOnAction(e -> application.popUpInfoAthlete());

        HBox hBoxBoutons = new HBox(10, boutonDeconnexion, boutonInfo);
        hBoxBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(labelTitre, Pos.CENTER);
        StackPane.setAlignment(hBoxBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, labelTitre, hBoxBoutons);

        return panneauEntete;
    }



    public GridPane modeAjouterAthlete(){

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(30,0,0,30));

        Label labelNom = new Label("Nom:");
        TextField TfNom = new TextField();
        grid.add(labelNom, 0, 0); 
        grid.add(TfNom, 1, 0); 

        Label labelPrenom = new Label("Prénom:");
        TextField TfPrenom = new TextField();
        grid.add(labelPrenom, 0, 1); 
        grid.add(TfPrenom, 1, 1); 

        RadioButton radioButtonMasculin = new RadioButton("Homme");
        RadioButton radioButtonFeminin = new RadioButton("Femme");
        ToggleGroup Group = new ToggleGroup();
        radioButtonMasculin.setToggleGroup(Group);
        radioButtonFeminin.setToggleGroup(Group);
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(radioButtonMasculin, radioButtonFeminin);
        TitledPane titledPane = new TitledPane("Sexe", vbox);
        vbox.setPadding(new Insets(10,0,10,10));
        grid.add(titledPane, 0, 2,2,1);

        Label labelNationalite = new Label("Nationalite:");
        TextField TfNationalite = new TextField();
        grid.add(labelNationalite, 0, 3); 
        grid.add(TfNationalite, 1, 3); 

        Label labelForce = new Label("Force:");
        TextField TfForce = new TextField();
        TfForce.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                TfForce.setText(newValue.replaceAll("[^\\d]", ""));
            }});
        grid.add(labelForce, 0, 4);
        grid.add(TfForce, 1, 4);

        Label labelAgilite = new Label("Agilite:");
        TextField TfAgilite = new TextField();
        TfAgilite.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                TfAgilite.setText(newValue.replaceAll("[^\\d]", ""));
            }});
        grid.add(labelAgilite, 0, 5);
        grid.add(TfAgilite, 1, 5);

        Label labelEndurance = new Label("Endurance:");
        TextField TfEndurance = new TextField();
        TfEndurance.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                TfEndurance.setText(newValue.replaceAll("[^\\d]", ""));
            }});
        grid.add(labelEndurance, 0, 6);
        grid.add(TfEndurance, 1, 6);

        ImageView valide = new ImageView("file:img/valide.png");
        valide.setFitWidth(20);
        valide.setFitHeight(20);
        this.creeAthlete = new Button("Ajouter l'athlète",valide);
        grid.add(creeAthlete, 0, 7);
        creeAthlete.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);");
        return grid;    

    }

    /**
    pop up retour à l'accueil
    */
    public Alert popUpRetourAccueil(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Etes-vous sûr de vouloir retourner à l'acceuil ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Label getTitre() {
        return titre;
    }

    public Button getboutonDeconnexion() {
        return boutonDeconnexion;
    }

    public Main getApp() {
        return application;
    }

    public Button getCreeAthlete() {
        return creeAthlete;
    }    
}
