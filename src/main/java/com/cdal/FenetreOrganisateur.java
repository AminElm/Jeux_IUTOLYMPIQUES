package main.java.com.cdal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreOrganisateur extends BorderPane{

    private Main app;
    private TextField tfEpreuve;
    private ComboBox<String> choixSport;
    private Button lancerEp;
    private Button btnEnregistrer;
    private TableView<Epreuve> tabEpreuve;
    private ObservableList<Epreuve> epreuves;
    private Button infoButton;
    private Button logoutButton;

    public FenetreOrganisateur(Main app){
        this.app = app;
        this.epreuves = FXCollections.observableArrayList();
        this.setTop(enTete());
        this.setCenter(contenu());
    }

    private StackPane enTete(){
        StackPane spEntete = new StackPane();
        spEntete.setPadding(new Insets(15, 12, 15, 12));
        spEntete.setStyle("-fx-background-color: white;");

        ImageView imageEnTete = new ImageView(new Image("file:img/iutjo.png"));
        imageEnTete.setFitHeight(50);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Organisateur");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.BLACK);

        logoutButton = new Button();
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

        HBox hbBoutons = new HBox(10, logoutButton, infoButton);
        hbBoutons.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setAlignment(imageEnTete, Pos.CENTER_LEFT);
        StackPane.setAlignment(titre, Pos.CENTER);
        StackPane.setAlignment(hbBoutons, Pos.CENTER_RIGHT);
        spEntete.getChildren().addAll(imageEnTete, titre, hbBoutons);

        return spEntete;
    }

    private VBox contenu(){
        VBox contenu = new VBox(20);
        contenu.setPadding(new Insets(20, 20, 20, 20));
        contenu.setAlignment(Pos.TOP_CENTER);

        GridPane formulaire = new GridPane();
        formulaire.setHgap(20);
        formulaire.setVgap(15);
        formulaire.setPadding(new Insets(20, 20, 20, 20));
        formulaire.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));

        Label nomEp = new Label("Nom de l'épreuve:");
        tfEpreuve = new TextField();
        tfEpreuve.setPromptText("Entrez le nom de l'épreuve");

        Label nomSport = new Label("Sport:");
        choixSport = new ComboBox<>();
        choixSport.getItems().addAll("Athlétisme", "Escrime", "VolleyBall", "Natation", "Handball");

        formulaire.add(nomEp, 0, 0);
        formulaire.add(tfEpreuve, 1, 0);
        formulaire.add(nomSport, 2, 0);
        formulaire.add(choixSport, 3, 0);

        lancerEp = new Button("Lancer l'épreuve");
        btnEnregistrer = new Button("Enregistrer l'épreuve");

        String styleBtn = "-fx-background-color: #005da4; -fx-text-fill: white; -fx-background-radius: 30; -fx-padding: 10 20; -fx-font-size: 14px;";
        String hoverBtn = "-fx-background-color: #96b9d0; -fx-text-fill: white; -fx-background-radius: 30; -fx-padding: 10 20; -fx-font-size: 14px;";

        lancerEp.setStyle(styleBtn);
        btnEnregistrer.setStyle(styleBtn);

        lancerEp.setOnMouseEntered(e -> lancerEp.setStyle(hoverBtn));
        lancerEp.setOnMouseExited(e -> lancerEp.setStyle(styleBtn));

        btnEnregistrer.setOnMouseEntered(e -> btnEnregistrer.setStyle(hoverBtn));
        btnEnregistrer.setOnMouseExited(e -> btnEnregistrer.setStyle(styleBtn));

        HBox buttonHBox = new HBox(20);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.getChildren().addAll(lancerEp, btnEnregistrer);

        GridPane.setColumnSpan(buttonHBox, 4);
        GridPane.setHalignment(buttonHBox, javafx.geometry.HPos.CENTER);
        formulaire.add(buttonHBox, 0, 1);
        formulaire.setMargin(buttonHBox, new Insets(20, 0, 0, 0));

        HBox hbFormulaire = new HBox(20);
        hbFormulaire.setAlignment(Pos.CENTER);
        hbFormulaire.getChildren().addAll(formulaire);

        tabEpreuve = new TableView<>(epreuves);
        tabEpreuve.setPrefHeight(200);

        TableColumn<Epreuve, String> colEpreuve = new TableColumn<>("Nom de l'épreuve");
        colEpreuve.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colEpreuve.setPrefWidth(150);
        colEpreuve.setMinWidth(100);

        TableColumn<Epreuve, String> colSport = new TableColumn<>("Sport");
        colSport.setCellValueFactory(new PropertyValueFactory<>("sportEpreuve"));
        colSport.setPrefWidth(150);
        colSport.setMinWidth(100);

        TableColumn<Epreuve, Void> colAction = new TableColumn<>("Action");
        colAction.setPrefWidth(100);
        colAction.setMinWidth(80);
        colAction.setCellFactory(param -> new TableCell<>(){
            private final Button btnSupp = new Button();
            private final ImageView imageView = new ImageView(new Image("file:img/delete.png", 16, 16, true, true));

            {
                btnSupp.setGraphic(imageView);
                btnSupp.setStyle("-fx-background-color: transparent;");
                btnSupp.setOnAction(event ->{
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
                    setGraphic(btnSupp);
                }
            }
        });

        tabEpreuve.getColumns().addAll(colEpreuve, colSport, colAction);
        contenu.getChildren().addAll(hbFormulaire, tabEpreuve);

        return contenu;
    }

    public TextField getTfEpreuve(){
        return tfEpreuve;
    }

    public ComboBox<String> getChoixSport(){
        return choixSport;
    }

    public Button getLancerEp(){
        return lancerEp;
    }

    public Button getBtnEnregistrer(){
        return btnEnregistrer;
    }

    public TableView<Epreuve> getTabEpreuve(){
        return tabEpreuve;
    }

    public ObservableList<Epreuve> getEpreuves(){
        return epreuves;
    }

    public Button getInfoButton(){
        return infoButton;
    }
}