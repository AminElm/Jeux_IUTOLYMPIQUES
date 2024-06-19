package main.java.com.cdal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class FenetreConnexion extends BorderPane {

    private Main app;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button infoButton;

    public FenetreConnexion(Main app) {
        super();
        this.app = app;
        this.usernameField = new TextField();
        this.passwordField = new PasswordField();

        this.setTop(enTete());
        this.setCenter(center());
    }

     private StackPane enTete() {
        StackPane headerStackPane = new StackPane();
        headerStackPane.setPadding(new Insets(15, 12, 15, 12));
        headerStackPane.setStyle("-fx-background-color: white;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Connexion");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

        Button logoutButton = new Button();
        ImageView logoutImage = new ImageView(new Image("file:img/logout.png"));
        logoutImage.setFitHeight(30);
        logoutImage.setPreserveRatio(true);
        logoutButton.setGraphic(logoutImage);
        logoutButton.setStyle("-fx-background-radius: 50%; -fx-padding: 8;");
        logoutButton.setOnAction(e -> app.afficherConnexion());

        infoButton = new Button();
        ImageView infoImage = new ImageView(new Image("file:img/info.png"));
        infoImage.setFitHeight(30);
        infoImage.setPreserveRatio(true);
        infoButton.setGraphic(infoImage);
        infoButton.setStyle("-fx-background-radius: 50%; -fx-padding: 8;");

        HBox buttonsHBox = new HBox(10, logoutButton, infoButton);
        buttonsHBox.setAlignment(Pos.CENTER_RIGHT);

        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(buttonsHBox, Pos.CENTER_RIGHT);

        headerStackPane.getChildren().addAll(imageEnTete, titre, buttonsHBox);

        return headerStackPane;
    }

    public HBox center() {
        // Section du centre avec HBox
        HBox centerHBox = new HBox(10);
        centerHBox.setPadding(new Insets(10, 0, 0, 10));
        centerHBox.setAlignment(Pos.CENTER);

        // VBox pour les éléments de connexion
        VBox loginVBox = new VBox(10);
        loginVBox.setPadding(new Insets(0, 0, 0, 50));
        Label titleLabel = new Label("Connectez-vous");
        titleLabel.setFont(new Font("System Bold", 18));
        titleLabel.setAlignment(Pos.CENTER);

        usernameField.setPromptText("nom d'utilisateur");
        usernameField.setMaxWidth(238);

        passwordField.setPromptText("mot de passe");
        passwordField.setMaxWidth(238);

        HBox buttonHBox = new HBox(5);
        CheckBox stayConnectedCheckBox = new CheckBox("rester connecté");
        Button loginButton = new Button("Se connecter");
        ControleurConnexion controleurConnexion = new ControleurConnexion(this);
        loginButton.setOnAction(controleurConnexion);
        buttonHBox.getChildren().addAll(stayConnectedCheckBox, loginButton);

        Label createAccountLabel = new Label("Créer un compte");
        createAccountLabel.setTextFill(Color.web("#0000009b"));
        createAccountLabel.setOnMouseClicked(e -> app.afficherInscription());
        Utils.setCursorOnHover(createAccountLabel, Cursor.HAND);

        // Button organiserButton = new Button("Organisateur");
        // organiserButton.setOnAction(e -> app.afficherOrganisateur());

        loginVBox.getChildren().addAll(titleLabel, usernameField, passwordField, buttonHBox, createAccountLabel);
        loginVBox.setAlignment(Pos.CENTER);

        // ImageView à côté de la VBox
        ImageView sideImageView = new ImageView(new Image("file:src/main/java/com/cdal/test.png"));
        sideImageView.setFitHeight(200);
        sideImageView.setFitWidth(200);
        sideImageView.setPreserveRatio(true);

        // Ajout de la VBox et de l'ImageView à la HBox centrale
        centerHBox.getChildren().addAll(loginVBox, sideImageView);
        centerHBox.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        centerHBox.setSpacing(30);

        return centerHBox;
    }

    public String getUsernameField(){
        return this.usernameField.getText();
    }

    public String getPasswordField(){
        return this.passwordField.getText();
    }

    public Main getApp() {
        return this.app;
    }

    
}
