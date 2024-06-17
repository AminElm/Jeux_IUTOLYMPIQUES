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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FenetreConnexion extends BorderPane {

    private Main app;

    public FenetreConnexion(Main app) {
        super();
        this.app = app;
        ImageView topImageView = new ImageView(new Image("file:test.png", 100, 100, false, false));
        topImageView.setPreserveRatio(true);
        this.setTop(topImageView);

        // Ajout de la HBox centrale au BorderPane
        this.setCenter(center());

    }

    public HBox center() {
        // Section du centre avec HBox
        HBox centerHBox = new HBox(10);
        centerHBox.setPadding(new Insets(10, 0, 0, 10));
        centerHBox.setAlignment(Pos.CENTER);

        // VBox pour les éléments de connexion
        VBox loginVBox = new VBox(10);
        loginVBox.setPadding(new Insets(0, 0, 0, 50));
        Label titleLabel = new Label("Connectez vous");
        titleLabel.setFont(new Font("System Bold", 18));
        titleLabel.setAlignment(Pos.CENTER);

        TextField usernameField = new TextField();
        usernameField.setPromptText("nom d'utilisateur");
        usernameField.setMaxWidth(238);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("mot de passe");
        passwordField.setMaxWidth(238);

        HBox buttonHBox = new HBox(5);
        CheckBox stayConnectedCheckBox = new CheckBox("rester connecté");
        Button loginButton = new Button("Se connecter");
        buttonHBox.getChildren().addAll(stayConnectedCheckBox, loginButton);

        Label createAccountLabel = new Label("Créer un compte");
        createAccountLabel.setTextFill(Color.web("#0000009b"));
        createAccountLabel.setOnMouseClicked(e -> app.afficherInscription());
        Utils.setCursorOnHover(createAccountLabel, Cursor.HAND);

        loginVBox.getChildren().addAll(titleLabel, usernameField, passwordField, buttonHBox, createAccountLabel);
        loginVBox.setAlignment(Pos.CENTER);

        // ImageView à côté de la VBox
        ImageView sideImageView = new ImageView(new Image(getClass().getResourceAsStream("/test.png")));
        sideImageView.setFitHeight(200);
        sideImageView.setFitWidth(200);
        sideImageView.setPreserveRatio(true);

        // Ajout de la VBox et de l'ImageView à la HBox centrale
        centerHBox.getChildren().addAll(loginVBox, sideImageView);
        centerHBox.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        centerHBox.setSpacing(30);

        return centerHBox;
    }
}
