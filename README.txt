# CRUD PARA APRESENTAR A EMPRESA INDRA. #
# Desenvolvido por : Jonatan Simão
# Contato jonatanmarcel@gmail.com

# Tecnologias Utilizadas #
# CRUD criado na Linguagem Java
# JSP 
# MySQL
# Server TomCat

*/Script do Banco de Dados/*

create database dbcadastro;

use dbcadastro;

create table usuarios (
	id int primary key auto_increment,
    nome varchar(55) not null,
    email varchar(55) not null,
    fone varchar(15) not null
);
