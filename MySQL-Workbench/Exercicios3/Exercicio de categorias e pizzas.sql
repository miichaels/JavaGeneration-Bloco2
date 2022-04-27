create database db_pizzaria_legal;
use db_pizzaria_legal;

create table tb_categorias(
id bigint auto_increment,
primary key (id),
sabor varchar(255),
preco float(9,2),
tamanho varchar(255)

);

create table tb_pizzas (
id bigint auto_increment,
primary key(id),
doce varchar(255),
salgada varchar(255),
vegetariana varchar(255),
cebola_meia_a_meia varchar(255),
class_id bigint,
foreign key (class_id) references tb_categorias(id)
);


insert tb_categorias(sabor,preco, tamanho)
values("Portuguesa", 50.00, "media"),
("Frango com catupiry", 45.00, "grande"),
("Chocolate", 55.00, "grande"),
("Rucula", 40.00, "pequena");

-- doce, salgada, vegetariana, cebola_meia_a_meia , class_id
insert tb_pizzas (doce,class_id) 
values ("Sim",3);

insert tb_pizzas(salgada,class_id)
values ("Sim",2);

insert tb_pizzas(salgada,class_id)
values ("Sim", 1);

insert tb_pizzas(vegetariana,class_id)
values ("Sim",4);

insert tb_pizzas(cebola_meia_a_meia,class_id)
values ("Sim", 1);

insert tb_pizzas(cebola_meia_a_meia,class_id)
values ("Sim", 2);

insert tb_pizzas(doce,class_id)
values ("Sim",3);

insert tb_pizzas(salgada,class_id)
values ("Sim", 2);

-- Selecionamar toda a tabela categorias
select * from tb_categorias;

-- Selecionamar toda a tabela pizzas
select * from tb_pizzas;

-- Mostra os precos > 45 da tabela categorias
select * from tb_categorias where preco > 45.00;

-- Seleciona a tabela categorias onde o preco seja entre 50.00 e 100.00
select * from tb_categorias where preco between 50.00 and 100.00;

-- Buscar todos as pizzas que possuam a letra M no atributo sabor
select * from tb_categorias where sabor like '%M%';

-- Seleciona a tabela categorias e junta com a tabela pizzas, e une as duas com o mesmo id
select * from tb_categorias inner join tb_pizzas on tb_categorias.id = tb_pizzas.class_id; 

-- unir os dados da tabela tb_pizzas com os dados da tabela tb_categorias, e mostras apenas as pizzas que sao doce 
select * from tb_categorias inner join tb_pizzas on tb_categorias.id = tb_pizzas.class_id where doce = "sim";








