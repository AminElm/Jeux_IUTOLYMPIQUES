package main.java.com.cdal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.io.FileNotFoundException;
import java.sql.SQLException;



public class DonnerJo {
    private ArrayList<Athlete> athletes;
    private ArrayList<Sport> sport;
    private ArrayList<Epreuve> epreuves;
    private ArrayList<Pays> pays;
    private ArrayList<Equipe> equipes;



    public DonnerJo(File file)throws FileNotFoundException,SQLException, ClassNotFoundException{
        this.athletes = new ArrayList<>();
        this.sport = new ArrayList<>();
        this.epreuves = new ArrayList<>();
        this.pays = new ArrayList<>();
        this.equipes = new ArrayList<>();
        Scanner scan = new Scanner(file);
        sport.add(new VolleyBall());
        sport.add(new Escrime());
        sport.add(new Handball());
        sport.add(new Athletisme());
        sport.add(new Natation());
        if (scan.hasNext()){
            scan.nextLine();
        }

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String [] l = line.split(",");

            Boolean sp = true;
            Sport s = null;
            for (Sport sports : sport)
                {if (l[4].equals(sports.getNom())){
                    s = sports;
                    sp = false;}}
            if (sp) {
               s = new Sport(l[4], 0, 0, 0); 
            }
            
            Boolean pa = true;
            Pays p = null;
            for(Pays pay : pays){
                if(l[3].equals(pay.getNom())){
                pa = false;
                p = pay;}
            }
            if (pa){
                p = new Pays(l[3]);
                pays.add(p);
            }

            Boolean epr = true;
            Epreuve e = null;
            for(Epreuve epreuve : epreuves){
                if(l[5].equals(epreuve.getNom())){
                epr = false;
                e = epreuve;}
            }
            if (epr){
                e = new Epreuve(l[5],s,(l[6].equals("T")));
                epreuves.add(e);
            }



            Athlete a = new Athlete(l[0], l[1],l[2].charAt(0),p,Integer.valueOf(l[7]), Integer.valueOf(l[9]), Integer.valueOf(l[8]),(l[6].equals("T")),e);
            
            boolean at = true;
            for (Athlete ath : athletes){
                if (ath.equals(a)){
                    at = false;
                }
            }
            if (at){
                athletes.add(a);
            }
            


            p.ajouterParticipant(a);

            if (l[6].equals("T")){
                Equipe equip;
                boolean eq = true;
                for (Equipe equi : equipes){
                    if (equi.getNom().equals(l[5])&&equi.getPays().equals(p)){
                        equi.ajouteAthlete(a);
                        eq = false;
                        equip = equi;
                    }
                }
                if (eq){

                    equip = new Equipe(l[5],e, p);
                   equip.ajouteAthlete(a);
                    equipes.add(equip);
                    e.ajouteParticipant(equip);
                }
            }else{
                
                if (!e.getparticipants().contains(a)){
                e.ajouteParticipant(a);}}
        }


        
        Requete re = new Requete();


        

        for (Pays pa : pays){
            re.ajoutePays(pa);
        }
        for (Sport s : sport){
            re.ajouteSport(s);
        }
        for (Equipe eq : equipes){
            re.ajouteEquipe(eq);}


        for (Athlete a : athletes){
            if (a.getEnEquipe()){
                for (Equipe eq : equipes){
                    if (eq.getAthletes().contains(a)){
                      re.ajouteAthletAvecEquipe(a,eq);}}}
            else{
                re.ajouteAthletSansEquipe(a);
            }}
            for (Epreuve e : epreuves){
                re.ajouteEpreuve(e);
                if (e.isColectif()){
                    for (Participant eq : e.getparticipants()){
                        Equipe equi = (Equipe) eq;
                        re.ajouteParticipEq(e, equi);
                    }
                }
                else{
                    for (Participant a : e.getparticipants()){
                        Athlete ath = (Athlete) a;
                        
                        re.ajouteParticipA(e, ath);
                    }
                }
        
    
    }
}}