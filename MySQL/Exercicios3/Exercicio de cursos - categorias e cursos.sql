create database db_curso_da_minha_vida;
use db_curso_da_minha_vida;

create table tb_categorias(
id bigint auto_increment,
primary key (id),
curso varchar(255),
ativo boolean

);

insert tb_categorias (curso, ativo)
values ("Tecnologia", true),
("Contabilidade", true),
("Adm", true),
("Financas", false),
("Direito", true);


create table tb_cursos(
id bigint auto_increment,
primary key (id),
nome varchar(255),
valor decimal(9,2),
tempo varchar(255),
nivel varchar(255),

class_id bigint,
foreign key (class_id) references tb_categorias(id)
);


insert tb_cursos (nome, valor, tempo, nivel, class_id)
values ("HTML", 50.00, "10hrs", "Intermediario" , 1),
("CSS", 40.00, "10hrs","Iniciante", 1),
("CPA10", 300.00, "50hrs","Iniciante", 4),
("CPA20", 600.00, "80hrs","Intermediario", 4),
("Introducao a ADM", 300.00, "30hrs","Intermediario", 3),
("Excel para Contabeis", 1000.00, "100hrs","Avancado", 2),
("Curso para OAB", 800.00, "80hrs","Avancado", 5),
("Java", 600.00, "70hrs","Avancado", 1);

-- Selecionamar toda a tabela categorias
select * from tb_categorias;

-- Selecionamar toda a tabela cursos
select * from tb_cursos;

-- Seleciona o curso com valor > 500.00 
select * from tb_cursos where valor > 500.00;

-- Seleciona da tabela cursos onde o valor seja entre 600.00 e 1000.00
select * from tb_cursos where valor between 600.00 and 1000.00;

-- Buscar todos os personagens que possuam a letra J no atributo nome
select * from tb_cursos where nome like '%j%';

-- Seleciona a tabela cursos e junta com a tabela categorias, e une as duas com o mesmo id
select * from tb_cursos inner join tb_categorias on tb_categorias.id = tb_cursos.class_id;

-- Seleciona as tabelas e une as mesmas, imprimindo o tipo curso - Tecnologia
select * from tb_cursos inner join tb_categorias on tb_categorias.id = tb_cursos.class_id where curso = "Tecnologia";
