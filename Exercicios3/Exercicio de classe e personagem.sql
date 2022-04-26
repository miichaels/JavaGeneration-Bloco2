create database db_generation_game_online;
use db_generation_game_online;

create table tb_classes(
id bigint auto_increment,
primary key(id),
classe varchar(255),
incremento varchar(255)

);


create table tb_personagens(
id bigint auto_increment,
primary key(id),
nome varchar(255),
poder_ataque bigint,
poder_defesa bigint,
precisao int,
categoria_id bigint,
foreign key (categoria_id) references tb_classes (id)

);

insert tb_classes (classe,incremento) 
values ("Guerreiro","Anão"),
("Guerreiro","Anão"),
("Cavaleiro","Humano"),
("Cavaleiro","Elfo"),
("Barbaro","Aladin");

insert tb_personagens(nome,poder_ataque,poder_defesa,precisao,categoria_id)
values ("Personal66", 1500, 2000, 10, 3),
("Israel50", 2100, 1000, 5, 4),
("Brico", 2500, 1000, 6, 5),
("Maiar", 1700, 2500, 7, 3),
("Gustavo", 1500, 1800, 7, 2),
("Douglas", 300, 5000, 7, 1),
("Emko", 3000, 2500, 5, 1),
("Suflair", 1400, 3000, 8, 2);

-- Selecionamar toda a tabela classes 
select * from tb_classes;

-- Selecionamar toda a tabela personagens
select * from tb_personagens;

-- Seleciona o poder de ataque > 2000 da tabela personagens
select * from tb_personagens  where poder_ataque > 2000;

-- Seleciona a tabela personagens onde o poder de desefa seja entre 1000 e 2000
select * from tb_personagens where poder_defesa between 1000 and 2000;

-- Buscar todos os personagens que possuam a letra C no atributo nome
select * from tb_personagens where nome like '%c%';

-- Seleciona a tabela personagens e junta com a tabela classes, e une as duas com o mesmo id 
select * from tb_personagens inner join tb_classes ON tb_classes.id = tb_personagens.categoria_id;

-- Seleciona as tabelas e une as mesmas, imprimindo os personagens com a classe guerreiro
select * from tb_personagens inner join tb_classes ON tb_classes.id = tb_personagens.categoria_id where classe = "Guerreiro";

