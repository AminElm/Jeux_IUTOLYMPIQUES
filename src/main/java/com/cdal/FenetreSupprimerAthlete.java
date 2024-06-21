package main.java.com.cdal;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreSupprimerAthlete extends BorderPane {
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
    private Button boutonSupprimerAthlete;

    /**
     * le bouton de déconnexion
     */
    private Button boutonDeconnexion;



    private Label labelNationalite;
    private ComboBox<Athlete> comboAthlete;
  
    private FenetreAdministrateur appAdm;


    public FenetreSupprimerAthlete(Main app){
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


    public void viderFiche(){
        this.comboAthlete.setValue(null); 
    }
    

    public GridPane modeAjouterAthlete(){
        this.boutonInfo.setDisable(true);

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50,0,0,80));

        labelNationalite = new Label("Choisir un athlète:");
        comboAthlete = new ComboBox<>();
        comboAthlete.setPadding(new Insets(0,0,0,125));
        grid.add(labelNationalite, 0, 3); 
        grid.add(comboAthlete, 1, 3); 



        ImageView valide = new ImageView("file:img/valide.png");
        valide.setFitWidth(20);
        valide.setFitHeight(20);
        this.boutonSupprimerAthlete = new Button("Supprimer l'athlète",valide);
        grid.add(boutonSupprimerAthlete, 0, 7);
        boutonSupprimerAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
        boutonSupprimerAthlete.setOnAction(new ControleurSupprimerAthlete(this));
        this.appAdm.ajouterEffetSurvol(boutonSupprimerAthlete);


        return grid;    

    }


    public ComboBox<Athlete> getComboBoxAthlete(){
        return comboAthlete;
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

    public Alert popIdVide() {
        return new Alert(Alert.AlertType.INFORMATION, "L'identifiant est vide !");
        
    }


    public Alert popAthleteSupprimer() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "L'athlète à bien été supprimé !");
        viderFiche();
        return alert;        
    }

}

