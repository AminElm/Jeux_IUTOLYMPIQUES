package main.java.com.cdal;
/**
 * Cette classe représente le sport du volleyball
*/
public class VolleyBall  extends Sport{
    private static final double COEFF_FORCE = 0.2;
    private static final double COEFF_AGILITE = 0.3;
    private static final double COEFF_ENDURANCE = 0.5;

    private static final String nom = "VolleyBall";



    /**
     * Constructeur de la classe volleyball
     * @param nom nom du sport
     */

    public VolleyBall(){

        super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
    }
}
