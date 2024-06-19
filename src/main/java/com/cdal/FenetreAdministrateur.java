import javafx.util.Duration;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
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
import javafx.stage.Stage;

public class FenetreAdministrateur extends Application {

    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;

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
 
    /**
     * boutton pour cree l'athlete
     */ 
    private Button creeAthlete;




    @Override
    public void start(Stage stage) {
        stage.setTitle("Jeux IUT'Olympiques");
        stage.setScene(this.laScene());
        this.modeAjouterAthlete();
        stage.show();
    }

    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        fichier = new ControleurChargerFichier(this);
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        panelCentral =new BorderPane();

        fenetre.setTop(titre());
        fenetre.setCenter(this.panelCentral);

        return new Scene(fenetre, 800, 800);
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

public void modeAccueil() {
    panelCentral.getChildren().clear();
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
    boutonAjouterAthlete.setOnAction(new ControleurAjouterAthlete(this));

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
    hboxButton.setPadding(new Insets(50, 0, 0, 180));

    vbox.getChildren().addAll(grid, hboxButton);

    panelCentral.setCenter(vbox); 
}

    public void modeAjouterAthlete(){
        panelCentral.getChildren().clear();
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







        panelCentral.setCenter(grid);
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
    pop up retour à l'accueil
    */
    public Alert popUpRetourAccueil(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Etes-vous sûr de vouloir retourner à l'acceuil ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
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

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    } 
    
}
