package main.java.com.cdal;
/**
 * Cette classe représente le sport du Handball
*/
public class Handball  extends Sport{
    private static final double COEFF_FORCE =  0.2;
    private static final double COEFF_AGILITE = 0.3;
    private static final double COEFF_ENDURANCE = 0.5;

    /**
     * Constructeur de la classe Handball
     * @param nom nom du sport
     */
    public Handball(String nom){
        super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
    }
}
