CREATE DATABASE db_quitanda;

USE db_quitanda;

CREATE TABLE tb_categorias(

id BIGINT AUTO_INCREMENT,
PRIMARY KEY(id),
descricao VARCHAR(255),
ativo BOOLEAN NOT NULL

);

SELECT * FROM tb_categorias;

INSERT tb_categorias (descricao, ativo)
VALUES ("Legumes", true),
("Frutas", true),
("Hortalicias", true),
("Outros", true);



CREATE TABLE tb_produtos(
id BIGINT AUTO_INCREMENT,
PRIMARY KEY (id),
nome VARCHAR(255) NOT NULL,
preco DECIMAL NOT NULL,
qt_produto INT NOT NULL,
categoria_id BIGINT,
FOREIGN KEY (categoria_id) REFERENCES tb_categorias (id)

);

SELECT * FROM tb_produtos;

INSERT tb_produtos (nome , preco, qt_produto, categoria_id)
VALUES ("Banana",8.00 , 1, 2),
("Cebolinha", 8.00, 2, 3),
("Cenoura", 3.99, 1, 1),
("Abacaxi", 12.00, 1, 2),
("maca", 10.00, 2, 2),
("Ovos", 60.00, 4, 4),
("Kit de Temperos", 100.00, 1, 4);

-- Seleciona toda a tabela tb_produtos
SELECT * FROM tb_produtos;

-- Seleciona a tabela produtos e imprime a coluna nome
SELECT nome FROM tb_produtos;

-- Seleciona a tabela produtos e junta com a tabela categorias sendo que a tabela categorias e une com a tabela produtos com os mesmos id
SELECT * FROM tb_produtos inner join tb_categorias ON tb_categorias.id = tb_produtos.categoria_id;

-- Seleciona toda a tabela produtos que tenha o preco maior que 50
SELECT * FROM tb_produtos WHERE preco > 50;

-- Seleciona toda a tabela produtos na coluna nome que tenha a letra 'a'
SELECT * FROM tb_produtos WHERE nome LIKE '%a%';

-- Atualiza um dado na tabela produtos para preco = 20.00 no local de if 4
UPDATE tb_produtos SET preco = 20.00 WHERE id = 4;





