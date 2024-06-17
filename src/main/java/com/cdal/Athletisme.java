package main.java.com.cdal;

/**
 * Cette classe représente le sport de l'athlétisme
 */

public class Athletisme  extends Sport{
    private static final double COEFF_FORCE = 0.2;
    private static final double COEFF_AGILITE = 0.3;
    private static final double COEFF_ENDURANCE = 0.5;

    /**
     * Constructeur de la classe Athletisme
     * @param nom nom du sport
     */
    public Athletisme(String nom){
        super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
    }
}
