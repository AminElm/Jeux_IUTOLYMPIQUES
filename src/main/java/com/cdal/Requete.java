package main.java.com.cdal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import java.util.ArrayList;

public class Requete {
	ConnexionMySQL laConnexion;
	Statement st;
  
public Requete() throws SQLException, ClassNotFoundException {
		this.laConnexion = new ConnexionMySQL();
		this.laConnexion.connecter();
	}

	public void ajouteAthletAvecEquipe(Athlete a, Equipe e) throws SQLException {
		int idA = this.getNbAthlete() + 1;
		Pays p = a.getNationalite();
		String prenom = a.getPrenom();
		String nom = a.getNom();
		char sexe = a.getSexe();
		int endurence = a.getEndurance();
		int forces = a.getForce();
		int agilite = a.getAgilite();
		int idP = this.getidPays(p);
		int idEq = this.getidEquipe(e);
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into ATHLETE (idA, idP, idEq,prenomA, nomA, sexe, endurence, forces, agilite) values ("
						+ String.valueOf(idA) + "," + String.valueOf(idP) + "," + String.valueOf(idEq) + ",'"
						+ prenom + "','" + nom + "','" + sexe + "'," + String.valueOf(endurence) + ","
						+ String.valueOf(forces) + "," + String.valueOf(agilite) + ");");
		sn.executeUpdate();
	}

	public void ajouteAthletSansEquipe(Athlete a) throws SQLException {
		int idA = this.getNbAthlete() + 1;
		Pays p = a.getNationalite();
		String prenom = a.getPrenom();
		String nom = a.getNom();
		char sexe = a.getSexe();
		int endurence = a.getEndurance();
		int forces = a.getForce();
		int agilite = a.getAgilite();
		int idP = this.getidPays(p);
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into ATHLETE (idA, idP, idEq, prenomA, nomA, sexe, endurence, forces, agilite) values ("
						+ String.valueOf(idA) + "," + String.valueOf(idP) + ",NULL,'" + prenom + "','" + nom + "','"
						+ sexe + "'," + String.valueOf(endurence) + "," + String.valueOf(forces) + ","
						+ String.valueOf(agilite) + ");");

		sn.executeUpdate();
	}

	public void ajoutePays(Pays p) throws SQLException {
		int idP = this.getNbPays() + 1;
		String nomP = p.getNom();
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PAYS(idP,nomP) values (" + String.valueOf(idP) + ",'" + nomP + "');");
		sn.executeUpdate();

	}

	public void ajouteSport(Sport s) throws SQLException {
		int idS = this.getNbSport() + 1;
		String nomS = s.getNom();
		double coeffForce = s.getCoeffForce();
		double coeffAgilite = s.getCoeffAgilite();
		double coeffEndurance = s.getCoeffEndurance();
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into SPORT(idS,nomS,coeffForce,coeffAgilite,coeffEndurance) values (" + String.valueOf(idS)
						+ ",'" +nomS +"',"+ String.valueOf(coeffForce) + "," + String.valueOf(coeffAgilite) + ","
						+ String.valueOf(coeffEndurance) +");");
		sn.executeUpdate();
	}

	public void ajouteEpreuve(Epreuve e) throws SQLException {
		int idEp = this.getNbEpreuve() + 1;
		String nomEp = e.getNom();
		int idS = this.getidSport(e.getSportEpreuve());
		PreparedStatement sn = laConnexion.prepareStatement(

								"insert into EPREUVE(idEp,nomEp,idS) values (" + String.valueOf(idEp) + ",'" + nomEp + "',"+ String.valueOf(idS) + ");");
		sn.executeUpdate();
	}

	public void ajouteEquipe(Equipe e) throws SQLException {
		int idEq = this.getNbEquipe() + 1;
		int idP = this.getidPays(e.getPays());
		String nomEq = e.getNom();
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into EQUIPE(idEq,idP,nomEq) values (" + String.valueOf(idEq) + "," + String.valueOf(idP) + ",'" + nomEq + "');");
		sn.executeUpdate();
	}

