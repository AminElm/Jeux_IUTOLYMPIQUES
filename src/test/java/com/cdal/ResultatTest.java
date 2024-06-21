package test.java.com.cdal;

import main.java.com.cdal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ResultatTest {

    private Resultat resultat;
    private Epreuve epreuve;
    private Participant athlete1;
    private Participant athlete2;
    private Participant athlete3;

    @BeforeEach
    void setUp() {
        epreuve = new Epreuve("100m", new Athletisme(), false);
        Pays france = new Pays("France");
        athlete1 = new Athlete("Dupont", "Jean", 'M', france, 10, 8, 7, false, epreuve);
        athlete2 = new Athlete("Martin", "Paul", 'M', france, 9, 9, 9, false, epreuve);
        athlete3 = new Athlete("Durand", "Luc", 'M', france, 8, 10, 10, false, epreuve);
        List<Participant> participants = new ArrayList<>();
        participants.add(athlete1);
        participants.add(athlete2);
        participants.add(athlete3);
        resultat = new Resultat(participants, epreuve);
    }

    @Test
    void testMeilleurParticipant() {
        assertEquals(athlete1, resultat.meilleurParticipant());
    }

    @Test
    void testPireParticipant() {
        assertEquals(athlete3, resultat.pireParticipant());
    }

    @Test
    void testAttribuerMedaille() {
        String expectedMedals = "Médaille d'or: Dupont\nMédaille d'argent: Martin\nMédaille de bronze: Durand\n";
        assertEquals(expectedMedals, resultat.attribuerMedaille());
    }

    @Test
    void testAttribuerMedailleNotEnoughParticipants() {
        List<Participant> participants = new ArrayList<>();
        participants.add(athlete1);
        participants.add(athlete2);
        Resultat smallResultat = new Resultat(participants, epreuve);
        assertEquals("Il n'y a pas assez de participants pour attribuer des médailles.", smallResultat.attribuerMedaille());
    }

    @Test
    void testParticipantExiste() {
        assertEquals("Le participant Dupont est bien dans la liste des résultats", resultat.participantExiste("Dupont"));
        assertEquals("Le participant Inconnu n'est pas dans la liste des résultats", resultat.participantExiste("Inconnu"));
    }

    @Test
    void testSupprimerParticipant() {
        resultat.supprimerParticipant("Dupont");
        assertEquals(2, resultat.getScores().size());
        assertFalse(resultat.getScores().containsKey(athlete1));
    }

    @Test
    void testTrierResultatsParScore() {
        // Participants are already sorted by score in the constructor
        Map<Participant, Integer> scores = resultat.getScores();
        List<Participant> sortedParticipants = new ArrayList<>(scores.keySet());
        assertEquals(athlete1, sortedParticipants.get(0));
        assertEquals(athlete2, sortedParticipants.get(1));
        assertEquals(athlete3, sortedParticipants.get(2));
    }

    @Test
    void testToString() {
        String expectedString = "Dupont: " + resultat.getScores().get(athlete1) + "\n" +
                                "Martin: " + resultat.getScores().get(athlete2) + "\n" +
                                "Durand: " + resultat.getScores().get(athlete3) + "\n";
        assertEquals(expectedString, resultat.toString());
    }
}
