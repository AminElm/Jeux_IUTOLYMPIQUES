package main.java.com.cdal;

public class ControleurFenetreOrga{

    private FenetreOrganisateur view;

    public ControleurFenetreOrga(FenetreOrganisateur view){
        this.view = view;
        initController();
    }

    private void initController(){
        view.getLancerEp().setOnAction(e -> lancerEpreuve());
        view.getBtnEnregistrer().setOnAction(e -> enregistrerEpreuve());
    }

    private void lancerEpreuve(){
        String nomEpreuve = view.getTfEpreuve().getText();
        String sport = view.getChoixSport().getValue();
        if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
            Sport sportEpreuve = getNomSport(sport);
            Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
            // lancement d'epreuve à ajouter
            System.out.println("L'épreuve " + nomEpreuve + " a été lancée.");
        }
    }

    private void enregistrerEpreuve(){
        String nomEpreuve = view.getTfEpreuve().getText();
        String sport = view.getChoixSport().getValue();
        if (nomEpreuve != null && !nomEpreuve.isEmpty() && sport != null){
            Sport sportEpreuve = getNomSport(sport);
            Epreuve epreuve = new Epreuve(nomEpreuve, sportEpreuve);
            view.getEpreuves().add(epreuve);
            System.out.println("L'épreuve " + nomEpreuve + " a été enregistrée.");
            view.getTfEpreuve().clear();
            view.getChoixSport().setValue(null);
        }
    }

    private Sport getNomSport(String sportName){
        switch (sportName){
            case "Athlétisme":
                return new Athletisme();
            case "Escrime":
                return new Escrime();
            case "VolleyBall":
                return new VolleyBall();
            case "Natation":
                return new Natation();
            case "Handball":
                return new Handball();
            default:
                return null;
        }
    }
}
