package main.java.com.cdal;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class ControleurChargerFichier implements EventHandler<ActionEvent> {

    private FenetreAdministrateur app;
    private File selectedFile;

    public ControleurChargerFichier(FenetreAdministrateur app) {
        this.app = app;
    }

    public void suppFichier() {
        this.selectedFile = null;
        app.setTextFichierCharger("Charger un fichier .CSV");
        app.activerBoutonSuppression(false);

    }

    @Override
    public void handle(ActionEvent arg0) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("CSV Files", "*.csv"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            System.out.println("Fichier sélectionné : " + selectedFile.getAbsolutePath());
            app.setTextFichierCharger(selectedFile.getName());
        }
        app.activerBoutonSuppression(true);
    }

}
