package test.java.com.cdal;

import main.java.com.cdal.Athletisme;
import main.java.com.cdal.Sport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AthletismeTest {

    private Athletisme athletisme;

    @BeforeEach
    void setUp() {
        athletisme = new Athletisme();
    }

    @Test
    void testGetNom() {
        assertEquals("Athlétisme", athletisme.getNom());
    }

    @Test
    void testGetCoeffForce() {
        assertEquals(0.2, athletisme.getCoeffForce());
    }

    @Test
    void testGetCoeffAgilite() {
        assertEquals(0.3, athletisme.getCoeffAgilite());
    }

    @Test
    void testGetCoeffEndurance() {
        assertEquals(0.5, athletisme.getCoeffEndurance());
    }
}
