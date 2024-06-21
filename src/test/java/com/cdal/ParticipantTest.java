package test.java.com.cdal;

import main.java.com.cdal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipantTest {

    private Athlete athlete;
    private Equipe equipe;
    private Epreuve epreuve;
    private Pays pays;

    @BeforeEach
    void setUp() {
        pays = new Pays("France");
        epreuve = new Epreuve("100m", new Athletisme(), false);
        athlete = new Athlete("Dupont", "Jean", 'M', pays, 10, 8, 7, false, epreuve);
        equipe = new Equipe("Les Bleus", epreuve, pays);
    }

    @Test
    void testAthleteGetNom() {
        assertEquals("Dupont", athlete.getNom());
    }

    @Test
    void testAthleteSetNom() {
        athlete.setNom("Durand");
        assertEquals("Durand", athlete.getNom());
    }

    @Test
    void testAthleteParticiper() {
        double score = athlete.participer(epreuve);
        assertTrue(score > 0);
    }

    @Test
    void testEquipeGetNom() {
        assertEquals("Les Bleus", equipe.getNom());
    }

    @Test
    void testEquipeSetNom() {
        equipe.setNom("Les Rouges");
        assertEquals("Les Rouges", equipe.getNom());
    }

    @Test
    void testEquipeParticiper() {
        Athlete athlete2 = new Athlete("Martin", "Paul", 'M', pays, 9, 9, 9, true, epreuve);
        equipe.ajouteAthlete(athlete);
        equipe.ajouteAthlete(athlete2);
        double score = equipe.participer(epreuve);
        assertTrue(score > 0);
    }
}
