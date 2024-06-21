package test.java.com.cdal;

import main.java.com.cdal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EpreuveTest {

    private Epreuve epreuveIndividuelle;
    private Epreuve epreuveCollective;
    private Sport sport;
    private Participant participant1;
    private Participant participant2;

    @BeforeEach
    void setUp() {
        sport = new Athletisme(); // Exemple de sport
        participant1 = new Athlete("Dupont", "Jean", 'M', new Pays("France"), 10, 8, 7, false, null);
        participant2 = new Athlete("Martin", "Paul", 'M', new Pays("France"), 9, 9, 9, false, null);
        epreuveIndividuelle = new Epreuve("100m", sport, false);
        epreuveCollective = new Epreuve("Relais", sport, true);
    }

    @Test
    void testConstructorWithParticipants() {
        List<Participant> participants = new ArrayList<>();
        participants.add(participant1);
        participants.add(participant2);
        Epreuve epreuve = new Epreuve(participants, "Marathon", sport, false);

        assertEquals("Marathon", epreuve.getNom());
        assertEquals(sport, epreuve.getSportEpreuve());
        assertEquals(2, epreuve.getparticipants().size());
        assertFalse(epreuve.isColectif());
    }

    @Test
    void testConstructorWithoutParticipants() {
        assertEquals("100m", epreuveIndividuelle.getNom());
        assertEquals(sport, epreuveIndividuelle.getSportEpreuve());
        assertEquals(0, epreuveIndividuelle.getparticipants().size());
        assertFalse(epreuveIndividuelle.isColectif());

        assertEquals("Relais", epreuveCollective.getNom());
        assertEquals(sport, epreuveCollective.getSportEpreuve());
        assertEquals(0, epreuveCollective.getparticipants().size());
        assertTrue(epreuveCollective.isColectif());
    }

    @Test
    void testAjouteParticipant() {
        epreuveIndividuelle.ajouteParticipant(participant1);
        epreuveIndividuelle.ajouteParticipant(participant2);

        assertEquals(2, epreuveIndividuelle.getparticipants().size());
        assertTrue(epreuveIndividuelle.getparticipants().contains(participant1));
        assertTrue(epreuveIndividuelle.getparticipants().contains(participant2));
    }

    @Test
    void testSetNom() {
        epreuveIndividuelle.setNom("200m");
        assertEquals("200m", epreuveIndividuelle.getNom());
    }

    @Test
    void testSetSportEpreuve() {
        Sport nouveauSport = new Escrime();
        epreuveIndividuelle.setSportEpreuve(nouveauSport);
        assertEquals(nouveauSport, epreuveIndividuelle.getSportEpreuve());
    }

    @Test
    void testClassement() {
        epreuveIndividuelle.ajouteParticipant(participant1);
        epreuveIndividuelle.ajouteParticipant(participant2);

        Map<Participant, Double> classement = epreuveIndividuelle.classement();
        assertEquals(2, classement.size());
        assertTrue(classement.containsKey(participant1));
        assertTrue(classement.containsKey(participant2));
    }

    @Test
    void testToString() {
        assertEquals("100m", epreuveIndividuelle.toString());
    }

    @Test
    void testEquals() {
        Epreuve epreuveDuplicate = new Epreuve("100m", sport, false);
        assertTrue(epreuveIndividuelle.equals(epreuveDuplicate));

        Epreuve epreuveDifferent = new Epreuve("Marathon", sport, false);
        assertFalse(epreuveIndividuelle.equals(epreuveDifferent));
    }
}
