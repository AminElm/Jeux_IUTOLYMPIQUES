import java.sql.*;
import java.util.ArrayList;

import main.java.com.cdal.Equipe;


public class requete {
	ConnexionMySQL laConnexion;
	Statement st;

	public requete(ConnexionMySQL laConnexion) {
		this.laConnexion = laConnexion;
	}

	public int ajouteAthletAvecEquipe(int idA,Pays p, Equipe e, String prenom, String nom, char sexe, int endurence, int forces, int agilite)throws SQLException{
		
		int idP = this.getidPays(p);
		int idEq = this.getidEquipe(e);
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into ATHLETE (idA, idP, idEq, prenomA, nomA, sexe, endurence, forces, agilite) values ("
					+String.valueOf(idA)+","+String.valueOf(idP)+","+String.valueOf(idEq)+","+prenom+","+nom+","+sexe+","+String.valueOf(endurence)+","+String.valueOf(forces)+","+String.valueOf(agilite)+");");

		sn.executeUpdate();
			
	}

	public int ajouteAthletSansEquipe(int idA,Pays p, String prenom, String nom, char sexe, int endurence, int forces, int agilite)throws SQLException{
		
		int idP = this.getidPays(p);
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into ATHLETE (idA, idP, idEq, prenomA, nomA, sexe, endurence, forces, agilite) values ("
					+String.valueOf(idA)+","+String.valueOf(idP)+","+"NULL"+","+prenom+","+nom+","+sexe+","+String.valueOf(endurence)+","+String.valueOf(forces)+","+String.valueOf(agilite)+");");

		sn.executeUpdate();
			
	}
	public int getidPays(Pays p){
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idP from PAYS where nomP ="+p.getNom());
		rs.next();
		return rs.getInt(1);
	}

	public int getidEquipe(Equipe e){
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idEq from EQUIPE where nomEq ="+e.getNom());
		rs.next();
		return rs.getInt(1);
	}








	public void ajoutevisiteur(String nom, String prenom, String mdp){
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into PERSONNE (idPers, prenomP, nomA, mdp) values ("+nom+","+prenom+","+mdp+",);");
		sn.executeUpdate();

	
	}





}