DROP TABLE IF EXISTS PARTICIPE_A;
DROP TABLE IF EXISTS PARTICIPE_Eq;
DROP TABLE IF EXISTS EPREUVE;
DROP TABLE IF EXISTS SPORT;
DROP TABLE IF EXISTS ATHLETE;
DROP TABLE IF EXISTS EQUIPE;
DROP TABLE IF EXISTS PAYS;
DROP TABLE IF EXISTS PERSONNE;


CREATE TABLE PAYS (
  idP int,
  nomP varchar(30),
  PRIMARY KEY (idP)
);

CREATE TABLE EQUIPE (
  idEq int,
  idP int,
  nomEq varchar(30),
  PRIMARY KEY (idEq)
);

CREATE TABLE ATHLETE (
  idA int,
  idP int,
  idEq int,
  idEp int,
  prenomA varchar(30),
  nomA varchar(30),
  sexe char,
  endurence int,
  forces int,
  agilite int,
  PRIMARY KEY (idA)
);

CREATE TABLE EPREUVE (
  idEp int,
  idS int,
  nomEp varchar(50),
  PRIMARY KEY (idEp)
);

CREATE TABLE SPORT (
  idS int,
  nomS varchar(30),
  coeffForce float,
  coeffAgilite float,
  coeffEndurance float,
  PRIMARY KEY (idS)
);

CREATE TABLE PARTICIPE_A (
  idA int,
  idEp int,
  score int,
  PRIMARY KEY (idA,idEp)
);

CREATE TABLE PARTICIPE_Eq (
  idEq int,
  idEp int,
  score int,
  PRIMARY KEY (idEq,idEp)
);


ALTER TABLE ATHLETE ADD FOREIGN KEY (idP) REFERENCES PAYS (idP);
ALTER TABLE EQUIPE ADD FOREIGN KEY (idP) REFERENCES PAYS (idP);
ALTER TABLE ATHLETE ADD FOREIGN KEY (idEp) REFERENCES EQUIPE (idEq);
ALTER TABLE EPREUVE ADD FOREIGN KEY (idS) REFERENCES SPORT (idS);

ALTER TABLE PARTICIPE_A ADD FOREIGN KEY (idA) REFERENCES ATHLETE (idA);
ALTER TABLE PARTICIPE_A ADD FOREIGN KEY (idEp) REFERENCES EPREUVE (idEp);
ALTER TABLE PARTICIPE_Eq ADD FOREIGN KEY (idEq) REFERENCES EQUIPE (idEq);
ALTER TABLE PARTICIPE_Eq ADD FOREIGN KEY (idEp) REFERENCES EPREUVE (idEp);

CREATE TABLE PERSONNE(
  pseudos varchar(30),
  mdp varchar(30),
  roles varchar(30),
  PRIMARY KEY (pseudos)
);

INSERT INTO SPORT (idS, nomS) VALUES (1, 'Athlétisme'), (2, 'Escrime'), (3, 'VolleyBall'), (4, 'Natation'), (5, 'Handball');
INSERT INTO EPREUVE (idEp, idS, nomEp) VALUES (1, 1, '100m Sprint'), (2, 1, 'Long Jump'), (3, 1, 'Shot Put'), (4, 1, 'High Jump'), (5, 1, '400m Sprint');
INSERT INTO PERSONNE (pseudos, mdp,roles) values ('testadm','96426','admin'),('testorga','3419645','orga'),('testvisit','112217419','visit');
INSERT INTO PAYS (idP, nomP) values (1, 'France'), (2, 'Espagne'), (3, 'Italie');
