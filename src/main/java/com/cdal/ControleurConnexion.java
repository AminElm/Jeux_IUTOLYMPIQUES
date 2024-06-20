package main.java.com.cdal;

import javafx.event.EventHandler;

import java.io.FileWriter;
import java.io.IOException;
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
                    try {
                        FileWriter writer = new FileWriter("src/main/java/com/cdal/idPrec.txt");
                        if(appli.getStayConnectedCheckBox().isSelected()){
                            System.out.println("ici");
                            writer.write(appli.getUsernameField()+"\n");
                            writer.write(appli.getPasswordField()+"\n");
                            writer.close();
                        }
                        else{
                            writer.write("\n");
                            writer.write("\n");
                            writer.close();
                        }
                        System.out.println("Successfully wrote text to file.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    switch (role) {
                        case "visit":
                            
                            break;
                        case "orga":
                            appli.getApp().afficherOrganisateur();
                            break;
                        case "admin":
                            appli.getApp().afficherAdministrateur();
                            break;
                        default:
                            break;
                    }
                }
                else{
                    System.out.println("probleme");
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
