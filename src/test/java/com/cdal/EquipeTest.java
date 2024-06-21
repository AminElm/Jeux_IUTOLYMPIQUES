package test.java.com.cdal;

import main.java.com.cdal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    private Equipe equipe;
    private Athlete athlete1;
    private Athlete athlete2;
    private Epreuve epreuve;
    private Pays pays;

    @BeforeEach
    void setUp() {
        pays = new Pays("France");
        epreuve = new Epreuve("Relais", new Athletisme(), true);
        equipe = new Equipe("Les Bleus", epreuve, pays);
        athlete1 = new Athlete("Dupont", "Jean", 'M', pays, 10, 8, 7, true, epreuve);
        athlete2 = new Athlete("Martin", "Paul", 'M', pays, 9, 9, 9, true, epreuve);
    }

    @Test
    void testGetNom() {
        assertEquals("Les Bleus", equipe.getNom());
    }

    @Test
    void testSetNom() {
        equipe.setNom("Les Rouges");
        assertEquals("Les Rouges", equipe.getNom());
    }

    @Test
    void testGetPays() {
        assertEquals(pays, equipe.getPays());
    }

    @Test
    void testGetAthletes() {
        equipe.ajouteAthlete(athlete1);
        List<Athlete> athletes = equipe.getAthletes();
        assertEquals(1, athletes.size());
        assertTrue(athletes.contains(athlete1));
    }

    @Test
    void testAjouteAthlete() {
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        List<Athlete> athletes = equipe.getAthletes();
        assertEquals(2, athletes.size());
        assertTrue(athletes.contains(athlete1));
        assertTrue(athletes.contains(athlete2));
    }

    @Test
    void testTrierListe() {
        Athlete athlete3 = new Athlete("Bernard", "Alain", 'M', pays, 8, 10, 10, true, epreuve);
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);
        equipe.ajouteAthlete(athlete3);
        equipe.trierListe();

        List<Athlete> athletes = equipe.getAthletes();
        assertEquals(athlete3, athletes.get(0));
        assertEquals(athlete2, athletes.get(1));
        assertEquals(athlete1, athletes.get(2));
    }

    @Test
    void testPlusFort() {
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        assertEquals(athlete1, equipe.plusFort());
    }

    @Test
    void testPlusEndurant() {
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        assertEquals(athlete2, equipe.plusEndurant());
    }

    @Test
    void testPlusAgile() {
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        assertEquals(athlete2, equipe.plusAgile());
    }

    @Test
    void testParticiper() {
        equipe.ajouteAthlete(athlete1);
        equipe.ajouteAthlete(athlete2);

        double score = equipe.participer(epreuve);
        assertTrue(score > 0);
    }

    @Test
    void testToString() {
        assertEquals("Les Bleus (France)", equipe.toString());
    }

    @Test
    void testEquals() {
        Equipe equipeDuplicate = new Equipe("Les Bleus", epreuve, pays);
        assertTrue(equipe.equals(equipeDuplicate));

        Equipe equipeDifferent = new Equipe("Les Rouges", epreuve, pays);
        assertFalse(equipe.equals(equipeDifferent));
    }
}
