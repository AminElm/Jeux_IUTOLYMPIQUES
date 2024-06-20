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
        if(appli.getChampUtilisateur().length() == 0){
            popNomUtilVide().showAndWait();
        }
        else if(appli.getChampMotDePasse().length() == 0){
            popMdpUtilVide().showAndWait();
        } else
            try {
                if(!(requete.personneExiste("'"+appli.getChampUtilisateur()+"'"))){
                   popNomUtilIntrouvable().showAndWait();
                }
                else if(appli.getChampMotDePasse().hashCode() != requete.mdpPersonne("'"+appli.getChampUtilisateur()+"'")){
                    popMdpIncorrect().showAndWait();
                }
                else if(appli.getChampMotDePasse().hashCode() == requete.mdpPersonne("'"+appli.getChampUtilisateur()+"'")){
                    String role = requete.rolePersonne("'"+appli.getChampUtilisateur()+"'");
                    try {
                        FileWriter writer = new FileWriter("src/main/java/com/cdal/idPrec.txt");
                        if(appli.getResterConnecteCheckBox().isSelected()){
                            System.out.println("ici");
                            writer.write(appli.getChampUtilisateur()+"\n");
                            writer.write(appli.getChampMotDePasse()+"\n");
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
                            appli.getApplication().afficherOrganisateur();
                            break;
                        case "admin":
                            appli.getApplication().afficherAdministrateur();
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
