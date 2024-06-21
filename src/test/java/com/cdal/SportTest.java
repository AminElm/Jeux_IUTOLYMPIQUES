package test.java.com.cdal;

import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Sport;
import main.java.com.cdal.Athletisme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportTest {

    private Sport sport;

    @BeforeEach
    void setUp() {
        sport = new Sport("Test Sport", 0.3, 0.4, 0.5);
    }

    @Test
    void testGetCoeffForce() {
        assertEquals(0.3, sport.getCoeffForce());
    }

    @Test
    void testGetCoeffAgilite() {
        assertEquals(0.4, sport.getCoeffAgilite());
    }

    @Test
    void testGetCoeffEndurance() {
        assertEquals(0.5, sport.getCoeffEndurance());
    }

    @Test
    void testGetNom() {
        assertEquals("Test Sport", sport.getNom());
    }

    @Test
    void testAjouteEpreuve() {
        Epreuve epreuve = new Epreuve("Test Epreuve", new Athletisme());
        sport.ajouteEpreuve(epreuve);
        assertEquals(1, sport.nbDEpreuves());
    }

    @Test
    void testNbDEpreuves() {
        assertEquals(0, sport.nbDEpreuves());
        Epreuve epreuve = new Epreuve("Test Epreuve", new Athletisme());
        sport.ajouteEpreuve(epreuve);
        assertEquals(1, sport.nbDEpreuves());
    }

    @Test
    void testToString() {
        assertEquals("Test Sport", sport.toString());
    }

    @Test
    void testEquals() {
        Sport sportDuplicate = new Sport("Test Sport", 0.3, 0.4, 0.5);
        assertTrue(sport.equals(sportDuplicate));

        Sport sportDifferent = new Sport("Different Sport", 0.3, 0.4, 0.5);
        assertFalse(sport.equals(sportDifferent));
    }
}
