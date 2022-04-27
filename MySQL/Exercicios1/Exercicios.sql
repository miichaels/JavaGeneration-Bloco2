CREATE DATABASE db_rh;
USE db_rh;

CREATE TABLE tb_colaboradores( -- Criar a tabela e atributos

id BIGINT AUTO_INCREMENT,
PRIMARY KEY (id),
nome VARCHAR(255),
cargo VARCHAR(255),
salario FLOAT(9,2),
setor VARCHAR(255)

);

SELECT * FROM tb_colaboradores; -- ver a tabela 


INSERT INTO tb_colaboradores(nome, cargo,salario,setor) -- Selecionando a tabela para inserir valores
VALUES("Michael", "DEV jr", 5000.00, "Desenvolvedor"); /* Inserindo valores na tabela */

INSERT INTO tb_colaboradores(nome, cargo,salario,setor)
VALUES("Gustavo", "Dev jr", 5200.00, "Desenvolvedor");

INSERT INTO tb_colaboradores(nome, cargo,salario,setor)
VALUES("Douglas", "Gestão de riscos", 4000.00 , "Analise");

INSERT INTO tb_colaboradores(nome, cargo,salario,setor)
VALUES("Israel", "Produtor", 3300.00 , "Produção de conteudo");

INSERT INTO tb_colaboradores(nome, cargo,salario,setor)
VALUES("Maiar", "Estagiario ", 2000.00 , "Estagio em Dev");

SELECT * FROM tb_colaboradores WHERE salario < 2001;
SELECT * FROM tb_colaboradores WHERE salario > 2000;

UPDATE tb_colaboradores SET salario = 2500 where id = 5;

-- Ex 2
CREATE DATABASE db_ecommerce;
USE db_ecommerce;

CREATE TABLE tb_produtos(
id BIGINT AUTO_INCREMENT,
PRIMARY KEY(id),
nome VARCHAR(255),
valor FLOAT(5,2),
fornecedor VARCHAR(255),
codigo INT

);

ALTER TABLE tb_produtos MODIFY valor FLOAT(9,2);

SELECT * FROM tb_produtos;

INSERT INTO tb_produtos(nome,valor,fornecedor,codigo)
VALUES( "Jogo de video game " , 300.00 , "jpx", 555 ),
		("Hub Usb" , 400.00 , "TP-link" , 66),
        ("Ventilador " , 100.00 , "Multilaser" , 88),
        ("Adaptador usb" , 50.00, "X5" , 8989 ),
        ("Caixa de som" , 600.00 , "Logitech" , 5 ),
        ("Monitor Gamer" , 1500.00 , "Samsung" , 7 ),
        ("Notbook" , 5300.00 , "Lenovo " , 98),
        ("Fone Gamer" , 200.00 , "JBL" , 7878 );


SELECT * FROM tb_produtos WHERE valor > 500;
SELECT * FROM tb_produtos WHERE valor < 500;

UPDATE tb_produtos SET valor = 100.00 WHERE id = 4;

-- Ex 3 
CREATE DATABASE db_escola;
USE db_escola;

CREATE TABLE tb_estudantes(
cpf VARCHAR(255),
PRIMARY KEY (cpf),
nome VARCHAR(255),
idade INT,
turma INT,
nota FLOAT(2,1)

);

ALTER TABLE tb_estudantes MODIFY nota FLOAT(4,2); -- Alterar o tipo de dado 

SELECT * FROM tb_estudantes;

INSERT INTO tb_estudantes(cpf,nome,idade,turma,nota)
VALUES  ("7878778", "Michael", 24 , 50 , 10.0),
		("5656565", "Fernando", 30, 50 , 8.1),
		("2323232", "Maiar", 19, 49, 0.0),
		("4524646", "Douglas", 30, 49, 7.2),
		("3633214", "Israel", 26, 51, 8.5),
		("6564696", "Gustavo", 21, 51, 9.6),
		("7898654", "Camila", 19, 20, 7.3),
		("2012301", "Amanda", 25, 20, 9.8);



SELECT * FROM tb_estudantes WHERE nota > 7;
SELECT * FROM tb_estudantes WHERE nota < 7;

UPDATE tb_estudantes SET nota = 0.5 WHERE cpf = "2323232";