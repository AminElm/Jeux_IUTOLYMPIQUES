/**
 * Cette classe représente le sport de la natation
*/
public class Natation  extends Sport{
    private static final double COEFF_FORCE = 0.2;
    private static final double COEFF_AGILITE = 0.2;
    private static final double COEFF_ENDURANCE = 0.6;

    /**
     * Constructeur de la classe natation
     * @param nom nom du sport
     */
    public Natation(String nom){
        super(nom, COEFF_FORCE, COEFF_AGILITE, COEFF_ENDURANCE);
        }
    }

