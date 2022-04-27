create database db_construindo_vidas;
use db_construindo_vidas;

create table tb_categorias (
id bigint auto_increment,
primary key (id),
item varchar(255),
ativo boolean
);

insert tb_categorias (item, ativo)
values ("Elétrica",true),
("Alvenaria",true),
("Pintura",true),
("Equipamentos",true),
("Segurança",true);

create table tb_produtos(
id bigint auto_increment,
primary key (id),
nome varchar (255) not null,
preco decimal(9,2) not null,
qt_produto int not null,
desconto boolean not null,

class_id bigint,
foreign key (class_id) references tb_categorias(id)
);


insert tb_produtos(nome, preco, qt_produto, desconto,class_id)
values ("Fio 2,5mm",10.99,500,false,1) ,
("Tinta Branca 20L",65.99,100,false,3),
("Furadeira",159.99,40,false,4),
("Piso laminado",82.99,1100,true,2),
("Rolo p/ pintura",19.30,50,false,3),
("Saco cimento 50kg",32.99,200,false,2),
("Conjunto tomada 20A",17.99,28,false,1),
("Parafusadeira",299.90,50,true,4),
("Cinta com talabarte",202.00,20,false,5),
("Bota de segurança",80.00,30,false,5);

-- Selecionamar toda a tabela produtos
select * from tb_produtos;

-- Selecionamar toda a tabela categorias
select * from tb_categorias;

-- Seleciona o curso com valor > 100.00 
select * from tb_produtos where preco > 100.00;

-- Seleciona da tabela cursos onde o valor seja entre 70.00 e 150.00
select * from tb_produtos where preco between 70.00 and 150.00;

-- Buscar todos os personagens que possuam a letra C no atributo nome
select * from tb_produtos where nome like '%C%';

-- Seleciona a tabela produtos e junta com a tabela categorias, e une as duas com o mesmo id
select * from tb_produtos inner join tb_categorias on tb_produtos.class_id = tb_categorias.id;

-- Seleciona as tabelas e une as mesmas, imprimindo o item - pintura
select * from tb_produtos inner join tb_categorias on tb_produtos.class_id = tb_categorias.id where item = "pintura";



