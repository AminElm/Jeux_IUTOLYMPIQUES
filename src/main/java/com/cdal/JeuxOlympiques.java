// package main.java.com.cdal;
// import java.util.ArrayList;
// import java.util.List;

// public class JeuxOlympiques {
//     public static void main(String[] args) {
//         // Création des sports
//         Sport athletisme = new Athletisme("Athlétisme");
//         Sport volleyball = new VolleyBall("Volleyball");
//         Sport escrime = new Escrime("Escrime");
//         Sport handball = new Handball("Handball");
//         Sport natation = new Natation("Natation");

//         // Création des épreuves
//         Epreuve epreuve100m = new Epreuve("100m", athletisme);
//         Epreuve epreuveSaut = new Epreuve("Saut en longueur", athletisme);
//         Epreuve epreuveVolley = new Epreuve("Match de Volleyball", volleyball);
//         Epreuve epreuveEscrime = new Epreuve("Duel d'Escrime", escrime);
//         Epreuve epreuveHandball = new Epreuve("Match de Handball", handball);
//         Epreuve epreuveNatation = new Epreuve("100m Nage Libre", natation);

//         // Création des athlètes
//         Athlete athlete1 = new Athlete("Dupont", "Jean", "H", "France", 80, 70, 75);
//         Athlete athlete2 = new Athlete("Curie", "Marie", "F", "Canada", 65, 80, 85);
//         Athlete athlete3 = new Athlete("Ruiz", "Carlos", "H", "Espagne", 75, 85, 80);
//         Athlete athlete4 = new Athlete("Müller", "Anna", "F", "Allemagne", 70, 75, 90);
//         Athlete athlete5 = new Athlete("Smith", "John", "H", "USA", 85, 60, 80);
//         Athlete athlete6 = new Athlete("Brown", "Jessica", "F", "UK", 60, 85, 75);
//         Athlete athlete7 = new Athlete("Kim", "Jin", "H", "Corée", 78, 77, 88);
//         Athlete athlete8 = new Athlete("Li", "Wei", "F", "Chine", 72, 78, 84);

//         // Ajout des épreuves aux athlètes
//         athlete1.getEpreuves().add(epreuve100m);
//         athlete1.getEpreuves().add(epreuveHandball);

//         athlete2.getEpreuves().add(epreuveSaut);
//         athlete2.getEpreuves().add(epreuveNatation);

//         athlete3.getEpreuves().add(epreuveEscrime);
//         athlete3.getEpreuves().add(epreuveVolley);

//         athlete4.getEpreuves().add(epreuve100m);
//         athlete4.getEpreuves().add(epreuveNatation);

//         athlete5.getEpreuves().add(epreuveVolley);
//         athlete5.getEpreuves().add(epreuveHandball);

//         athlete6.getEpreuves().add(epreuveSaut);
//         athlete6.getEpreuves().add(epreuveEscrime);

//         athlete7.getEpreuves().add(epreuve100m);
//         athlete7.getEpreuves().add(epreuveNatation);

//         athlete8.getEpreuves().add(epreuveHandball);
//         athlete8.getEpreuves().add(epreuveVolley);

//         // Création des équipes
//         Equipe equipe1 = new Equipe("Équipe A");
//         equipe1.ajouteAthlete(athlete1);
//         equipe1.ajouteAthlete(athlete2);

//         Equipe equipe2 = new Equipe("Équipe B");
//         equipe2.ajouteAthlete(athlete3);
//         equipe2.ajouteAthlete(athlete4);

//         Equipe equipe3 = new Equipe("Équipe C");
//         equipe3.ajouteAthlete(athlete5);
//         equipe3.ajouteAthlete(athlete6);

//         Equipe equipe4 = new Equipe("Équipe D");
//         equipe4.ajouteAthlete(athlete7);
//         equipe4.ajouteAthlete(athlete8);

//         // Création des pays
//         Pays france = new Pays("France", 2);
//         Pays canada = new Pays("Canada", 2);
//         Pays espagne = new Pays("Espagne", 2);
//         Pays allemagne = new Pays("Allemagne", 2);
//         Pays usa = new Pays("USA", 2);
//         Pays uk = new Pays("UK", 2);
//         Pays coree = new Pays("Corée", 2);
//         Pays chine = new Pays("Chine", 2);

//         // Ajout des équipes aux pays
//         france.getEquipes().add(equipe1);
//         canada.getEquipes().add(equipe1);
//         espagne.getEquipes().add(equipe2);
//         allemagne.getEquipes().add(equipe2);
//         usa.getEquipes().add(equipe3);
//         uk.getEquipes().add(equipe3);
//         coree.getEquipes().add(equipe4);
//         chine.getEquipes().add(equipe4);

