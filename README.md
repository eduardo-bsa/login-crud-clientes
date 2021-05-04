# Pós graduação em Engenharia de software
## Disciplina de Projeto e Implementação OO
> Aluno
Eduardo Bastos de Sá

> Objetivos
O aluno deverá ser capaz de desenvolver um sistema que realize as operações CRUD e controle sessão de usuário para Web seguindo os padrões MVC II, Front Controller e Command.
 
 ### Aplicativo desenvolvido
Após feito o login, o usuário consegue visualizar, inserir, alterar e excluir clientes.

### Scripts SQL
Rode os scripts abaixo, para que o aplicativo funcione corretamente

CREATE DATABASE mysql_database;

CREATE TABLE client (
    id INT(3) NOT NULL,
    first_name VARCHAR(20) DEFAULT NULL,
    last_name VARCHAR(20) DEFAULT NULL,
    address VARCHAR(45) DEFAULT NULL,
    contact VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE login (
    username VARCHAR(45),
    password VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (username)
);

INSERT INTO login VALUES ('test', 'test');

 ### Técnologias Usadas
  - Java
  - Servlet
  - jsp
  - MySql
 
 ### Padrões usados
 - MVC
 -  Front Controller
 -  Command
