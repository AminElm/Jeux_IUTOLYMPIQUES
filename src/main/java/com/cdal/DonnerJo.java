import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.smartcardio.ATR;

import main.java.com.cdal.Athlete;
import main.java.com.cdal.Epreuve;
import main.java.com.cdal.Pays;

import java.io.FileNotFoundException;



public class DonnerJo {
    private ArrayList<Athlete> athletes;
    private ArrayList<Sport> sport;
    private ArrayList<Epreuve> epreuves;
    private ArrayList<Pays> pays;



    public DonnerJo(File file)throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        sport.add(new VolleyBall());
        sport.add(new Escrime());
        sport.add(new Handball());
        sport.add(new Athletisme());
        sport.add(new Natation());
        if (scan.hasNext()){
            scan.nextLine();
        }
        this.athletes = new ArrayList<>();
        this.sport = new ArrayList<>();
        this.epreuves = new ArrayList<>();
        this.pays = new ArrayList<>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String [] l = line.split(",");

            
            Sport s;
            for (Sport sports : sport)
                {if (l[4]==sports.getNom()){
                    s = sports;}}
            
            Boolean pa = true;
            Pays p;
            for(Pays pay : pays){
                if(l[3] == pay.getNom()){
                pa = false;
                p = pay;}
            }
            if (pa){
                p = new Pays(l[3]);
                pays.add(p);
            }

            Boolean epr = true;
            Epreuve e;
            for(Epreuve epreuve : epreuves){
                if(l[5] == epreuve.getNom()){
                epr = false;
                e = epreuve;}
            }
            if (epr){
                e = new Epreuve(l[5],s);
                epreuves.add(e);
                ;
            }
            Athlete a = new Athlete(l[0], l[1], l[2],p,Integer.valueOf(l[7]), Integer.valueOf(l[9]), Integer.valueOf(l[8]));
            boolean at = true;
            for (Athlete ath : athletes){
                if (ath.equals(a)){
                    at = false;
                }
            }
            if (at){
                athletes.add(a);
            }
            e.ajouteParticipant(a);
            p.ajouterParticipant(a);
        }
    }
   
}
