package main.java.com.cdal;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ControleurSupprimerAthlete implements EventHandler<ActionEvent> {

    private FenetreSupprimerAthlete app;
    private Requete requete;


    public ControleurSupprimerAthlete(FenetreSupprimerAthlete app){

        this.app = app;
        try {
            this.requete = new Requete();
            remplirComboBoxAthlete();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void remplirComboBoxAthlete() throws SQLException {
        List<Athlete> athlete = requete.touAthletes();
        app.getComboBoxAthlete().getItems().addAll(athlete);
    }


    @Override
    public void handle(ActionEvent event) {
        if(app.getComboBoxAthlete().getValue() == null){
            app.popIdVide().showAndWait();
        }
        
        else{
            try {
            Optional<ButtonType> result = popUpSuppAthlete().showAndWait();
            if (result.isPresent() && result.get().equals(ButtonType.YES)) {
                requete.supprimeAthlete(app.getComboBoxAthlete().getValue());
                app.popAthleteSupprimer().showAndWait();
                app.getComboBoxAthlete().getItems().clear();
                remplirComboBoxAthlete();
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


        public Alert popUpSuppAthlete(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Etes-vous sûr de vouloir supprimer l'athlète ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
   
    
}
