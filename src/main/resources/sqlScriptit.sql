DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS application_user;

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    publication_year INT,
    isbn VARCHAR(50) NOT NULL,
    price INT,
	categoryid BIGINT REFERENCES category(id)
);

INSERT INTO book (title, author, publication_year, isbn, price) 
VALUES 
('Aku Ankka', 'Kirjoittaja Kirjoittajainen', 1990, 'FSFR-324-FDGSH', 30),
('Roope Setä', 'Minison Manison', 1994, 'KLJFDS-34324-FDADA', 20);



CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
	role VARCHAR(20) NOT NULL
);


INSERT INTO application_user (username, password, role) 
VALUES 
('user', '$2a$10$.MgqhhqDMvsKPHJK9OwO7OvFv5rFwlWbr/loZKxUCUTJlZSz2oTCC', 'USER'),
('admin', '$2a$10$GMVXbP30ODjSw5ENAwRXQ.FmjZdmJEqn20/o62OC1jk2Rt3wEoJxC', 'ADMIN');

CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL
    
);

INSERT INTO category (name)
VALUES
('Drama'),
('Scifi'),
('Fantasy');



