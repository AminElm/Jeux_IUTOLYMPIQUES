package main.java.com.cdal;

import java.sql.*;

public class ConnexionMySQL {
	private Connection mysql=null;
	private boolean connecte=false;
	public ConnexionMySQL() throws ClassNotFoundException{
		Class.forName("org.mariadb.jdbc.Driver");
	}

	public void connecter() throws SQLException {
		// si tout c'est bien passé la connexion n'est plus nulle
		this.connecte=this.mysql!=null;
		mysql=DriverManager.getConnection("jdbc:mysql://servinfo-maria:3306/DBlepage","lepage","lepage");
	}
	public void close() throws SQLException {
		// fermer la connexion
		this.connecte=false;
		mysql.close();
	}

    	public boolean isConnecte() { return this.connecte;}
	public Statement createStatement() throws SQLException {
		return this.mysql.createStatement();
	}

	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}
	

}

