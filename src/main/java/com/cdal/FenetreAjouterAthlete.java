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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

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
    private Button boutonMaison;


    private Main app;

        /**
     * boutton pour cree l'athlete
     */ 
    private Button creeAthlete;

    public FenetreAjouterAthlete(Main app){
        super();
        this.app = app;

        this.setTop(titre());
        this.setCenter(modeAjouterAthlete());
    }


    
    private HBox titre() {
        HBox banniere = new HBox();
        banniere.setMinHeight(80);
        banniere.setAlignment(Pos.CENTER);
        banniere.setPadding(new Insets(20, 10, 20, 10));
        banniere.setStyle("-fx-border-color: transparent transparent black transparent; -fx-border-width: 0 0 1 0;");

    
        ImageView iutImg = new ImageView("file:img/iut_logo.png");
        ImageView joImg = new ImageView("file:img/JO_logo.png");
        iutImg.setFitWidth(95);
        iutImg.setFitHeight(45);
        joImg.setFitWidth(95);
        joImg.setFitHeight(45);
    
        titre = new Label("Accueil");
        titre.setStyle("-fx-font-size: 50px; -fx-text-fill: black;");
        titre.setPadding(new Insets(0, 80, 0, 0));

        
        ImageView homeImage = new ImageView("file:img/home.png");
        ImageView infoImage = new ImageView("file:img/info.png");
        homeImage.setFitWidth(30);
        homeImage.setFitHeight(30);
        infoImage.setFitWidth(30);
        infoImage.setFitHeight(30);

        this.boutonMaison = new Button("",homeImage);
        this.boutonInfo = new Button("",infoImage);
    
        HBox leftBox = new HBox(10, iutImg, joImg);
        leftBox.setAlignment(Pos.CENTER_LEFT);
    
        HBox rightBox = new HBox(10, boutonMaison, boutonInfo);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
    
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
    
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        boutonMaison.setOnAction(new ControleurRetourAccueilAdmin(this));
    
        banniere.getChildren().addAll(leftBox, leftSpacer, titre, rightSpacer, rightBox);
    
        return banniere;
    }



    public GridPane modeAjouterAthlete(){
        this.boutonInfo.setDisable(true);
        this.titre.setText("   Ajouter un athlète");
        this.titre.setStyle("-fx-font-size: 37px; -fx-text-fill: black;");

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



    public Button getBoutonInfo() {
        return boutonInfo;
    }



    public Button getBoutonMaison() {
        return boutonMaison;
    }



    public Main getApp() {
        return app;
    }



    public Button getCreeAthlete() {
        return creeAthlete;
    }    
}
