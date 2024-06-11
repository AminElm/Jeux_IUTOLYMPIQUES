/**
 * Cette interface représente un participant aux JO
 * pouvant être une équipe ou un athlète
 */
public interface Participant {

    /**
     * getter du nom du participant.
     * @return Le nom du participant
     */
    public String getNom();

    /**
     * Simule la participation d'un participant à une epreuve
     * @return Le score obtenu par le participant lors de l'épreuve
     */
    public double participer(Epreuve epreuve);

    /**
     * Définit le nom du participant
     * @param nom Le nom à attribuer au participant
     */
    public void setNom(String nom);
}
