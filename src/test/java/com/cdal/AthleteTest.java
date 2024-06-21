package test.java.com.cdal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Pays;
import main.java.com.cdal.Sport;
import main.java.com.cdal.Athletisme;

class AthleteTest {

    private Athlete athlete1;
    private Athlete athlete2;
    private Pays pays;
    private Epreuve epreuve;
    private Sport sport;

    @BeforeEach
    void setUp() {
        sport = new Athletisme(); // Exemple de sport
        pays = new Pays("France");
        epreuve = new Epreuve("Course", sport);
        athlete1 = new Athlete("Dupont", "Jean", 'M', pays, 10, 8, 7, true, epreuve);
        athlete2 = new Athlete("Martin", "Paul", 'M', pays, 9, 9, 9, false);
    }

    @Test
    void testGetNom() {
        assertEquals("Dupont", athlete1.getNom());
    }

    @Test
    void testSetNom() {
        athlete1.setNom("Durand");
        assertEquals("Durand", athlete1.getNom());
    }

    @Test
    void testGetEnEquipe() {
        assertTrue(athlete1.getEnEquipe());
        assertFalse(athlete2.getEnEquipe());
    }

    @Test
    void testGetPrenom() {
        assertEquals("Jean", athlete1.getPrenom());
    }

    @Test
    void testGetSexe() {
        assertEquals('M', athlete1.getSexe());
    }

    @Test
    void testGetNationalite() {
        assertEquals(pays, athlete1.getNationalite());
    }

    @Test
    void testGetForce() {
        assertEquals(10, athlete1.getForce());
    }

    @Test
    void testSetForce() {
        athlete1.setForce(12);
        assertEquals(12, athlete1.getForce());
    }

    @Test
    void testGetAgilite() {
        assertEquals(8, athlete1.getAgilite());
    }

    @Test
    void testSetAgilite() {
        athlete1.setAgilite(10);
        assertEquals(10, athlete1.getAgilite());
    }

    @Test
    void testGetEndurance() {
        assertEquals(7, athlete1.getEndurance());
    }

    @Test
    void testSetEndurance() {
        athlete1.setEndurance(9);
        assertEquals(9, athlete1.getEndurance());
    }

    @Test
    void testGetEpreuve() {
        assertEquals(epreuve, athlete1.getEpreuve());
    }

    @Test
    void testParticiper() {
        double score = athlete1.participer(epreuve);
        assertTrue(score > 0); // On s'assure que le score est calculé et positif
    }

    @Test
    void testToString() {
        assertEquals("Jean Dupont de France", athlete1.toString());
    }

    @Test
    void testEquals() {
        Athlete athlete3 = new Athlete("Dupont", "Jean", 'M', pays, 10, 8, 7, true, epreuve);
        assertTrue(athlete1.equals(athlete3));
        assertFalse(athlete1.equals(athlete2));
    }

    @Test
    void testCompareTo() {
        assertTrue(athlete1.compareTo(athlete2) > 0);
        athlete2.setForce(10);
        athlete2.setAgilite(8);
        athlete2.setEndurance(7);
        assertEquals(0, athlete1.compareTo(athlete2));
    }

    @Test
    void testGetScore() {
        athlete1.setScore(95.5);
        assertEquals(95.5, athlete1.getScore());
    }

    @Test
    void testSetScore() {
        athlete1.setScore(88.0);
        assertEquals(88.0, athlete1.getScore());
    }

    @Test
    void testGetPlace() {
        athlete1.setPlace(1);
        assertEquals(1, athlete1.getPlace());
    }

    @Test
    void testSetPlace() {
        athlete1.setPlace(2);
        assertEquals(2, athlete1.getPlace());
    }
}
