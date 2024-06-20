
/**
 * Cette classe représente le sport de la natation
*/
public class Natation  extends Sport{
    private static final double COEFF_FORCE = 0.2;
    private static final double COEFF_AGILITE = 0.2;
    private static final double COEFF_ENDURANCE = 0.6;

    private static final String nom = "Natation";


    /**
     * Constructeur de la classe natation
     * @param nom nom du sport
     */

    public Natation(){

        super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
        }
}
