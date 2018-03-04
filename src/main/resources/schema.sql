CREATE TABLE IF NOT EXISTS Person (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    house_id   INTEGER,
    age        INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS House (
    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    address    VARCHAR(50) NOT NULL
);

CREATE INDEX IX_Person_House_Id ON Person (house_id);
ALTER TABLE Person ADD FOREIGN KEY (house_id) REFERENCES House(id);

-- Table for Documents
CREATE TABLE IF NOT EXISTS Docs (
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    code CHAR(2) NOT NULL
);

-- Table for Countries
CREATE TABLE IF NOT EXISTS Countries (
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    code CHAR(3) NOT NULL
);

-- Table for Organizations
CREATE TABLE IF NOT EXISTS Organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    inn CHAR(12) NOT NULL,
    kpp CHAR(9) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone CHAR(12),
    is_active BIT
);

-- Table for Offices
CREATE TABLE IF NOT EXISTS Office (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone CHAR(12),
    is_active BIT,
    org_id INTEGER
);

-- Table for Users
CREATE TABLE IF NOT EXISTS User (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    secondName VARCHAR(20) NOT NULL,
    middleName VARCHAR(20),
    position VARCHAR(255) NOT NULL,
    phone CHAR(12),
    docCode CHAR(2) NOT NULL,
    docName VARCHAR(255) NOT NULL,
    docNumber INTEGER NOT NULL,
    docDate DATE NOT NULL,
    citizenshipName VARCHAR(255) NOT NULL,
    citizenshipCode CHAR(3) NOT NULL,
    isIdentified BIT,
    office_id INTEGER,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL
);

CREATE INDEX IX_Office_Organization_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX IX_User_Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);