//         // Création des résultats
//         Resultat resultat = new Resultat();
//         resultat.ajouterScoreEquipe(equipe1.getNom(), (int) equipe1.participer(epreuve100m));
//         resultat.ajouterScoreEquipe(equipe1.getNom(), (int) equipe1.participer(epreuveHandball));
//         resultat.ajouterScoreEquipe(equipe2.getNom(), (int) equipe2.participer(epreuveEscrime));
//         resultat.ajouterScoreEquipe(equipe2.getNom(), (int) equipe2.participer(epreuveNatation));
//         resultat.ajouterScoreEquipe(equipe3.getNom(), (int) equipe3.participer(epreuveVolley));
//         resultat.ajouterScoreEquipe(equipe3.getNom(), (int) equipe3.participer(epreuveHandball));
//         resultat.ajouterScoreEquipe(equipe4.getNom(), (int) equipe4.participer(epreuve100m));
//         resultat.ajouterScoreEquipe(equipe4.getNom(), (int) equipe4.participer(epreuveNatation));

//         // Affichage des résultats
//         System.out.println("Liste des équipes et leurs scores:\n" + resultat + "\n");

//         // Affichage des meilleurs et pires équipes
//         System.out.println("Meilleure équipe: " + resultat.meilleurEquipe() + "\n");
//         System.out.println("Pire équipe: " + resultat.pireEquipe() + "\n");

//         // Tri des équipes par scores
//         resultat.trierEquipesParScores();
//         System.out.println("Liste des équipes triées par scores:\n" + resultat + "\n");

//         // Vérification de l'existence d'une équipe
//         System.out.println(resultat.equipeExiste("Équipe A"));
//         System.out.println(resultat.equipeExiste("Équipe C") + "\n");

//         // Suppression d'une équipe
//         resultat.supprimerEquipe("Équipe A");
//         System.out.println("Liste des équipes après suppression:\n" + resultat + "\n");

//         // Test des athlètes individuels
//         System.out.println("Performances des athlètes:\n");
//         System.out.println(athlete1.getNom() + " participe au " + epreuve100m.getNom() + " et obtient un score de " + athlete1.participer(epreuve100m));
//         System.out.println(athlete2.getNom() + " participe au " + epreuveSaut.getNom() + " et obtient un score de " + athlete2.participer(epreuveSaut));
//         System.out.println(athlete3.getNom() + " participe au " + epreuveEscrime.getNom() + " et obtient un score de " + athlete3.participer(epreuveEscrime));
//         System.out.println(athlete4.getNom() + " participe au " + epreuveNatation.getNom() + " et obtient un score de " + athlete4.participer(epreuveNatation));
//         System.out.println(athlete5.getNom() + " participe au " + epreuveVolley.getNom() + " et obtient un score de " + athlete5.participer(epreuveVolley));
//         System.out.println(athlete6.getNom() + " participe au " + epreuveSaut.getNom() + " et obtient un score de " + athlete6.participer(epreuveSaut));
//         System.out.println(athlete7.getNom() + " participe au " + epreuve100m.getNom() + " et obtient un score de " + athlete7.participer(epreuve100m));
//         System.out.println(athlete8.getNom() + " participe au " + epreuveHandball.getNom() + " et obtient un score de " + athlete8.participer(epreuveHandball) + "\n");

//         // Test du tri des athlètes dans une équipe
//         System.out.println("Liste des athlètes de " + equipe1.getNom() + " avant tri:");
//         for (Athlete ath : equipe1.getAthletes()) {
//             System.out.println(ath);
//         }
//         System.out.println();
        
//         equipe1.trierListe();
        
//         System.out.println("Liste des athlètes de " + equipe1.getNom() + " après tri:");
//         for (Athlete ath : equipe1.getAthletes()) {
//             System.out.println(ath);
//         }
//         System.out.println();

//         // Affichage de l'athlète le plus fort, le plus endurant et le plus agile de chaque équipe
//         System.out.println("Athlète le plus fort de " + equipe1.getNom() + ": " + equipe1.plusFort() + "\n");
//         System.out.println("Athlète le plus endurant de " + equipe1.getNom() + ": " + equipe1.plusEndurant() + "\n");
//         System.out.println("Athlète le plus agile de " + equipe1.getNom() + ": " + equipe1.plusAgile() + "\n");

//         System.out.println("Athlète le plus fort de " + equipe2.getNom() + ": " + equipe2.plusFort() + "\n");
//         System.out.println("Athlète le plus endurant de " + equipe2.getNom() + ": " + equipe2.plusEndurant() + "\n");
//         System.out.println("Athlète le plus agile de " + equipe2.getNom() + ": " + equipe2.plusAgile() + "\n");

//         System.out.println("Athlète le plus fort de " + equipe3.getNom() + ": " + equipe3.plusFort() + "\n");
//         System.out.println("Athlète le plus endurant de " + equipe3.getNom() + ": " + equipe3.plusEndurant() + "\n");
//         System.out.println("Athlète le plus agile de " + equipe3.getNom() + ": " + equipe3.plusAgile() + "\n");

//         System.out.println("Athlète le plus fort de " + equipe4.getNom() + ": " + equipe4.plusFort() + "\n");
//         System.out.println("Athlète le plus endurant de " + equipe4.getNom() + ": " + equipe4.plusEndurant() + "\n");
//         System.out.println("Athlète le plus agile de " + equipe4.getNom() + ": " + equipe4.plusAgile());
//     }
// }
