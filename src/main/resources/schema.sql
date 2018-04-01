-- Table for Documents
CREATE TABLE IF NOT EXISTS doc_type (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    code CHAR(2) NOT NULL UNIQUE
);

-- Table for Countries
CREATE TABLE IF NOT EXISTS country (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL UNIQUE,
    code CHAR(3) NOT NULL UNIQUE
);

-- Table for Organizations
CREATE TABLE IF NOT EXISTS organization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    name VARCHAR(50) NOT NULL,
    full_name VARCHAR(255) NOT NULL UNIQUE,
    inn CHAR(10) NOT NULL,
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
    middle_name VARCHAR(20) NOT NULL,
    position VARCHAR(255) NOT NULL,
    phone CHAR(12) NOT NULL,
    doc_type_id INTEGER,
    document_number VARCHAR(20) NOT NULL,
    document_date DATE NOT NULL,
    country_id INTEGER,
    is_identified BIT DEFAULT FALSE,
    office_id INTEGER
);

-- Table for Account
CREATE TABLE IF NOT EXISTS account (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL,
    login VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(20) NOT NULL,
    code VARCHAR(255)
);

CREATE INDEX IX_Office_Organization_Id ON office (organization_id);
ALTER TABLE office ADD FOREIGN KEY (organization_id) REFERENCES organization(id);

CREATE INDEX IX_User_Office_Id ON user (office_id);
ALTER TABLE user ADD FOREIGN KEY (office_id) REFERENCES office(id);

CREATE INDEX IX_User_DocType_Id ON user (doc_type_id);
ALTER TABLE user ADD FOREIGN KEY (doc_type_id) REFERENCES doc_type(id);

CREATE INDEX IX_User_Country_Id ON user (country_id);
ALTER TABLE user ADD FOREIGN KEY (country_id) REFERENCES country(id);