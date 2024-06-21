package main.java.com.cdal;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ControleurSupprimerEpreuve implements EventHandler<ActionEvent> {

    private FenetreSupprimerEpreuve app;
    private Requete requete;


    public ControleurSupprimerEpreuve(FenetreSupprimerEpreuve app){

        this.app = app;
        try {
            this.requete = new Requete();
            remplirComboBoxEpreuve();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void remplirComboBoxEpreuve() throws SQLException {
        List<Epreuve> epreuve = requete.ToutLesEpreuves();
        app.getComboBoxEpreuve().getItems().addAll(epreuve);
    }


    @Override
    public void handle(ActionEvent event) {
        if(app.getComboBoxEpreuve().getValue() == null){
            app.popEpreuveVide().showAndWait();
        }
        
        else{
            try {
            Optional<ButtonType> result = popUpSuppAthlete().showAndWait();
            if (result.isPresent() && result.get().equals(ButtonType.YES)) {
                requete.supprimeEpreuve(app.getComboBoxEpreuve().getValue());
                app.popEpreuveSupprimer().showAndWait();
                app.getComboBoxEpreuve().getItems().clear();
                remplirComboBoxEpreuve();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


        public Alert popUpSuppAthlete(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Etes-vous sûr de vouloir supprimer l'épreuve ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
   
    
}
