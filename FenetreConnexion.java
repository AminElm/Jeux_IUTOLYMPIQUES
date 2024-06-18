import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FenetreConnexion extends BorderPane{

    public FenetreConnexion(){
        super();
        ImageView logo = new ImageView(new Image("file:test.png", 100, 100, false, false));
        this.setTop();
        this.setCenter(center());

    }

    public VBox center(){
        Label connectezVous = new Label("Connectez-vous");
        TextField txtField = new TextField();
        // txtUtil.set
        PasswordField pswdField = new PasswordField();
        
        CheckBox check = new CheckBox("rester");
        Button bouttonCo = new Button("Se connecter");
        Label creeCompte = new Label("Créer un compte");
        return new VBox(connectezVous, txtField, pswdField, new HBox(check, bouttonCo), creeCompte);
    }
}