	public void ajouteParticipEq(Epreuve ep, Equipe eq) throws SQLException {
		int idEp = this.getidEpreuve(ep);
		int idEq = this.getidEquipe(eq);
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PARTICIPE_Eq(idEq,idEp,score) values (" + String.valueOf(idEq) + "," + String.valueOf(idEp) + ",0);");
		sn.executeUpdate();
	}

	public void ajouteParticipA(Epreuve ep, Athlete a) throws SQLException {
		int idEp = this.getidEpreuve(ep);
		int idA = this.getidAtlhete(a);
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PARTICIPE_A(idA,idEp,score) values (" + String.valueOf(idA) + "," + String.valueOf(idEp) + ",0);");
		sn.executeUpdate();
	}

	public int getidPays(Pays p) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idP from PAYS where nomP ='" + p.getNom() + "';");
		rs.next();
		return rs.getInt(1);
	}

	public int getidEquipe(Equipe e) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idEq from EQUIPE where nomEq ='" + e.getNom() + "' and idP ="+String.valueOf(this.getidPays(e.getPays()))+";");
		rs.next();
		return rs.getInt(1);
	}

	public int getidSport(Sport s) throws SQLException {
		System.out.println(s.getNom());
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idS from SPORT where nomS ='" + s.getNom() + "';");
		rs.next();
		return rs.getInt(1);
	}

	public int getidAtlhete(Athlete a) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery(
				"select idA from ATHLETE where nomA ='" + a.getNom() + "'and prenomA = '" + a.getPrenom() + "' and idP ="+String.valueOf(getidPays(a.getNationalite()))+";");
		rs.next();
		return rs.getInt(1);
	}

	public int getidEpreuve(Epreuve e) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idEp from EPREUVE where nomEp ='" + e.getNom() + "';");
		rs.next();
		return rs.getInt(1);
	}

	public int getidEpreuveParEquipe(int idEq) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select idEp from PARTICIPE_Eq where idEq =" + String.valueOf(idEq) + ";");
		rs.next();
		return rs.getInt(1);
	}

	public int getNbPays() throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idP) from PAYS;");
		rs.next();
		return rs.getInt(1);
	}

	public int getNbAthlete() throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idA) from ATHLETE;");
		rs.next();
		return rs.getInt(1);
	}

	public int getNbSport() throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idS) from SPORT;");
		rs.next();
		return rs.getInt(1);
	}

	public int getNbEpreuve() throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idEp) from EPREUVE;");
		rs.next();
		return rs.getInt(1);
	}

	public int getNbEquipe() throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select count(idEq) from EQUIPE;");
		rs.next();
		return rs.getInt(1);
	}

	public List<Epreuve> ToutLesEpreuves() throws SQLException {
        List<Epreuve> epreuves = new ArrayList<>();
        Statement st = laConnexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM EPREUVE;");
        while (rs.next()) {
            int idEp = rs.getInt("idEp");
            int idS = rs.getInt("idS");
            String nomEp = rs.getString("nomEp");
            Sport sport = getSport(idS);
            Epreuve epreuve = new Epreuve(nomEp, sport);
            epreuves.add(epreuve);
        }
        return epreuves;
    }

	public List<Pays> ToutLesPays() throws SQLException {
		List<Pays> pays = new ArrayList<>();
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select * from PAYS;");
		while (rs.next()) {
			int idP = rs.getInt(1);
			String nomP = rs.getString(2);
			pays.add(new Pays(nomP));
		}
		return pays;
	}

	public List<Equipe> ToutLesEquipes() throws SQLException {
		List<Equipe> equipes = new ArrayList<>();
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select * from EQUIPE;");
		while (rs.next()) {
			int idEq = rs.getInt(1);
			int idP = rs.getInt(2);
			int idEp = getidEpreuveParEquipe(idEq);
			String nomEq = rs.getString(3);
			Pays p = this.getPays(idP);
			Epreuve e = this.getEpreuve(idEp);
			equipes.add(new Equipe(nomEq, e, p));
		}
		return equipes;
	}

	public List<Athlete> touAthletes() throws SQLException {
        List<Athlete> athletes = new ArrayList<>();
        Statement st = laConnexion.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM ATHLETE;");
        while (rs.next()) {
			int idP = rs.getInt("idP");
			int idEq = rs.getInt("idEq");
			String prenom = rs.getString("prenomA");
			String nom = rs.getString("nomA");
			char sexe = rs.getString("sexe").charAt(0);
			int force = rs.getInt("forces");
			int agilite = rs.getInt("agilite");
			int endurance = rs.getInt("endurence");
			boolean enEquipe = idEq != 0;
			Pays pays = getPays(idP);


            Athlete ath = new Athlete(nom, prenom, sexe, pays, force, agilite, endurance, enEquipe);
            athletes.add(ath);
        }
        return athletes;
    }

	public List<Sport> ToutLesSports() throws SQLException {
		List<Sport> sports = new ArrayList<>();
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select * from SPORT;");
		while (rs.next()) {
			String nomS = rs.getString(2);
			double coeffForce = rs.getDouble(3);
			double coeffAgilite = rs.getDouble(4);
			double coeffEndurance = rs.getDouble(5);
			sports.add(new Sport(nomS, coeffForce, coeffAgilite, coeffEndurance));
		}
		return sports;
	
	}

	public List<Athlete> touAthletesParEpreuve(Epreuve e) throws SQLException {
        List<Athlete> athletes = new ArrayList<>();
        Statement st = laConnexion.createStatement();
		int idEp = this.getidEpreuve(e);
        ResultSet rs = st.executeQuery("SELECT idP,idEq,PrenomA,nomA,sexe,forces,agilite,endurence FROM ATHLETE natural join PARTICIPE_A where idEp = "+ String.valueOf(idEp)+" ;");
        while (rs.next()) {
			int idP = rs.getInt("idP");
			int idEq = rs.getInt("idEq");
			String prenom = rs.getString("prenomA");
			String nom = rs.getString("nomA");
			char sexe = rs.getString("sexe").charAt(0);
			int force = rs.getInt("forces");
			int agilite = rs.getInt("agilite");
			int endurance = rs.getInt("endurence");
			boolean enEquipe = idEq != 0;
			Pays pays = getPays(idP);


            Athlete ath = new Athlete(nom, prenom, sexe, pays, force, agilite, endurance, enEquipe);
            athletes.add(ath);
        }
        return athletes;
    }

	public List<Equipe> ToutLesEquipesParEpreuve(Epreuve e) throws SQLException {
		List<Equipe> equipes = new ArrayList<>();
		st = laConnexion.createStatement();
		int idEp = this.getidEpreuve(e);
		ResultSet rs = st.executeQuery("SELECT idEq,idP,nomEq FROM EQUIPE natural join PARTICIPE_Eq where idEp = "+ String.valueOf(idEp)+" ;");
		while (rs.next()) {
			int idP = rs.getInt(2);
			String nomEq = rs.getString(3);
			Pays p = this.getPays(idP);
			Epreuve ep = this.getEpreuve(idEp);
			equipes.add(new Equipe(nomEq, ep, p));
		}
		return equipes;
	}

	public void participeAthlete(Athlete a, Epreuve e, double score) throws SQLException {
		int idA = this.getidAtlhete(a);
		int idEp = this.getidEpreuve(e);

		PreparedStatement sn = laConnexion.prepareStatement(
				"update PARTICIPE_A set score = " + String.valueOf(score) + " where idA = " + String.valueOf(idA) + " and idEp = " + String.valueOf(idEp) + ";");
		sn.executeUpdate();}

	public void participeEquipe(Equipe eq, Epreuve e, double score) throws SQLException {
		
		int idEq = this.getidEquipe(eq);
		int idEp = this.getidEpreuve(e);

		PreparedStatement sn = laConnexion.prepareStatement(
				"update PARTICIPE_Eq set score = " + String.valueOf(score) + " where idEq = " + String.valueOf(idEq) + " and idEp = " + String.valueOf(idEp) + ";");
		sn.executeUpdate();}

	public Sport getSport(int idS) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select nomS, coeffForce, coeffAgilite, coeffEndurance from SPORT where idS =" + String.valueOf(idS) + ";");
		rs.next();
		return new Sport(rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4));
	}

	public Pays getPays(int idP) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select nomP from PAYS where idP =" + String.valueOf(idP) + ";");
		rs.next();
		return new Pays(rs.getString(1));
	}

	public Epreuve getEpreuve(int idEp) throws SQLException {
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select nomEp,idS from EPREUVE where idEp =" + String.valueOf(idEp) + ";");
		rs.next();
		Sport s = this.getSport(rs.getInt(2));
		return new Epreuve(rs.getString(1), s);
	}
	
	public double getScoreAthlete(Athlete a, Epreuve e) throws SQLException {
		int idA = this.getidAtlhete(a);
		int idEp = this.getidEpreuve(e);
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select score from PARTICIPE_A where idA = " + String.valueOf(idA) + " and idEp = " + String.valueOf(idEp) + ";");
		rs.next();
		return rs.getDouble(1);
	}

	public double getScoreEquipe(Equipe eq, Epreuve e) throws SQLException {
		int idEq = this.getidEquipe(eq);
		int idEp = this.getidEpreuve(e);
		st = laConnexion.createStatement();
		ResultSet rs = st.executeQuery("select score from PARTICIPE_Eq where idEq = " + String.valueOf(idEq) + " and idEp = " + String.valueOf(idEp) + ";");
		rs.next();
		return rs.getDouble(1);
	}
	
	public void supprimeSport(Sport s) throws SQLException {
		int idS = this.getidSport(s);
		PreparedStatement sn = laConnexion.prepareStatement("delete from SPORT where idS = " + String.valueOf(idS) + ";");
		sn.executeUpdate();
	}

	public void supprimePays(Pays p) throws SQLException {
		int idP = this.getidPays(p);
		PreparedStatement sn = laConnexion.prepareStatement("delete from PAYS where idP = " + String.valueOf(idP) + ";");
		sn.executeUpdate();
	}

	public void supprimeAthlete(Athlete a) throws SQLException {
		int idA = this.getidAtlhete(a);
		PreparedStatement sn = laConnexion.prepareStatement("delete from ATHLETE where idA = " + String.valueOf(idA) + ";");
		sn.executeUpdate();
	}

	public void supprimeEquipe(Equipe e) throws SQLException {
		int idEq = this.getidEquipe(e);
		PreparedStatement sn = laConnexion.prepareStatement("delete from EQUIPE where idEq = " + String.valueOf(idEq) + ";");
		sn.executeUpdate();
	}

	public void supprimeEpreuve(Epreuve e) throws SQLException {
		int idEp = this.getidEpreuve(e);
		PreparedStatement sn = laConnexion.prepareStatement("delete from EPREUVE where idEp = " + String.valueOf(idEp) + ";");
		sn.executeUpdate();
	}

	public void ajouteVisiteur(String pseudos, String mdp) throws SQLException {
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PERSONNE (pseudos, mdp, roles) values (" + pseudos + "," + mdp + ",'visit');");
		sn.executeUpdate();
	}

	public void ajouteAdmin(String pseudos, String mdp) throws SQLException {
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PERSONNE (pseudos, mdp,roles) values ('" + pseudos + "','" + mdp + "','admin');");
		sn.executeUpdate();
	}

	public void ajouteOrga(String pseudos, String mdp) throws SQLException {
		PreparedStatement sn = laConnexion.prepareStatement(
				"insert into PERSONNE (pseudos, mdp,roles) values ('" + pseudos + "','" + mdp + "','orga');");
		sn.executeUpdate();
	}

	public boolean personneExiste(String pseudo) throws SQLException {
		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select * from PERSONNE where pseudos = " + pseudo);
		return rs.next();
	}

	public int mdpPersonne(String pseudo) throws SQLException {

		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select mdp from PERSONNE where pseudos = " + pseudo);
		rs.next();
		return rs.getInt(1);
	}

	public String rolePersonne(String pseudo) throws SQLException {

		this.st = this.laConnexion.createStatement();
		ResultSet rs = this.st.executeQuery("Select roles from PERSONNE where pseudos = " + pseudo);
		rs.next();
		return rs.getString(1);
	}
}
