package main.java.com.cdal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreInscription extends BorderPane {

    private Main app;
    private TextField usernameField;
    private PasswordField passwordField;
    private PasswordField passwordField2;
    private Button infoButton;
    private Button logoutButton;


    public FenetreInscription(Main app) {
        super();
        this.app = app;
        this.usernameField = new TextField();
        this.passwordField = new PasswordField();
        this.passwordField2 = new PasswordField();

        this.setTop(enTete());

        // Ajout de la HBox centrale au BorderPane
        this.setCenter(center());
    }

    private StackPane enTete() {
        StackPane spEntete = new StackPane();
        spEntete.setPadding(new Insets(15, 12, 15, 12));
        spEntete.setStyle("-fx-background-color: white;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Inscription");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

        logoutButton = new Button();
        ImageView logoutImage = new ImageView(new Image("file:img/logout.png"));
        logoutImage.setFitHeight(30);
        logoutImage.setPreserveRatio(true);
        logoutButton.setGraphic(logoutImage);
        logoutButton.setOnAction(e -> app.afficherConnexion());
        logoutButton.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        logoutButton.setOnMouseEntered(e -> logoutButton.setStyle("-fx-background-color: lightgrey; -fx-background-radius: 50%; -fx-padding: 8;"));
        logoutButton.setOnMouseExited(e -> logoutButton.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        infoButton = new Button();
        ImageView infoImage = new ImageView(new Image("file:img/info.png"));
        infoImage.setFitHeight(30);
        infoImage.setPreserveRatio(true);
        infoButton.setGraphic(infoImage);
        infoButton.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;");
        infoButton.setOnMouseEntered(e -> infoButton.setStyle("-fx-background-radius: 50%; -fx-padding: 8;"));
        infoButton.setOnMouseExited(e -> infoButton.setStyle("-fx-background-color : black; -fx-background-radius: 50%; -fx-padding: 8;"));

        HBox hbBoutons = new HBox(10, logoutButton, infoButton);
        hbBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hbBoutons, Pos.CENTER_RIGHT);
        spEntete.getChildren().addAll(imageEnTete, titre, hbBoutons);

        return spEntete;
    }

    public HBox center() {
        // Section du centre avec HBox
        HBox centerHBox = new HBox(10);
        centerHBox.setPadding(new Insets(10, 0, 0, 10));
        centerHBox.setAlignment(Pos.CENTER);

        // VBox pour les éléments d'inscription
        VBox registerVBox = new VBox(10);
        registerVBox.setPadding(new Insets(0, 0, 0, 50));
        Label titleLabel = new Label("Inscrivez-vous");
        titleLabel.setFont(new Font("System Bold", 18));
        titleLabel.setAlignment(Pos.CENTER);

        usernameField.setPromptText("nom d'utilisateur");
        usernameField.setMinWidth(238);
        usernameField.setMaxWidth(238);

        passwordField.setPromptText("mot de passe");
        passwordField.setMinWidth(238);
        passwordField.setMaxWidth(238);

        passwordField2.setPromptText("confirmez le mot de passe");
        passwordField2.setMinWidth(238);
        passwordField2.setMaxWidth(238);

        Button registerButton = new Button("S'inscrire");
        ControleurInscription controleurInscription = new ControleurInscription(this);
        registerButton.setOnAction(controleurInscription);
        registerButton.setAlignment(Pos.CENTER_RIGHT);

        Label createAccountLabel = new Label("J'ai déjà un compte");
        createAccountLabel.setTextFill(Color.web("#0000009b"));
        createAccountLabel.setOnMouseClicked(e -> app.afficherConnexion());
        Utils.setCursorOnHover(createAccountLabel, Cursor.HAND);

        // Button organiserButton = new Button("Organisateur");
        // organiserButton.setOnAction(e -> app.afficherOrganisateur());

        registerVBox.getChildren().addAll(titleLabel, usernameField, passwordField, passwordField2, registerButton, createAccountLabel);
        registerVBox.setAlignment(Pos.CENTER);

        // ImageView à côté de la VBox
        ImageView sideImageView = new ImageView(new Image("file:src/main/java/com/cdal/test.png"));
        sideImageView.setFitHeight(200);
        sideImageView.setFitWidth(200);
        sideImageView.setPreserveRatio(true);

        // Ajout de la VBox et de l'ImageView à la HBox centrale
        centerHBox.getChildren().addAll(registerVBox, sideImageView);
        centerHBox.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));

        return centerHBox;
    }

    public String getUsernameField(){
        return this.usernameField.getText();
    }

    public String getPasswordField(){
        return this.passwordField.getText();
    }

    public String getPasswordField2(){
        return this.passwordField2.getText();
    } 
}
