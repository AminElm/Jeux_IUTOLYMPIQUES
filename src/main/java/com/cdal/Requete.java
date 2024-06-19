package main.java.com.cdal;

import java.sql.*;
import java.util.ArrayList;

import main.java.com.cdal.Equipe;


public class Requete {
	ConnexionMySQL laConnexion;
	Statement st;

	public Requete()throws SQLException, ClassNotFoundException {
		this.laConnexion = new ConnexionMySQL();
        this.laConnexion.connecter();
		
	}

	public int ajouteAthletAvecEquipe(int idA,Pays p, Equipe e, String prenom, String nom, char sexe, int endurence, int forces, int agilite)throws SQLException{
		
		int idP = this.getidPays(p);
		int idEq = this.getidEquipe(e);
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into ATHLETE (idA, idP, idEq, prenomA, nomA, sexe, endurence, forces, agilite) values ("
					+String.valueOf(idA)+","+String.valueOf(idP)+","+String.valueOf(idEq)+","+prenom+","+nom+","+sexe+","+String.valueOf(endurence)+","+String.valueOf(forces)+","+String.valueOf(agilite)+");");

		sn.executeUpdate();
		return this.getNbAthlete();
			
	}

	public int ajouteAthletSansEquipe(int idA,Pays p, String prenom, String nom, char sexe, int endurence, int forces, int agilite)throws SQLException{
		int idP = this.getidPays(p);
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into ATHLETE (idA, idP, idEq, prenomA, nomA, sexe, endurence, forces, agilite) values ("
					+String.valueOf(idA)+","+String.valueOf(idP)+","+"NULL"+","+prenom+","+nom+","+sexe+","+String.valueOf(endurence)+","+String.valueOf(forces)+","+String.valueOf(agilite)+");");

		sn.executeUpdate();
		return this.getNbAthlete();}


	public int ajoutePays(int idP,String nomP)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
					"insert into PAYS(idP,nomP) values ("+String.valueOf(idP)+","+nomP+");");
		sn.executeUpdate();
		return this.getNbPays();}

	public int ajouteSport(int idS,String nomS)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into SPORT(idS,nomS) values ("+String.valueOf(idS)+","+nomS+");");
		sn.executeUpdate();
		return this.getNbSport();}

	public int ajouteEpreuve(int idEp,String nomEp)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into EPREUVE(idEp,nomEp) values ("+String.valueOf(idEp)+","+nomEp+");");
		sn.executeUpdate();
		return this.getNbEpreuve();}

	public int ajouteEquipe(int idEq,String nomEq)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into Equipe(idEq,nomEq) values ("+String.valueOf(idEq)+","+nomEq+");");
		sn.executeUpdate();
		return this.getNbEquipe();}










	public int getidPays(Pays p)throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idP from PAYS where nomP ="+p.getNom());
		rs.next();
		return rs.getInt(1);
	}

	public int getidEquipe(Equipe e)throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idEq from EQUIPE where nomEq ="+e.getNom());
		rs.next();
		return rs.getInt(1);
	}





	public int getNbPays()throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idP) from PAYS;");
		rs.next();
		return rs.getInt(1);}

	public int getNbAthlete()throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idA) from ATHLETE;");
		rs.next();
		return rs.getInt(1);}

	public int getNbSport()throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idS) from SPORT;");
		rs.next();
		return rs.getInt(1);}

	public int getNbEpreuve()throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idEp) from EPREUVE;");
		rs.next();
		return rs.getInt(1);}

	public int getNbEquipe()throws SQLException{
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idEq) from EQUIPE;");
		rs.next();
		return rs.getInt(1);}
	










	public void ajouteVisiteur(String pseudos, String mdp)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into PERSONNE (pseudos, mdp, roles) values ("+pseudos+","+mdp+",'visit');");
		sn.executeUpdate();
	}

	public void ajouteAdmin(String pseudos, String mdp)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into PERSONNE (pseudos, mdp,roles) values ("+pseudos+","+mdp+",'admin');");
		sn.executeUpdate();
	}

	public void ajouteOrga(String pseudos, String mdp)throws SQLException{
		PreparedStatement sn = laConnexion.prepareStatement(
			"insert into PERSONNE (pseudos, mdp,roles) values ("+pseudos+","+mdp+",'orga');");
		sn.executeUpdate();
	}

	public boolean personneExiste(String pseudo) throws SQLException{
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select * from PERSONNE where pseudos = " + pseudo);
		return rs.next();
	}

	public int mdpPersonne(String pseudo) throws SQLException{
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select mdp from PERSONNE where pseudos = " + pseudo);
		rs.next();
		return rs.getInt(1);
	}

	public String rolePersonne(String pseudo) throws SQLException{
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select roles from PERSONNE where pseudos = " + pseudo);
		rs.next();
		return rs.getString(1);
	}





}