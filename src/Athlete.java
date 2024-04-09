public class Athlete{
    private String nom;
    private String prenom;
    private String sexe;
    private String nationalite;
    private int force;
    private int agilite;
    private int endurance;

    /** 
     * Constructeur de la classe Athlète. 
     * @param nom Chaîne de caractère indiquant le nom d'un athlète.
     * @param prenom Chaîne de caractère indiquant le prénom d'un athlète.
     * @param sexe Chaîne de caractère indiquant le sexe d'un athlète.
     * @param nationalite Chaîne de caractère indiquant la nationalité d'un athlète.
     * @param force Entier indiquant la valeur de force d'un athlète.
     * @param agilite Entier indiquant la valeur d'agilité d'un athlète.
     * @param endurance Entier indiquant la valeur d'endurance d'un athlète.
     */
    public Athlete(String nom, String prenom, String sexe, String nationalite, int force, int agilite, int endurance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.force = force;
        this.agilite = agilite;
        this.endurance = endurance;
    }
    
    /**
     * Retourne le nom de l'athlète.
     * @return Le nom de l'athlète.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retourne le prénom de l'athlète.
     * @return Le prénom de l'athlète.
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Retourne le sexe de l'athlète.
     * @return Le sexe de l'athlète.
     */
    public String getSexe() {
        return this.sexe;
    }

    /**
     * Retourne la nationalité de l'athlète.
     * @return La nationalité de l'athlète.
     */
    public String getNationalite(){
        return this.nationalite;
    }

    /**
     * Retourne la force de l'athlète.
     * @return La force de l'athlète.
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Modifie la force de l'athlète.
     * @param force La nouvelle valeur de force de l'athlète.
     */
    public void setForce(int force) {
        this.force = force;
    }

    /**
     * Retourne l'agilité de l'athlète.
     * @return L'agilité de l'athlète.
     */
    public int getAgilite() {
        return this.agilite;
    }

    /**
     * Modifie l'agilité de l'athlète.
     * @param agilite La nouvelle valeur d'agilité de l'athlète.
     */
    public void setAgilite(int agilite) {
        this.agilite = agilite;
    }

    /**
     * Retourne l'endurance de l'athlète.
     * @return L'endurance de l'athlète.
     */
    public int getEndurance() {
        return this.endurance;
    }

    /**
     * Modifie l'endurance de l'athlète.
     * @param endurance La nouvelle valeur d'endurance de l'athlète.
     */
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    
    /**
     * Retourne une représentation textuelle de l'objet Athlete.
     * @return Une chaîne de caractères décrivant l'athlète avec son nom, prénom, sexe, force, agilité et endurance.
     */
    @Override
    public String toString() {
        return "L'athlète " + getNationalite() + " " + getPrenom() + " " + getNom() + ", de sexe " + getSexe() + " est doté d'une force de " + getForce() + ", d'une agilité de " + getAgilite() + " et d'une endurance de " + getEndurance() + ".";
    }
}