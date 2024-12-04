CREATE TABLE PERSON
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    age INT,
    inserted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- if we include band id here then it means a musician belongs to only one band and that is not the case.
CREATE TABLE MUSICIAN
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    person_id BIGINT,
    insertion_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES PERSON (id)
);
CREATE TABLE BAND
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    band_name VARCHAR(255),
    formed_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- This is required to model many to many relationship between band and musician
CREATE TABLE BAND_MUSICIAN
(
    band_id BIGINT,
    musician_id BIGINT,
    join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (band_id, musician_id),
    FOREIGN KEY (band_id) REFERENCES BAND (id),
    FOREIGN KEY (musician_id) REFERENCES MUSICIAN (id)
);