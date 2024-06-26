package main.java.com.cdal;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    private Button boutonMaison;


    private Main app;

    /**
     * boutton pour cree l'athlete
     */ 
    private Button creeAthlete;

    /**
     * le bouton de déconnexion
     */
    private Button boutonDeconnexion;


    private Label labelNom;
    private TextField TfNom;
    private Label labelPrenom;
    private TextField TfPrenom ;
    private Label labelNationalite;
    private ComboBox<Pays> comboNationalite;
    private TextField TfForce;
    private TextField TfAgilite;
    private TextField TfEndurance;
    private ToggleGroup Group;
    private FenetreAdministrateur appAdm;


    public FenetreAjouterAthlete(Main app){
        super();
        this.app = app;
        this.appAdm = new FenetreAdministrateur(app);
        this.setTop(creerEnTete());
        this.setCenter(modeAjouterAthlete());
    }

    private StackPane creerEnTete() {
        StackPane panneauEntete = new StackPane();
        panneauEntete.setPadding(new Insets(15, 12, 15, 12));
        panneauEntete.setStyle("-fx-background-color: #f0f0f0;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Administrateur");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

        boutonDeconnexion = new Button();
        ImageView imageDeconnexion = new ImageView(new Image("file:img/logout.png"));
        imageDeconnexion.setFitHeight(30);
        imageDeconnexion.setPreserveRatio(true);
        boutonDeconnexion.setGraphic(imageDeconnexion);
        boutonDeconnexion.setOnAction(e -> app.afficherConnexion());
        boutonDeconnexion.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonDeconnexion.setOnMouseEntered(e -> boutonDeconnexion
                .setStyle("-fx-background-color: lightgrey; -fx-background-radius: 50%; -fx-padding: 8;"));
        boutonDeconnexion.setOnMouseExited(e -> boutonDeconnexion
                .setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        boutonInfo = new Button();
        ImageView imageInfo = new ImageView(new Image("file:img/info.png"));
        imageInfo.setFitHeight(30);
        imageInfo.setPreserveRatio(true);
        boutonInfo.setGraphic(imageInfo);
        boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonInfo.setOnMouseEntered(e -> boutonInfo
                .setStyle("-fx-background-color: lightgrey; -fx-background-radius: 50%; -fx-padding: 8;"));
        boutonInfo.setOnMouseExited(e -> boutonInfo
                .setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        boutonMaison = new Button();
        ImageView imageMaison = new ImageView(new Image("file:img/home.png"));
        imageMaison.setFitHeight(30);
        imageMaison.setPreserveRatio(true);
        boutonMaison.setGraphic(imageMaison);
        boutonMaison.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonMaison.setOnMouseEntered(e -> boutonMaison
                .setStyle("-fx-background-color: lightgrey; -fx-background-radius: 50%; -fx-padding: 8;"));
        boutonMaison.setOnMouseExited(e -> boutonMaison.
                setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        HBox hbBoutons = new HBox(10,boutonMaison, boutonDeconnexion, boutonInfo);
        hbBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hbBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, titre, hbBoutons);

        boutonMaison.setOnAction(e -> {
            Optional<ButtonType> result = popUpRetourAccueil().showAndWait();
            if (result.isPresent() && result.get().equals(ButtonType.YES)) {
                app.afficherAdministrateur();
            }
        });

        return panneauEntete;
    }
    
    
//     private HBox titre() {
//         HBox banniere = new HBox();
//         banniere.setMinHeight(80);
//         banniere.setAlignment(Pos.CENTER);
//         banniere.setPadding(new Insets(20, 10, 20, 10));
//         banniere.setStyle("-fx-border-color: transparent transparent black transparent; -fx-border-width: 0 0 1 0;");

    
//         ImageView iutImg = new ImageView("file:img/iutjo.png");
//         iutImg.setFitWidth(180);
//         iutImg.setFitHeight(47);
// ;
    
//         titre = new Label("   Ajouter un athlète");
//         titre.setStyle("-fx-font-size: 50px; -fx-text-fill: black;");
//         titre.setPadding(new Insets(0, 80, 0, 0));

        
//         ImageView homeImage = new ImageView("file:img/home.png");
//         ImageView infoImage = new ImageView("file:img/info.png");
//         homeImage.setFitWidth(30);
//         homeImage.setFitHeight(30);
//         infoImage.setFitWidth(30);
//         infoImage.setFitHeight(30);

//         this.boutonMaison = new Button("",homeImage);
//         this.boutonInfo = new Button("",infoImage);
    
//         HBox leftBox = new HBox(iutImg);
//         leftBox.setAlignment(Pos.CENTER_LEFT);
    
//         HBox rightBox = new HBox(10, boutonMaison, boutonInfo);
//         rightBox.setAlignment(Pos.CENTER_RIGHT);
    
//         Region leftSpacer = new Region();
//         HBox.setHgrow(leftSpacer, Priority.ALWAYS);
    
//         Region rightSpacer = new Region();
//         HBox.setHgrow(rightSpacer, Priority.ALWAYS);

//         boutonMaison.setOnAction(e -> {
//             Optional<ButtonType> result = popUpRetourAccueil().showAndWait();
//             if (result.isPresent() && result.get().equals(ButtonType.YES)) {
//             app.afficherAdministrateur();
//             }});
    
//         banniere.getChildren().addAll(leftBox, leftSpacer, titre, rightSpacer, rightBox);
    
//         return banniere;
//     }

    public Athlete getAthlete() {
        String nom = this.TfNom.getText();
        String prenom = this.TfPrenom.getText();
        Pays nationalite = this.comboNationalite.getValue();
        char sexe = ((RadioButton) Group.getSelectedToggle()).getText().charAt(0); 
        int force = Integer.parseInt(this.TfForce.getText());
        int agilite = Integer.parseInt(this.TfAgilite.getText());
        int endurance = Integer.parseInt(this.TfEndurance.getText());
    
        return new Athlete(nom, prenom, sexe, nationalite, force, agilite, endurance,false);
    }

    public void viderFiche(){
        this.TfNom.setText("");
        this.TfPrenom.setText("");
        this.comboNationalite.setValue(null); 
        this.Group.selectToggle(null); 
        this.TfAgilite.setText("");
        this.TfEndurance.setText("");
        this.TfForce.setText("");
    }
    

    public GridPane modeAjouterAthlete(){
        this.boutonInfo.setDisable(true);

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50,0,0,80));

        labelNom = new Label("Nom:");
        TfNom = new TextField();
        grid.add(labelNom, 0, 0); 
        grid.add(TfNom, 1, 0); 

        labelPrenom = new Label("Prénom:");
        TfPrenom = new TextField();
        grid.add(labelPrenom, 0, 1); 
        grid.add(TfPrenom, 1, 1); 

        RadioButton radioButtonMasculin = new RadioButton("Homme");
        RadioButton radioButtonFeminin = new RadioButton("Femme");
        Group = new ToggleGroup();
        radioButtonMasculin.setToggleGroup(Group);
        radioButtonFeminin.setToggleGroup(Group);
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(radioButtonMasculin, radioButtonFeminin);
        TitledPane titledPane = new TitledPane("Sexe", vbox);
        vbox.setPadding(new Insets(10,0,10,10));
        grid.add(titledPane, 0, 2,2,1);

        labelNationalite = new Label("Nationalite:");
        comboNationalite = new ComboBox<>();
        comboNationalite.setPadding(new Insets(0,0,0,125));
        grid.add(labelNationalite, 0, 3); 
        grid.add(comboNationalite, 1, 3); 

        Label labelForce = new Label("Force:");
        TfForce = new TextField();
        TfForce.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                TfForce.setText(newValue.replaceAll("[^\\d]", ""));
            }});
        grid.add(labelForce, 0, 4);
        grid.add(TfForce, 1, 4);

        Label labelAgilite = new Label("Agilite:");
        TfAgilite = new TextField();
        TfAgilite.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                TfAgilite.setText(newValue.replaceAll("[^\\d]", ""));
            }});
        grid.add(labelAgilite, 0, 5);
        grid.add(TfAgilite, 1, 5);

        Label labelEndurance = new Label("Endurance:");
        TfEndurance = new TextField();
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
        creeAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
        creeAthlete.setOnAction(new ControleurAjouterAthlete(this));
        this.appAdm.ajouterEffetSurvol(creeAthlete);

        return grid;    

    }


    public ComboBox<Pays> getComboBoxNationalite(){
        return comboNationalite;
    }

    public String getTfNom() {
        return TfNom.getText();
    }
    
    public String getTfPrenom() {
        return TfPrenom.getText();
    }
    
    
    public String getTfForce() {
        return TfForce.getText();
    }
    
    public String getTfAgilite() {
        return TfAgilite.getText();
    }
    
    public String getTfEndurance() {
        return TfEndurance.getText();
    }
    
    public Toggle getRbSexe() {
        return Group.getSelectedToggle();
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



   


    /**
    pop up retour à l'accueil
    */
    public Alert popUpRetourAccueil(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Etes-vous sûr de vouloir retourner à l'acceuil ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popNomVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le nom  est vide !");
        
    }

    public Alert popPrenomVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le prenom vide !");
        
    }

    public Alert popSexeVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Veuillez indiquer le sexe !");
        
    }

    public Alert popNationaliteVide() {
        return new Alert(Alert.AlertType.INFORMATION, "La nationalité est vide !");
        
    }

    public Alert popForceVide() {
        return new Alert(Alert.AlertType.INFORMATION, "La force est vide !");
        
    }

    public Alert popAgiliteVide() {
        return new Alert(Alert.AlertType.INFORMATION, "L'agilité est vide !");
        
    }

    public Alert popEnduranceVide() {
        return new Alert(Alert.AlertType.INFORMATION, "L'endurance est vide !");
        
    }

    public Alert popAthleteAjouter() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "L'athlète à bien été ajouté !");
        viderFiche();
        return alert;        
    }
}
