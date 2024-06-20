package main.java.com.cdal;

import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FenetreAdministrateur extends BorderPane {


    public Main getApp() {
        return this.app;
    }




    private Main app;

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

    /**
     * le bouton pour ajouter un athlete
     */    
    private Button boutonAjouterAthlete;

    /**
     * controleur pour ajouter une epreuve
     */ 
    private Button boutonAjouterEpreuve;

    /**
     * controleur pour supprimer un athlete
     */ 
    private Button boutonSuppAthlete;

        /**
     * controleur pour supprimer un épreuve
     */ 
    private Button boutonSuppEpreuve;

    /**
     * label charger fichier
     */    
    private Label labelChargerFichier;

    /**
     * bouton charger fichier
     */    
    private Button boutonChargerFichier;

    /**
     * bouton enlever le fichier charger 
     */    
    private Button bouttonCroix;

    /**
     * controleur pour charger un fichier
     */ 
    private ControleurChargerFichier fichier;
 






    public FenetreAdministrateur(Main app) {
        super();
        this.app = app;

        this.setTop(titre());
        this.setCenter(modeAccueil());
    }


    private HBox titre() {
        HBox banniere = new HBox();
        banniere.setMinHeight(80);
        banniere.setAlignment(Pos.CENTER);
        banniere.setPadding(new Insets(20, 10, 20, 10));
        banniere.setStyle("-fx-border-color: transparent transparent black transparent; -fx-border-width: 0 0 1 0;");

    
        ImageView iutImg = new ImageView("file:img/iutjo.png");
        iutImg.setFitWidth(180);
        iutImg.setFitHeight(47);
    
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
    
        HBox leftBox = new HBox(iutImg);
        leftBox.setAlignment(Pos.CENTER_LEFT);
    
        HBox rightBox = new HBox(10, boutonMaison, boutonInfo);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
    
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
    
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        boutonInfo.setOnAction(new ControleurInfoAccueil(this));
    
        banniere.getChildren().addAll(leftBox, leftSpacer, titre, rightSpacer, rightBox);
    
        return banniere;
    }


    // Méthode pour ajouter un effet de survol (la base de la methode a été trouver sur un forum)
    private void ajouterEffetSurvol(Button button) {
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.rgb(0, 0, 0, 0.5));
        shadow.setRadius(10);
        shadow.setSpread(0.3);

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            button.setEffect(shadow);
            button.setStyle("-fx-background-color: #444444; -fx-background-radius: 20; -fx-text-fill: white;");
            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.1);
            st.setToY(1.1);
            st.play();
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            button.setEffect(null);
            button.setStyle("-fx-background-color: black; -fx-background-radius: 20; -fx-text-fill: white;");
            ScaleTransition st = new ScaleTransition(Duration.millis(200), button);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
    }

public VBox modeAccueil() {
    this.boutonMaison.setDisable(true);
    this.boutonInfo.setDisable(false);
    this.titre.setStyle("-fx-font-size: 50px; -fx-text-fill: black;");
    this.titre.setText("Accueil");

    VBox vbox = new VBox(10);
    vbox.setPadding(new Insets(30, 0, 0, 120));

    GridPane grid = new GridPane();
    grid.setHgap(50);
    grid.setVgap(50);

    labelChargerFichier = new Label("Charger un fichier participants: ");
    labelChargerFichier.setStyle("-fx-font-size: 18px; -fx-text-fill: black;");
    boutonChargerFichier = new Button("Charger votre fichier .CSV");
    boutonChargerFichier.setOnAction(new ControleurChargerFichier(this));
    boutonChargerFichier.setPadding(new Insets(12, 12, 12, 12));
    boutonChargerFichier.setStyle("-fx-background-radius: 20; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);"); 

    grid.add(labelChargerFichier, 0, 1);
    grid.add(boutonChargerFichier, 1, 1);

    ImageView croix = new ImageView("file:img/croix.png");
    croix.setFitWidth(20);
    croix.setFitHeight(20);
    this.bouttonCroix = new Button("", croix);
    grid.add(bouttonCroix, 2, 1);
    bouttonCroix.setOnAction(new ControleurSupprimerFichier(this, fichier));
    bouttonCroix.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 10, 0, 0, 0);");
    this.bouttonCroix.setDisable(true);

    boutonAjouterAthlete = new Button("Ajouter un athlète");
    boutonAjouterAthlete.setPadding(new Insets(12, 40, 12, 40));
    boutonAjouterAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
    ajouterEffetSurvol(boutonAjouterAthlete);
    boutonAjouterAthlete.setOnAction(new ControleurAccederFenetreAjouterAthlete(this));

    boutonAjouterEpreuve = new Button("Ajouter une épreuve");
    boutonAjouterEpreuve.setPadding(new Insets(12, 33, 12, 33));
    boutonAjouterEpreuve.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white; ");
    ajouterEffetSurvol(boutonAjouterEpreuve);

    boutonSuppAthlete = new Button("Supprimer un athlète");
    boutonSuppAthlete.setPadding(new Insets(12, 30, 12, 30));
    boutonSuppAthlete.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white; ");
    ajouterEffetSurvol(boutonSuppAthlete);

    boutonSuppEpreuve = new Button("Supprimer une épreuve");
    boutonSuppEpreuve.setPadding(new Insets(12, 23, 12, 23));
    boutonSuppEpreuve.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
    ajouterEffetSurvol(boutonSuppEpreuve);

    VBox hboxButton = new VBox(40);
    hboxButton.getChildren().addAll(boutonAjouterAthlete, boutonAjouterEpreuve, boutonSuppAthlete, boutonSuppEpreuve);
    hboxButton.setPadding(new Insets(50, 0, 0, 220));

    vbox.getChildren().addAll(grid, hboxButton);

    return vbox; 
}





    public void setTextFichierCharger(String str){
        this.boutonChargerFichier.setText(str);
    }





    /**
    re activer le bouton acceder aux données apres avoir charger le fichier
    */
    public void activerBoutontSupp(Boolean bool) {
        this.bouttonCroix.setDisable(!bool);

    }

    /**
    re activer le bouton home
    */
    public void activerBoutonMaison( ) {
        this.boutonMaison.setDisable(false);

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
