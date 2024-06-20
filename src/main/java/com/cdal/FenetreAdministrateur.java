package main.java.com.cdal;

import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreAdministrateur extends BorderPane{

    private Main application;

    /**
     * le titre
     */
    private Label labelTitre;

    /**
     * le bouton info
     */
    private Button boutonInfo;
    
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonDeconnexion;

    /**
     * le bouton pour ajouter un athlète
     */    
    private Button boutonAjouterAthlete;

    /**
     * controleur pour ajouter une épreuve
     */ 
    private Button boutonAjouterEpreuve;

    /**
     * controleur pour supprimer un athlète
     */ 
    private Button boutonSupprimerAthlete;

    /**
     * controleur pour supprimer une épreuve
     */ 
    private Button boutonSupprimerEpreuve;

    /**
     * label charger fichier
     */    
    private Label labelChargerFichier;

    /**
     * bouton charger fichier
     */    
    private Button boutonChargerFichier;

    /**
     * bouton enlever le fichier chargé 
     */    
    private Button boutonSupprimerFichier;

    /**
     * controleur pour charger un fichier
     */ 
    private ControleurChargerFichier controleurFichier;
 
    public FenetreAdministrateur(Main application){
        super();
        this.application = application;

        this.setTop(creerEnTete());
        this.setCenter(creerModeAccueil());
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public Main getApplication(){
        return application;
    }

    private StackPane creerEnTete(){
        StackPane panneauEntete = new StackPane();
        panneauEntete.setPadding(new Insets(15, 12, 15, 12));
        panneauEntete.setStyle("-fx-background-color: #f0f0f0;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label labelTitre = new Label("Administrateur");
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
        boutonInfo.setGraphic(imageInfo);
        boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonInfo.setOnMouseEntered(e -> boutonInfo.setStyle("-fx-background-radius: 50%; -fx-padding: 8;"));
        boutonInfo.setOnMouseExited(e -> boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        HBox hBoxBoutons = new HBox(10, boutonDeconnexion, boutonInfo);
        hBoxBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(labelTitre, Pos.CENTER);
        StackPane.setAlignment(hBoxBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, labelTitre, hBoxBoutons);

        return panneauEntete;
    }

    // Méthode pour ajouter un effet de survol (la base de la méthode a été trouvée sur un forum)
    private void ajouterEffetSurvol(Button button){
        DropShadow ombre = new DropShadow();
        ombre.setColor(Color.rgb(0, 0, 0, 0.5));
        ombre.setRadius(10);
        ombre.setSpread(0.3);

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e ->{
            button.setEffect(ombre);
            button.setStyle("-fx-background-color: #444444; -fx-background-radius: 20; -fx-text-fill: white;");
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), button);
            transition.setToX(1.1);
            transition.setToY(1.1);
            transition.play();
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, e ->{
            button.setEffect(null);
            button.setStyle("-fx-background-color: black; -fx-background-radius: 20; -fx-text-fill: white;");
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), button);
            transition.setToX(1.0);
            transition.setToY(1.0);
            transition.play();
        });
    }

    public VBox creerModeAccueil(){
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(30, 0, 0, 120));

        GridPane grille = new GridPane();
        grille.setHgap(50);
        grille.setVgap(50);

        labelChargerFichier = new Label("Charger un fichier participants: ");
        labelChargerFichier.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
        boutonChargerFichier = new Button("Charger votre fichier .CSV");
        boutonChargerFichier.setOnAction(new ControleurChargerFichier(this));
        boutonChargerFichier.setPadding(new Insets(12, 12, 12, 12));
        boutonChargerFichier.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"); 

        grille.add(labelChargerFichier, 0, 1);
        grille.add(boutonChargerFichier, 1, 1);

        ImageView croix = new ImageView("file:img/croix.png");
        croix.setFitWidth(20);
        croix.setFitHeight(20);
        this.boutonSupprimerFichier = new Button("", croix);
        grille.add(boutonSupprimerFichier, 2, 1);
        boutonSupprimerFichier.setOnAction(new ControleurSupprimerFichier(this, controleurFichier));
        boutonSupprimerFichier.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);");
        this.boutonSupprimerFichier.setDisable(true);

        boutonAjouterAthlete = new Button("Ajouter un athlète");
        boutonAjouterAthlete.setPadding(new Insets(12, 40, 12, 40));
        boutonAjouterAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
        ajouterEffetSurvol(boutonAjouterAthlete);
        boutonAjouterAthlete.setOnAction(new ControleurAjouterAthlete(this));

        boutonAjouterEpreuve = new Button("Ajouter une épreuve");
        boutonAjouterEpreuve.setPadding(new Insets(12, 33, 12, 33));
        boutonAjouterEpreuve.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white; ");
        ajouterEffetSurvol(boutonAjouterEpreuve);

        boutonSupprimerAthlete = new Button("Supprimer un athlète");
        boutonSupprimerAthlete.setPadding(new Insets(12, 30, 12, 30));
        boutonSupprimerAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white; ");
        ajouterEffetSurvol(boutonSupprimerAthlete);

        boutonSupprimerEpreuve = new Button("Supprimer une épreuve");
        boutonSupprimerEpreuve.setPadding(new Insets(12, 23, 12, 23));
        boutonSupprimerEpreuve.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
        ajouterEffetSurvol(boutonSupprimerEpreuve);

        VBox vBoxBoutons = new VBox(40);
        vBoxBoutons.getChildren().addAll(boutonAjouterAthlete, boutonAjouterEpreuve, boutonSupprimerAthlete, boutonSupprimerEpreuve);
        vBoxBoutons.setPadding(new Insets(50, 0, 0, 180));

        vBox.getChildren().addAll(grille, vBoxBoutons);

        return vBox; 
    }

    public void setTextFichierCharger(String texte){
        this.boutonChargerFichier.setText(texte);
    }

    /**
    re activer le bouton accéder aux données après avoir chargé le fichier
    */
    public void activerBoutonSuppression(Boolean activer){
        this.boutonSupprimerFichier.setDisable(!activer);
    }

    /**
    pop info sur la page accueil
    */
    public Alert popUpInfoAccueil(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Ici, vous pouvez contrôler la base de données en ajoutant ou supprimant des athlètes ou joueurs mais aussi charger votre fichier .CSV.");
        alert.getDialogPane().setPrefSize(500,200);
        return alert;
    }
}
