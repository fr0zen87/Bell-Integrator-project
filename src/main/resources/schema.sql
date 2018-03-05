-- Table for Documents
CREATE TABLE IF NOT EXISTS doc_type (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    code CHAR(2) NOT NULL
);

-- Table for Countries
CREATE TABLE IF NOT EXISTS country (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    code CHAR(3) NOT NULL
);

-- Table for Organizations
CREATE TABLE IF NOT EXISTS organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    inn CHAR(12) NOT NULL,
    kpp CHAR(9) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone CHAR(12),
    is_active BIT DEFAULT FALSE
);

-- Table for Offices
CREATE TABLE IF NOT EXISTS office (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone CHAR(12),
    is_active BIT DEFAULT FALSE,
    organization_id INTEGER
);

-- Table for Users
CREATE TABLE IF NOT EXISTS user (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    second_name VARCHAR(20) NOT NULL,
    middle_name VARCHAR(20),
    position VARCHAR(255) NOT NULL,
    phone CHAR(12),
    document_code CHAR(2) NOT NULL,
    document_name VARCHAR(255) NOT NULL,
    document_number INTEGER NOT NULL,
    document_date DATE NOT NULL,
    citizenship_name VARCHAR(255) NOT NULL,
    citizenship_code CHAR(3) NOT NULL,
    is_identified BIT DEFAULT FALSE,
    office_id INTEGER,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255) NOT NULL
);

CREATE INDEX IX_Office_Organization_Id ON Office (organization_id);
ALTER TABLE Office ADD FOREIGN KEY (organization_id) REFERENCES Organization(id);

CREATE INDEX IX_User_Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);