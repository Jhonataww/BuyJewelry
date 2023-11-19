CREATE TABLE LOGIN(
                      ID int AUTO_INCREMENT,
                      EMAIL varchar(100) NOT NULL,
                      SENHA varchar(100) NOT NULL,
                      PRIMARY KEY (ID)
);
--
ID_USUARIO int not null,
FOREIGN KEY (ID_LOGIN) REFERENCES usuario(ID)
Select * from login

                  USE banco;



create database banco;

insert into login (id, email, senha) values (null, 'JHONATA@gmail.com', '123456');




-----------------------------------

use banco;

CREATE TABLE USUARIO(
                        ID int PRIMARY KEY AUTO_INCREMENT ,
                        CPF VARCHAR(100) NOT NULL,
                        IDADE int  NOT NULL,
                        CEP int  NOT NULL,
                        TELEFONE VARCHAR(100) NOT NULL,
                        ENDERECO varchar(100) NOT NULL,
                        NOME varchar(100) NOT NULL,
                        ID_LOGIN int not null,
                        ATIVO varchar (3),
                        FOREIGN KEY (ID_LOGIN) REFERENCES login(ID)
);

--------------------------------------

SELECT * FROM banco.usuario;

insert into banco.usuario (ID, CPF, IDADE, CEP, TELEFONE, ENDERECO, NOME, ID_LOGIN, ATIVO) values (null, '04143271281', 21, 850, '91987032092' , 'MINHARUA' , 'JHONATA', 1, NULL );

SELECT * FROM banco.usuario;
