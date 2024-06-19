package main.java.com.cdal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreOrganisateur extends BorderPane{

    private TextField tfEpreuve;
    private ComboBox<String> choixSport;
    private Button lancerEp;
    private Button btnEnregistrer;
    private TableView<Epreuve> tabEpreuve;
    private ObservableList<Epreuve> epreuves;

    public FenetreOrganisateur(){
        this.epreuves = FXCollections.observableArrayList();
        this.setTop(enTete());
        this.setCenter(contenu());
    }

    private HBox enTete(){
        HBox headerHBox = new HBox();
        headerHBox.setPadding(new Insets(15, 12, 15, 12));
        headerHBox.setSpacing(10);
        headerHBox.setStyle("-fx-background-color: white;");

        ImageView imageEnTete = new ImageView(new Image("file:img/test.png"));
        imageEnTete.setFitHeight(70);
        imageEnTete.setPreserveRatio(true);

        Label titre = new Label("Organisateur d'Épreuves");
        titre.setFont(new Font("System Bold", 24));
        titre.setTextFill(Color.WHITE);

        headerHBox.getChildren().addAll(imageEnTete, titre);
        headerHBox.setAlignment(Pos.CENTER_LEFT);

        return headerHBox;
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

        lancerEp.setStyle("-fx-background-color: #005da4; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;");
        btnEnregistrer.setStyle("-fx-background-color: #005da4; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;");

        lancerEp.setOnMouseEntered(e -> lancerEp.setStyle("-fx-background-color: #4ca3dd; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;"));
        lancerEp.setOnMouseExited(e -> lancerEp.setStyle("-fx-background-color: #005da4; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;"));

        btnEnregistrer.setOnMouseEntered(e -> btnEnregistrer.setStyle("-fx-background-color: #4ca3dd; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;"));
        btnEnregistrer.setOnMouseExited(e -> btnEnregistrer.setStyle("-fx-background-color: #005da4; -fx-text-fill: white; -fx-pref-width: 200px; -fx-pref-height: 40px;"));

        HBox buttonHBox = new HBox(20);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.getChildren().addAll(lancerEp, btnEnregistrer);

        GridPane.setColumnSpan(buttonHBox, 4);
        GridPane.setHalignment(buttonHBox, javafx.geometry.HPos.CENTER);
        formulaire.add(buttonHBox, 0, 1);
        formulaire.setMargin(buttonHBox, new Insets(20, 0, 0, 0));

        ImageView imgFormulaire = new ImageView(new Image("file:sports.png"));
        imgFormulaire.setFitHeight(150);
        imgFormulaire.setPreserveRatio(true);

        HBox formHBox = new HBox(20);
        formHBox.setAlignment(Pos.CENTER);
        formHBox.getChildren().addAll(formulaire, imgFormulaire);

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
            private final Button deleteButton = new Button();
            private final ImageView imageView = new ImageView(new Image("file:img/delete.png", 16, 16, true, true));

           {
                deleteButton.setGraphic(imageView);
                deleteButton.setStyle("-fx-background-color: transparent;");
                deleteButton.setOnAction(event ->{
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
                    setGraphic(deleteButton);
                }
            }
        });

        tabEpreuve.getColumns().addAll(colEpreuve, colSport, colAction);

        contenu.getChildren().addAll(formHBox, tabEpreuve);

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
}
