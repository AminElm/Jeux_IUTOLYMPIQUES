package main.java.com.cdal;
/**
 * Cette classe représente le sport de l'escrime
*/
public class Escrime  extends Sport{
    private static final double COEFF_FORCE = 0.2;
    private static final double COEFF_AGILITE = 0.5;
    private static final double COEFF_ENDURANCE = 0.3;
    private static final String nom = "Escrime";

    /**
     * Constructeur de la classe Escrime
     * @param nom nom du sport
     */
    public Escrime(){
            super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
        }
    }
