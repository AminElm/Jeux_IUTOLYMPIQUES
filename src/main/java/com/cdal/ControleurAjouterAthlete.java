package main.java.com.cdal;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControleurAjouterAthlete implements EventHandler<ActionEvent> {

    private FenetreAjouterAthlete app;
    private Requete requete;


    public ControleurAjouterAthlete(FenetreAjouterAthlete app){

        this.app = app;
        try {
            this.requete = new Requete();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void handle(ActionEvent event) {
        if(app.getTfNom().length() == 0){
            app.popNomVide().showAndWait();
        }
        else if(app.getTfPrenom().length() == 0){
            app.popPrenomVide().showAndWait();
        }
        else if(app.getRbSexe() == null ){
            app.popSexeVide().showAndWait();
        }
        else if(app.getTfNationalite().length() == 0){
            app.popNationaliteVide().showAndWait();
        }
        else if(app.getTfForce().length() == 0){
            app.popForceVide().showAndWait();
        }
        else if(app.getTfAgilite().length() == 0){
            app.popAgiliteVide().showAndWait();
        }
        else if(app.getTfEndurance().length() == 0){
            app.popEnduranceVide().showAndWait();
        }
        else{
            try {
                requete.ajouteAthletSansEquipe(app.getAthlete());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }   
}
