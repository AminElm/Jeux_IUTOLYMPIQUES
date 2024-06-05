import java.util.ArrayList;
import java.util.List;

public class Sport{
    protected List<Epreuve> epreuves;
    protected String nom;
    
    public Sport(String nom){
        this.nom = nom;
        this.epreuves = new ArrayList<>();
    }

    public void ajouteEpreuve(Epreuve e){
        this.epreuves.add(e);
    }

    public int nbDEpreuves(){
        return epreuves.size();
    } 
    @Override
    public String toString(){
        String res = ""
        for (Epreuve i : this.epreuves){
            res += i.toString();
        }

        return "Les épreuve de" + nom + "sont :" + res;
    }
    
}