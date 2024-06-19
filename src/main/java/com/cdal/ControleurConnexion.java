package main.java.com.cdal;

import javafx.event.EventHandler;

import java.sql.SQLException;

import javafx.event.ActionEvent ;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


public class ControleurConnexion implements EventHandler<ActionEvent>{
    
    private FenetreConnexion appli;
    private Requete requete;

    public ControleurConnexion(FenetreConnexion appli){
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
        if(appli.getUsernameField().length() == 0){
            popNomUtilVide().showAndWait();
        }
        else if(appli.getPasswordField().length() == 0){
            popMdpUtilVide().showAndWait();
        } else
            try {
                if(!(requete.personneExiste("'"+appli.getUsernameField()+"'"))){
                   popNomUtilIntrouvable().showAndWait();
                }
                else if(appli.getPasswordField().hashCode() != requete.mdpPersonne("'"+appli.getUsernameField()+"'")){
                    popMdpIncorrect().showAndWait();
                }
                else if(appli.getPasswordField().hashCode() == requete.mdpPersonne("'"+appli.getUsernameField()+"'")){
                    String role = requete.rolePersonne("'"+appli.getUsernameField()+"'");
                    switch (role) {
                        case "visit":
                            
                            break;
                        case "orga":
                            appli.getApp().afficherOrganisateur();
                            break;
                        case "admin":
                            
                            break;
                        default:
                            break;
                    }
                }
                else{
                    // A Faire : Se rendre sur la page d'acceuil
                    System.out.println("connexion");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public Alert popNomUtilVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le nom d'utilisateur est vide !");
        
    }

    public Alert popMdpUtilVide() {
        return new Alert(Alert.AlertType.INFORMATION, "Le mdp est vide !");
        
    }

    public Alert popNomUtilIntrouvable() {
        return new Alert(Alert.AlertType.INFORMATION, "Le nom d'utilisateur est Introuvable !");
        
    }

    public Alert popMdpIncorrect() {
        return new Alert(Alert.AlertType.INFORMATION, "mdp incorrect !");
        
    }
}
