
CREATE TABLE superficie (
                id_superficie INT IDENTITY NOT NULL,
                materiale VARCHAR(20) NOT NULL,
                CONSTRAINT superficie_pk PRIMARY KEY (id_superficie)
)

CREATE TABLE centro_sportivo (
                email VARCHAR(100) NOT NULL,
                nome_centro VARCHAR(100) NOT NULL,
                p_iva VARCHAR(20) NOT NULL,
                numero_telefono VARCHAR(20) NOT NULL,
                indirizzo VARCHAR(100) NOT NULL,
                citta VARCHAR(40) NOT NULL,
                soglia_coupon DECIMAL(8,2),
                CONSTRAINT centro_sportivo_pk PRIMARY KEY (email)
)

CREATE TABLE campo (
                id_campo INT IDENTITY NOT NULL,
                email VARCHAR(100) NOT NULL,
                id_superficie INT NOT NULL,
                coperto BIT NOT NULL,
                spogliatoi BIT NOT NULL,
                CONSTRAINT campo_pk PRIMARY KEY (id_campo)
)

CREATE TABLE sport (
                id_sport INT IDENTITY NOT NULL,
                nome_sport VARCHAR(30) NOT NULL,
                CONSTRAINT sport_pk PRIMARY KEY (id_sport)
)

CREATE TABLE sport_campo (
                id_sport INT NOT NULL,
                id_campo INT NOT NULL,
                CONSTRAINT sport_campo_pk PRIMARY KEY (id_sport, id_campo)
)

CREATE TABLE giocatore (
                email VARCHAR(100) NOT NULL,
                password VARCHAR(100) NOT NULL,
                nome VARCHAR(30) NOT NULL,
                cognome VARCHAR(30) NOT NULL,
                numero_telefono VARCHAR(20) NOT NULL,
                indirizzo VARCHAR(100),
                citta VARCHAR(40),
                CONSTRAINT giocatore_pk PRIMARY KEY (email)
)

CREATE TABLE gruppo (
                id_gruppo INT IDENTITY NOT NULL,
                nome_gruppo VARCHAR(50) NOT NULL,
                email_creatore VARCHAR(100) NOT NULL,
                CONSTRAINT gruppo_pk PRIMARY KEY (id_gruppo)
)

CREATE TABLE slot (
                id_slot INT IDENTITY NOT NULL,
                id_campo INT NOT NULL,
                email_referente VARCHAR(100),
                id_gruppo INT,
                data_ora_inizio DATETIME NOT NULL,
                data_ora_fine DATETIME NOT NULL,
                prezzo DECIMAL(8,2) NOT NULL,
                sconto_percent INT,
                sconto_riscattato BIT NOT NULL,
                CONSTRAINT slot_pk PRIMARY KEY (id_slot)
)

CREATE TABLE giocatore_gruppo (
                email VARCHAR(100) NOT NULL,
                id_gruppo INT NOT NULL,
                CONSTRAINT giocatore_gruppo_pk PRIMARY KEY (email, id_gruppo)
)

ALTER TABLE campo ADD CONSTRAINT superficie_campo_fk
FOREIGN KEY (id_superficie)
REFERENCES superficie (id_superficie)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE campo ADD CONSTRAINT centro_sportivo_campo_fk
FOREIGN KEY (email)
REFERENCES centro_sportivo (email)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE slot ADD CONSTRAINT campo_slot_fk
FOREIGN KEY (id_campo)
REFERENCES campo (id_campo)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE sport_campo ADD CONSTRAINT campo_sport_campo_fk
FOREIGN KEY (id_campo)
REFERENCES campo (id_campo)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE sport_campo ADD CONSTRAINT sport_sport_campo_fk
FOREIGN KEY (id_sport)
REFERENCES sport (id_sport)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE giocatore_gruppo ADD CONSTRAINT giocatore_giocatore_gruppo_fk
FOREIGN KEY (email)
REFERENCES giocatore (email)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE gruppo ADD CONSTRAINT giocatore_gruppo_fk
FOREIGN KEY (email_creatore)
REFERENCES giocatore (email)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE slot ADD CONSTRAINT giocatore_slot_fk
FOREIGN KEY (email_referente)
REFERENCES giocatore (email)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE giocatore_gruppo ADD CONSTRAINT gruppo_giocatore_gruppo_fk
FOREIGN KEY (id_gruppo)
REFERENCES gruppo (id_gruppo)
ON DELETE NO ACTION
ON UPDATE NO ACTION

ALTER TABLE slot ADD CONSTRAINT gruppo_slot_fk
FOREIGN KEY (id_gruppo)
REFERENCES gruppo (id_gruppo)
ON DELETE NO ACTION
ON UPDATE NO ACTION