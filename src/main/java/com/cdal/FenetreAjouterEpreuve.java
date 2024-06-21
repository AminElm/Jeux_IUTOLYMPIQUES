package main.java.com.cdal;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreAjouterEpreuve extends BorderPane {

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
     * le bouton de déconnexion
     */
    private Button boutonDeconnexion;

    /**
     * boutton pour cree l'athlete
     */
    private Button creeSport;

    private Label labelNomEpreuve;
    private TextField TfNomEpreuve;
    private Label labelSport;
    private ComboBox<Sport> comboSport;
    private CheckBox checkBoxSport;

    private FenetreAdministrateur appAdm;

    public FenetreAjouterEpreuve(Main app) {
        super();
        this.app = app;
        this.appAdm = new FenetreAdministrateur(app);
        this.setTop(creerEnTete());
        this.setCenter(modeAjouterEpreuve());

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

    // private HBox titre() {
    // HBox banniere = new HBox();
    // banniere.setMinHeight(80);
    // banniere.setAlignment(Pos.CENTER);
    // banniere.setPadding(new Insets(20, 10, 20, 10));
    // banniere.setStyle("-fx-border-color: transparent transparent black
    // transparent; -fx-border-width: 0 0 1 0;");

    // ImageView iutImg = new ImageView("file:img/iutjo.png");
    // iutImg.setFitWidth(180);
    // iutImg.setFitHeight(47);

    // titre = new Label(" Ajouter une épreuve");
    // titre.setStyle("-fx-font-size: 45px; -fx-text-fill: black;");
    // titre.setPadding(new Insets(0, 80, 0, 0));

    // ImageView homeImage = new ImageView("file:img/home.png");
    // ImageView infoImage = new ImageView("file:img/info.png");
    // homeImage.setFitWidth(30);
    // homeImage.setFitHeight(30);
    // infoImage.setFitWidth(30);
    // infoImage.setFitHeight(30);

    // this.boutonMaison = new Button("",homeImage);
    // this.boutonInfo = new Button("",infoImage);

    // HBox leftBox = new HBox(iutImg);
    // leftBox.setAlignment(Pos.CENTER_LEFT);

    // HBox rightBox = new HBox(10, boutonMaison, boutonInfo);
    // rightBox.setAlignment(Pos.CENTER_RIGHT);

    // Region leftSpacer = new Region();
    // HBox.setHgrow(leftSpacer, Priority.ALWAYS);

    // Region rightSpacer = new Region();
    // HBox.setHgrow(rightSpacer, Priority.ALWAYS);

    // boutonMaison.setOnAction(e -> {
    // Optional<ButtonType> result = popUpRetourAccueil().showAndWait();
    // if (result.isPresent() && result.get().equals(ButtonType.YES)) {
    // app.afficherAdministrateur();
    // }});

    // banniere.getChildren().addAll(leftBox, leftSpacer, titre, rightSpacer,
    // rightBox);

    // return banniere;
    // }

    public Epreuve getEpreuve() {
        String nomEpreuve = this.TfNomEpreuve.getText();
        Sport sport = this.comboSport.getValue();
        boolean collectif = this.checkBoxSport.isSelected();
        return new Epreuve(nomEpreuve, sport, collectif);

    }

    public void viderFiche() {
        this.TfNomEpreuve.setText("");
        this.comboSport.setValue(null);
        this.checkBoxSport.setSelected(false);

    }

    public GridPane modeAjouterEpreuve() {
        this.boutonInfo.setDisable(true);

        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 0, 0, 80));

        labelNomEpreuve = new Label("Nom de l'épreuve:");
        TfNomEpreuve = new TextField();
        grid.add(labelNomEpreuve, 0, 0);
        grid.add(TfNomEpreuve, 1, 0);

        labelSport = new Label("Sport:");
        comboSport = new ComboBox<>();
        comboSport.setPadding(new Insets(0, 0, 0, 125));
        grid.add(labelSport, 0, 1);
        grid.add(comboSport, 1, 1);

        Label labelCollectif = new Label("Collectif:");
        checkBoxSport = new CheckBox();
        grid.add(labelCollectif, 0, 2);
        grid.add(checkBoxSport, 1, 2);

        ImageView valide = new ImageView("file:img/valide.png");
        valide.setFitWidth(20);
        valide.setFitHeight(20);
        this.creeSport = new Button("Ajouter l'épreuve", valide);
        creeSport.setStyle(" -fx-background-radius: 20; -fx-background-color: black; -fx-text-fill: white;");
        this.appAdm.ajouterEffetSurvol(creeSport);

        grid.add(creeSport, 0, 4);
        creeSport.setOnAction(new ControleurAjouterEpreuve(this));

        return grid;

    }

    public String getTfnomEpreuve() {
        return this.TfNomEpreuve.getText();
    }

    public ComboBox<Sport> getComboSport() {
        return comboSport;
    }

    public CheckBox getCheckBoxSport() {
        return checkBoxSport;
    }

    /**
     * pop up retour à l'accueil
     */
    public Alert popUpRetourAccueil() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Etes-vous sûr de vouloir retourner à l'acceuil ?",
                ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popEpreuveAjouter() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lépreuve à bien été ajouté !");
        viderFiche();
        return alert;
    }

    public Alert popNomVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le nom  est vide !");

    }

    public Alert popSportVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Veuillez sélectionner un sport !");

    }
}
