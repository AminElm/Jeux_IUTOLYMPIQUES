package main.java.com.cdal;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class FenetreOrganisateur extends BorderPane{

    private Main application;
    private ComboBox<Epreuve> comboBoxEpreuve;
    private ComboBox<String> comboBoxSport;
    private Button boutonLancerEpreuve;
    private Button boutonEnregistrer;
    private TableView<Epreuve> tableEpreuve;
    private ObservableList<Epreuve> listeEpreuves;
    private Button boutonInfo;
    private Button boutonDeconnexion;

    public FenetreOrganisateur(Main application){
        this.application = application;
        this.listeEpreuves = FXCollections.observableArrayList();
        this.setTop(creerEnTete());
        this.setCenter(creerContenu());
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private StackPane creerEnTete(){
        StackPane panneauEntete = new StackPane();
        panneauEntete.setPadding(new Insets(15, 12, 15, 12));
        panneauEntete.setStyle("-fx-background-color: #f0f0f0;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Organisateur");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

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

        HBox hbBoutons = new HBox(10, boutonDeconnexion, boutonInfo);
        hbBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hbBoutons, Pos.CENTER_RIGHT);
        panneauEntete.getChildren().addAll(imageEnTete, titre, hbBoutons);

        return panneauEntete;
    }

    private VBox creerContenu(){
        VBox contenu = new VBox(20);
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.TOP_CENTER);
        GridPane formulaire = new GridPane();
        formulaire.setHgap(20);
        formulaire.setVgap(15);
        formulaire.setPadding(new Insets(20, 20, 20, 20));
        formulaire.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));

        Label labelEpreuve = new Label("Nom de l'épreuve:");
        comboBoxEpreuve = new ComboBox<>();
        Label labelSport = new Label("Sport:");
        comboBoxSport = new ComboBox<>();
        comboBoxSport.getItems().addAll("Athlétisme", "Escrime", "VolleyBall", "Natation", "Handball");

        formulaire.add(labelEpreuve, 0, 0);
        formulaire.add(comboBoxEpreuve, 1, 0);
        formulaire.add(labelSport, 2, 0);
        formulaire.add(comboBoxSport, 3, 0);
        boutonLancerEpreuve = new Button("Lancer l'épreuve");
        boutonEnregistrer = new Button("Enregistrer l'épreuve");

        String styleBouton = "-fx-background-color: black; -fx-text-fill: white; -fx-background-radius: 30; -fx-padding: 10 20; -fx-font-size: 14px;";
        String styleHoverBouton = "-fx-background-color: lightgrey; -fx-text-fill: white; -fx-background-radius: 30; -fx-padding: 10 20; -fx-font-size: 14px;";

        boutonLancerEpreuve.setStyle(styleBouton);
        boutonEnregistrer.setStyle(styleBouton);

        DropShadow ombre = new DropShadow();
        ombre.setColor(Color.rgb(0, 0, 0, 0.5));
        ombre.setRadius(10);
        ombre.setSpread(0.3);

        boutonLancerEpreuve.setOnMouseEntered(e ->{
            boutonLancerEpreuve.setStyle(styleHoverBouton);
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), boutonLancerEpreuve);
            transition.setToX(1.1);
            transition.setToY(1.1);
            transition.play();
            boutonLancerEpreuve.setEffect(ombre);
        });
        boutonLancerEpreuve.setOnMouseExited(e ->{
            boutonLancerEpreuve.setStyle(styleBouton);
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), boutonLancerEpreuve);
            transition.setToX(1.0);
            transition.setToY(1.0);
            transition.play();
            boutonLancerEpreuve.setEffect(null);
        });

        boutonEnregistrer.setOnMouseEntered(e ->{
            boutonEnregistrer.setStyle(styleHoverBouton);
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), boutonEnregistrer);
            transition.setToX(1.1);
            transition.setToY(1.1);
            transition.play();
            boutonEnregistrer.setEffect(ombre);
        });
        boutonEnregistrer.setOnMouseExited(e ->{
            boutonEnregistrer.setStyle(styleBouton);
            ScaleTransition transition = new ScaleTransition(Duration.millis(200), boutonEnregistrer);
            transition.setToX(1.0);
            transition.setToY(1.0);
            transition.play();
            boutonEnregistrer.setEffect(null);
        });

        HBox hBoxBoutons = new HBox(20);
        hBoxBoutons.setAlignment(Pos.CENTER);
        hBoxBoutons.getChildren().addAll(boutonLancerEpreuve, boutonEnregistrer);
        GridPane.setColumnSpan(hBoxBoutons, 4);
        GridPane.setHalignment(hBoxBoutons, javafx.geometry.HPos.CENTER);
        formulaire.add(hBoxBoutons, 0, 1);
        formulaire.setMargin(hBoxBoutons, new Insets(20, 0, 0, 0));

        HBox hBoxFormulaire = new HBox(20);
        hBoxFormulaire.setAlignment(Pos.CENTER);
        hBoxFormulaire.getChildren().addAll(formulaire);

        tableEpreuve = new TableView<>(listeEpreuves);
        tableEpreuve.setPrefHeight(200);
        TableColumn<Epreuve, String> colonneEpreuve = new TableColumn<>("Nom de l'épreuve");
        colonneEpreuve.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colonneEpreuve.setPrefWidth(150);
        colonneEpreuve.setMinWidth(100);
        TableColumn<Epreuve, String> colonneSport = new TableColumn<>("Sport");
        colonneSport.setCellValueFactory(new PropertyValueFactory<>("sportEpreuve"));
        colonneSport.setPrefWidth(150);
        colonneSport.setMinWidth(100);
        TableColumn<Epreuve, Void> colonneAction = new TableColumn<>("Action");
        colonneAction.setPrefWidth(100);
        colonneAction.setMinWidth(80);
        colonneAction.setCellFactory(param -> new TableCell<>(){
            private final Button boutonSupprimer = new Button();
            private final ImageView imageView = new ImageView(new Image("file:img/delete.png", 16, 16, true, true));

            {
                boutonSupprimer.setGraphic(imageView);
                boutonSupprimer.setStyle("-fx-background-color: transparent;");
                boutonSupprimer.setOnAction(event ->{
                    Epreuve epreuve = getTableView().getItems().get(getIndex());
                    getTableView().getItems().remove(epreuve);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty){
                super.updateItem(item, empty);
                if (empty){
                    setGraphic(null);
                } else{
                    setGraphic(boutonSupprimer);
                }
            }
        });

        tableEpreuve.getColumns().addAll(colonneEpreuve, colonneSport, colonneAction);
        contenu.getChildren().addAll(hBoxFormulaire, tableEpreuve);

        return contenu;
    }

    public ComboBox<Epreuve> getComboBoxEpreuve(){
        return comboBoxEpreuve;
    }

    public ComboBox<String> getComboBoxSport(){
        return comboBoxSport;
    }

    public Button getBoutonLancerEpreuve(){
        return boutonLancerEpreuve;
    }

    public Button getBoutonEnregistrer(){
        return boutonEnregistrer;
    }

    public TableView<Epreuve> getTableEpreuve(){
        return tableEpreuve;
    }

    public ObservableList<Epreuve> getListeEpreuves(){
        return listeEpreuves;
    }

    public Button getBoutonInfo(){
        return boutonInfo;
    }
}
