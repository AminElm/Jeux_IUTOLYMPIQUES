package main.java.com.cdal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class FenetreConnexion extends BorderPane{

    private Main application;
    private TextField champUtilisateur;
    private PasswordField champMotDePasse;
    private Button boutonInfo;
    private CheckBox resterConnecteCheckBox;

    public FenetreConnexion(Main application){
        super();
        this.application = application;
        Scanner idPrec;
        try{
            idPrec = new Scanner(new File("src/main/java/com/cdal/idPrec.txt"));
            String pseudo = idPrec.nextLine();
            String mdp = idPrec.nextLine();
            this.champUtilisateur = new TextField(pseudo);
            this.champMotDePasse = new PasswordField();
            this.champMotDePasse.setText(mdp);
            this.resterConnecteCheckBox = new CheckBox();
            idPrec.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
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

        Label titre = new Label("Connexion");
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

        HBox hBoxBoutons = new HBox(10, boutonInfo);
        hBoxBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hBoxBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, titre, hBoxBoutons);

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

        // VBox pour les éléments de connexion
        VBox connexionVBox = new VBox(10);
        connexionVBox.setAlignment(Pos.CENTER);
        connexionVBox.setPadding(new Insets(10, 15, 10, 15));
        connexionVBox.setBackground(new Background(new BackgroundFill(Color.web("#f0f0f0"), new CornerRadii(10), Insets.EMPTY)));
        connexionVBox.setStyle("-fx-border-color: lightgrey; -fx-border-width: 1; -fx-border-radius: 10;");
        connexionVBox.setMinSize(300, 300);
        connexionVBox.setMaxSize(300, 300);
        
        Label labelTitreConnexion = new Label("Connectez-vous");
        labelTitreConnexion.setFont(new Font("System Bold", 18));
        labelTitreConnexion.setAlignment(Pos.CENTER);

        champUtilisateur.setPromptText("nom d'utilisateur");
        champUtilisateur.setMaxWidth(238);
        champUtilisateur.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: lightgrey; -fx-border-radius: 5; -fx-padding: 10;");

        champMotDePasse.setPromptText("mot de passe");
        champMotDePasse.setMaxWidth(238);
        champMotDePasse.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-border-color: lightgrey; -fx-border-radius: 5; -fx-padding: 10;");

        HBox hBoxBoutons = new HBox(5);
        resterConnecteCheckBox.setText("Rester connecté");
        resterConnecteCheckBox.setTextFill(Color.BLACK);
        resterConnecteCheckBox.setSelected(true);
        Button boutonConnexion = new Button("Se connecter");
        boutonConnexion.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 5;");
        ControleurConnexion controleurConnexion = new ControleurConnexion(this);
        boutonConnexion.setOnAction(controleurConnexion);
        hBoxBoutons.getChildren().addAll(resterConnecteCheckBox, boutonConnexion);
        hBoxBoutons.setAlignment(Pos.CENTER);

        Label labelCreerCompte = new Label("Créer un compte");
        labelCreerCompte.setTextFill(Color.web("#0000009b"));
        labelCreerCompte.setOnMouseClicked(e -> application.afficherInscription());
        Utils.setCursorOnHover(labelCreerCompte, Cursor.HAND);

        connexionVBox.getChildren().addAll(labelTitreConnexion, champUtilisateur, champMotDePasse, hBoxBoutons, labelCreerCompte);
        connexionVBox.setAlignment(Pos.CENTER);

        // Ajout de la VBox et de l'ImageView à la HBox centrale
        centreHBox.getChildren().addAll(imageVBox, connexionVBox);
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

    public Main getApplication(){
        return this.application;
    }

    public CheckBox getResterConnecteCheckBox(){
        return this.resterConnecteCheckBox;
    }
}
