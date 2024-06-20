package main.java.com.cdal;

import java.sql.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent ;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


public class ControleurInscription implements EventHandler<ActionEvent>{
    
    private FenetreInscription appli;
    private Requete requete;
    
    public ControleurInscription(FenetreInscription appli){
        this.appli = appli;
        try {
            this.requete = new Requete();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void handle(ActionEvent event){
        if(appli.getChampUtilisateur().length() == 0){
            popNomUtilVide().showAndWait();
        } else
            try {
                if(requete.personneExiste("'"+appli.getChampUtilisateur()+"'")){
                    popPseudoDejaUtilise().showAndWait();
                }
                else if(!(appli.getChampMotDePasse().equals(appli.getChampConfirmationMotDePasse()))){
                    popMdpDiff().showAndWait();
                }
                else if(appli.getChampMotDePasse().length() < 6){
                    popMdpToShort().showAndWait();
                }
                else{
                    try {
                        requete.ajouteVisiteur("'"+appli.getChampUtilisateur()+"'", "'"+appli.getChampMotDePasse().hashCode()+"'");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    popInscriptionReussi().showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public Alert popNomUtilVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le nom d'utilisateur est vide !");
    }

    public Alert popMdpDiff() {
        return new Alert(Alert.AlertType.INFORMATION, "Les 2 mdp sont différents !");
    }

    public Alert popMdpToShort() {
        return new Alert(Alert.AlertType.INFORMATION, "Le mdp est trop court !");
    }

    public Alert popInscriptionReussi() {
        return new Alert(Alert.AlertType.INFORMATION, "Vous etes bien inscrit !");
    }

    public Alert popPseudoDejaUtilise() {
        return new Alert(Alert.AlertType.INFORMATION, "Ce pseudo est deja utilisé !");
    }
}
