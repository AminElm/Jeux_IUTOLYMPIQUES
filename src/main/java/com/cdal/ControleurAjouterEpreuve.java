package main.java.com.cdal;

import java.sql.SQLException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouterEpreuve implements EventHandler<ActionEvent> {

    private FenetreAjouterEpreuve app;
    private Requete requete;


    public ControleurAjouterEpreuve(FenetreAjouterEpreuve app){

        this.app = app;
        try {
            this.requete = new Requete();
            remplirComboBoxSport();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void remplirComboBoxSport() throws SQLException {
        List<Sport> sports = requete.ToutLesSports();
        app.getComboSport().getItems().addAll(sports);
    }


    @Override
    public void handle(ActionEvent event) {
        if(app.getTfnomEpreuve().length() == 0){
            app.popNomVide().showAndWait();
        }
        else if(app.getComboSport().getValue() == null){
            app.popSportVide().showAndWait();
        }
        else{
            try {
                requete.ajouteEpreuve(app.getEpreuve());
                app.popEpreuveAjouter().showAndWait();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }





   
    
}
