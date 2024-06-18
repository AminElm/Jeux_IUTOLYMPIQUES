DROP TABLE PARTICIPE_A;
DROP TABLE PARTICIPE_Eq;
DROP TABLE EPREUVE;
DROP TABLE SPORT;
DROP TABLE ATHLETE;
DROP TABLE EQUIPE;
DROP TABLE PAYS;


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
  nomEp varchar(30),
  PRIMARY KEY (idEp)
);

CREATE TABLE SPORT (
  idS int,
  nomS varchar(30),
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



create role administrateur , organisateur, visiteur;
grant all on BD.* to admin;
grant insert , update, delete, select on BD.base to organisateur;
grant select on BD.base to visiteur;

CREATE TABLE PERSONNE{
  idPers int,
  prenomA varchar(30),
  nomA varchar(30),
  mdp varchar(30),
  PRIMARY KEY (idpers)
}