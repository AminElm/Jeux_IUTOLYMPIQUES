package main.java.com.cdal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application{

    private Scene scene;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Pane root = new FenetreConnexion(this);
        this.scene = new Scene(root, 900, 700);
        stage.setScene(scene);
        stage.setTitle("Jeux IUT'Olympiques");
        stage.show();
    }

    public void afficherConnexion(){
        Pane root = new FenetreConnexion(this);
        scene.setRoot(root);
    }

    public void afficherInscription(){
        Pane root = new FenetreInscription(this);
        scene.setRoot(root);
    }

    public void afficherOrganisateur(){
        FenetreOrganisateur fenetreOrganisateur = new FenetreOrganisateur(this);
        new ControleurFenetreOrga(fenetreOrganisateur);
        scene.setRoot(fenetreOrganisateur);
    }

    public void afficherAdministrateur(){
        FenetreAdministrateur fenetreadministrateur = new FenetreAdministrateur(this);
        scene.setRoot(fenetreadministrateur);
    }

    public void afficherFenetreAjouterAthlete(){
        FenetreAjouterAthlete afficherFentreAjouterAthlete = new FenetreAjouterAthlete(this);
        scene.setRoot(afficherFentreAjouterAthlete);
    }

    public void afficherFenetreAjouterEpreuve(){
        FenetreAjouterEpreuve afficherFentreAjouterEpreuve = new FenetreAjouterEpreuve(this);
        scene.setRoot(afficherFentreAjouterEpreuve);
    }

    public void afficherFenetreSupprimerEpreuve(){
        FenetreSupprimerAthlete afficherFentreSupprimerAthlete = new FenetreSupprimerAthlete(this);
        scene.setRoot(afficherFentreSupprimerAthlete);
    }

    

    public void popUpInfoOrga() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Fonctionnalités de l'Organisateur");
        alert.setContentText("Sur cette page, vous pouvez:\n\n" +
                "- Lancer une épreuve : Cette action consiste à calculer le score des participants et créer le classement pour l'épreuve donnée.\n" +
                "- Enregistrer une épreuve : Cette action consiste à sauvegarder l'épreuve dans le tableau.");
        alert.showAndWait();
    }

    public void popUpInfoConnexion() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Page de connexion");
        alert.setContentText("Si vous faites partie de nos utilisateurs, entrez votre nom d'utilisateur et mot de passe pour vous connecter. \n" +
                            "Sinon, rejoignez-nous au plus vite !");
        alert.showAndWait();
    }    
    
    public void popUpInfoAdmin() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Fonctionnalités de l'Administrateur");
        alert.setContentText("Sur cette page, vous pouvez:\n\n" +
                "- Charger un fichier CSV : Importez des données depuis un fichier CSV.\n" +
                "- Ajouter un athlète : Créez un nouvel athlète en fournissant des informations telles que le nom, le prénom, le sexe, la nationalité, la force, l'agilité et l'endurance.\n" +
                "- Ajouter une épreuve : Ajoutez une nouvelle épreuve à la compétition.\n" +
                "- Supprimer un athlète : Retirez un athlète de la liste des participants.\n" +
                "- Supprimer une épreuve : Retirez une épreuve de la compétition.\n\n");
        alert.showAndWait();
    }    

    public void popUpInfoInscription() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Page d'inscription");
        alert.setContentText("Pour vous inscrire, veuillez suivre les étapes suivantes :\n\n" +
                "1. Remplissez tous les champs obligatoires du formulaire d'inscription.\n" +
                "2. Choisissez un nom d'utilisateur unique et un mot de passe sécurisé.\n" +
                "3. Confirmez votre mot de passe.\n");
        alert.showAndWait();
    }
    
    public void popUpInfoAthlete() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setResizable(true);
        alert.setTitle("Information");
        alert.setHeaderText("Page de création d'athlète");
        alert.setContentText("Sur cette page, vous pouvez créer un nouvel athlète en fournissant les informations suivantes :\n\n" +
                "- Nom : Entrez le nom de l'athlète.\n" +
                "- Prénom : Entrez le prénom de l'athlète.\n" +
                "- Sexe : Sélectionnez le sexe de l'athlète.\n" +
                "- Nationalité : Indiquez la nationalité de l'athlète.\n" +
                "- Force : Définissez le niveau de force de l'athlète.\n" +
                "- Agilité : Définissez le niveau d'agilité de l'athlète.\n" +
                "- Endurance : Définissez le niveau d'endurance de l'athlète.\n\n" +
                "Assurez-vous de remplir tous les champs avant de soumettre le formulaire.");
        alert.showAndWait();
    }
    
}
