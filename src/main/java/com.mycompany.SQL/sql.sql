CREATE DATABASE SYNAPSE;
USE SYNAPSE;

CREATE TABLE User 
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    dataNasc VARCHAR(11) NOT NULL,
    usuario VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    senha VARCHAR(45) NOT NULL,
    is_admin boolean default false not null
);

SELECT * FROM user;

CREATE TABLE Curso 
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    autor_id INT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES User(id) ON DELETE CASCADE,
    tempo VARCHAR(6) NOT NULL,
    nivel VARCHAR(30) NOT NULL,
    preco VARCHAR(10) NOT NULL,
    categoria VARCHAR(45) NOT NULL,
    descricao VARCHAR(500)
);

SELECT * FROM curso;

CREATE TABLE imagens 
(
    curso_id INT PRIMARY KEY NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE,
    imagem LONGBLOB NOT NULL
);
    
SELECT * FROM imagens;

CREATE TABLE acesso 
(
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES user(id) ON DELETE CASCADE,
    curso_id INT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE
);

SELECT * FROM acesso;

CREATE TABLE conteudo
(
    id INT  AUTO_INCREMENT PRIMARY KEY NOT NULL,
    imagem LONGBLOB NOT NULL,
    curso_id INT NOT NULL,
    FOREIGN KEY (curso_id) REFERENCES curso(id) ON DELETE CASCADE
);

SELECT * FROM conteudo;