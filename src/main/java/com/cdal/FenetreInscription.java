package main.java.com.cdal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreInscription extends BorderPane{

    private Main application;
    private TextField champUtilisateur;
    private PasswordField champMotDePasse;
    private PasswordField champConfirmationMotDePasse;
    private Button boutonInfo;

    public FenetreInscription(Main application){
        super();
        this.application = application;
        this.champUtilisateur = new TextField();
        this.champMotDePasse = new PasswordField();
        this.champConfirmationMotDePasse = new PasswordField();

        this.setTop(creerEnTete());
        this.setCenter(creerCentre());
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private StackPane creerEnTete(){
        StackPane panneauEntete = new StackPane();
        panneauEntete.setPadding(new Insets(15, 12, 15, 12));
        panneauEntete.setStyle("-fx-background-color: #f0f0f0;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Inscription");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

        boutonInfo = new Button();
        ImageView imageInfo = new ImageView(new Image("file:img/info.png"));
        imageInfo.setFitHeight(30);
        imageInfo.setPreserveRatio(true);
        boutonInfo.setGraphic(imageInfo);
        boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        boutonInfo.setOnMouseEntered(e -> boutonInfo.setStyle("-fx-background-radius: 50%; -fx-padding: 8;"));
        boutonInfo.setOnMouseExited(e -> boutonInfo.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        HBox hbBoutons = new HBox(10, boutonInfo);
        hbBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hbBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, titre, hbBoutons);

        return panneauEntete;
    }

    public HBox creerCentre(){
        // Section du centre avec HBox
        HBox centreHBox = new HBox(10);
        centreHBox.setPadding(new Insets(10, 0, 0, 10));
        centreHBox.setAlignment(Pos.CENTER);

        // VBox pour l'image et le titre
        VBox imageVBox = new VBox(10);
        imageVBox.setAlignment(Pos.CENTER);
        Label labelTitreImage = new Label("Bienvenue !");
        labelTitreImage.setFont(new Font("System Bold", 18));
        labelTitreImage.setTextFill(Color.BLACK);

        ImageView vueImageCote = new ImageView(new Image("file:img/user.png"));
        vueImageCote.setFitHeight(200);
        vueImageCote.setFitWidth(200);
        vueImageCote.setPreserveRatio(true);

        imageVBox.getChildren().addAll(labelTitreImage, vueImageCote);

        // VBox pour les éléments d'inscription
        VBox inscriptionVBox = new VBox(10);
        inscriptionVBox.setAlignment(Pos.CENTER);
        inscriptionVBox.setPadding(new Insets(20, 10, 20, 10));
        inscriptionVBox.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0"), new CornerRadii(10), Insets.EMPTY)));
        inscriptionVBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-radius: 10;");
        inscriptionVBox.setMinSize(300, 300);
        inscriptionVBox.setMaxSize(300, 300);

        Label labelTitreInscription = new Label("Inscrivez-vous");
        labelTitreInscription.setFont(new Font("System Bold", 18));
        labelTitreInscription.setAlignment(Pos.CENTER);

        champUtilisateur.setPromptText("nom d'utilisateur");
        champUtilisateur.setMaxWidth(238);
        champUtilisateur.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: lightgrey; -fx-border-radius: 5; -fx-padding: 10;");

        champMotDePasse.setPromptText("mot de passe");
        champMotDePasse.setMaxWidth(238);
        champMotDePasse.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: lightgrey; -fx-border-radius: 5; -fx-padding: 10;");

        champConfirmationMotDePasse.setPromptText("confirmez le mot de passe");
        champConfirmationMotDePasse.setMaxWidth(238);
        champConfirmationMotDePasse.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: lightgrey; -fx-border-radius: 5; -fx-padding: 10;");

        Button boutonInscription = new Button("S'inscrire");
        boutonInscription.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 5;");
        ControleurInscription controleurInscription = new ControleurInscription(this);
        boutonInscription.setOnAction(controleurInscription);
        boutonInscription.setAlignment(Pos.CENTER_RIGHT);

        Label labelCreerCompte = new Label("J'ai déjà un compte");
        labelCreerCompte.setTextFill(Color.web("#0000009b"));
        labelCreerCompte.setOnMouseClicked(e -> application.afficherConnexion());
        Utils.setCursorOnHover(labelCreerCompte, Cursor.HAND);

        inscriptionVBox.getChildren().addAll(labelTitreInscription, champUtilisateur, champMotDePasse, champConfirmationMotDePasse, boutonInscription, labelCreerCompte);
        inscriptionVBox.setAlignment(Pos.CENTER);

        // Ajout de la VBox et de l'ImageView à la HBox centrale
        centreHBox.getChildren().addAll(imageVBox, inscriptionVBox);
        centreHBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        centreHBox.setSpacing(30);

        return centreHBox;
    }

    public String getChampUtilisateur(){
        return this.champUtilisateur.getText();
    }

    public String getChampMotDePasse(){
        return this.champMotDePasse.getText();
    }

    public String getChampConfirmationMotDePasse(){
        return this.champConfirmationMotDePasse.getText();
    }
}
