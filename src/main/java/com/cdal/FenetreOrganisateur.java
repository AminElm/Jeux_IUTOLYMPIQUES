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
import javafx.util.Callback;

public class FenetreOrganisateur extends BorderPane{

    private Main app;
    private ObservableList<Epreuve> epreuves;

    public FenetreOrganisateur(Main app){
        super();
        this.app = app;
        this.epreuves = FXCollections.observableArrayList();
        this.setTop(enTete());
        this.setCenter(contenu());
    }

    private HBox enTete(){
        HBox headerHBox = new HBox();
        headerHBox.setPadding(new Insets(15, 12, 15, 12));
        headerHBox.setSpacing(10);
        headerHBox.setStyle("-fx-background-color: #336699;");
        
        ImageView imageEnTete = new ImageView(new Image("file:header.png"));
        imageEnTete.setFitHeight(50);
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
        TextField tfEpreuve = new TextField();
        tfEpreuve.setPromptText("Entrez le nom de l'épreuve");

        Label nomSport = new Label("Sport:");
        ComboBox<String> choixSport = new ComboBox<>();
        choixSport.getItems().addAll("Athlétisme", "Escrime", "VolleyBall", "Natation", "Handball");

        formulaire.add(nomEp, 0, 0);
        formulaire.add(tfEpreuve, 1, 0);
        formulaire.add(nomSport, 2, 0);
        formulaire.add(choixSport, 3, 0);

        Button lancerEp = new Button("Lancer l'épreuve");
        styleButton(lancerEp);
        lancerEp.setOnAction(e ->{
            String nomEpreuve = tfEpreuve.getText();
            String sport = choixSport.getValue();
            if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
                Sport sportEpreuve = getNomSport(sport);
                Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
                // Lancer l'épreuve (ajouter à une liste d'épreuves en cours)
                System.out.println("L'épreuve " + nomEpreuve + " a été lancée.");
            }
        });

        Button btnEnregistrer = new Button("Enregistrer l'épreuve");
        styleButton(btnEnregistrer);
        btnEnregistrer.setOnAction(e ->{
            String nomEpreuve = tfEpreuve.getText();
            String sport = choixSport.getValue();
            if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
                Sport sportEpreuve = getNomSport(sport);
                Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
                epreuves.add(epreuve);
                System.out.println("L'épreuve " + nomEpreuve + " a été enregistrée.");
                tfEpreuve.clear();
                choixSport.setValue(null);
            }
        });

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

        TableView<Epreuve> tabEpreuve = new TableView<>(epreuves);
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
        colAction.setCellFactory(getButtonCellFactory());

        tabEpreuve.getColumns().addAll(colEpreuve, colSport, colAction);

        contenu.getChildren().addAll(formHBox, tabEpreuve);

        return contenu;
    }

    private Callback<TableColumn<Epreuve, Void>, TableCell<Epreuve, Void>> getButtonCellFactory(){
        return new Callback<TableColumn<Epreuve, Void>, TableCell<Epreuve, Void>>(){
            @Override
            public TableCell<Epreuve, Void> call(final TableColumn<Epreuve, Void> param){
                final TableCell<Epreuve, Void> cell = new TableCell<Epreuve, Void>(){

                    private final Button btn = new Button();
                    private final ImageView imageView = new ImageView(new Image("file:img/delete.png", 16, 16, true, true));

                   {
                        btn.setGraphic(imageView);
                        btn.setOnAction(e ->{
                            Epreuve epreuve = getTableView().getItems().get(getIndex());
                            epreuves.remove(epreuve);
                        });
                        btn.setStyle("-fx-background-color: transparent;");
                    }

                    @Override
                    public void updateItem(Void item, boolean empty){
                        super.updateItem(item, empty);
                        if (empty){
                            setGraphic(null);
                        } else{
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
    }

    private Sport getNomSport(String sportName){
        switch (sportName){
            case "Athlétisme":
                return new Athletisme(sportName);
            case "Escrime":
                return new Escrime(sportName);
            case "VolleyBall":
                return new VolleyBall(sportName);
            case "Natation":
                return new Natation(sportName);
            case "Handball":
                return new Handball(sportName);
            default:
                return null;
        }
    }

    private void styleButton(Button button){
        button.setStyle(
            "-fx-background-color: #007BFF; " + // Couleur bleue
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-background-radius: 5px; " +
            "-fx-border-radius: 5px;"
        );

        button.setOnMouseEntered(e -> button.setStyle(
            "-fx-background-color: #0056b3; " + // Couleur bleue foncée
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-background-radius: 5px; " +
            "-fx-border-radius: 5px;"
        ));
        
        button.setOnMouseExited(e -> button.setStyle(
            "-fx-background-color: #007BFF; " + // Couleur bleue
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-padding: 10px 20px; " +
            "-fx-background-radius: 5px; " +
            "-fx-border-radius: 5px;"
        ));
    }
}