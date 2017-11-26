/***
    PARA CRIAR BANCO
    bd: automata4b
    us: app
    pw: app

    essas informações ficam configuradas em: tadsstore-spring\src\main\resources\application.properties
    não esquecer de selecionar o glassfish nas propriedades do banco Java DB: \Program Files\glassfish-4.1.1\javadb
***/
/*
    PRODUTO
*/
CREATE TABLE TB_PRODUTO (
    ID_PRODUTO BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_PRODUTO PRIMARY KEY, 
    DS_NOME VARCHAR(50),
    DS_DESCRICAORESUMIDA VARCHAR(100),
    DS_DESCRICAO VARCHAR(2000),
    QT_ESTOQUE INTEGER,
    VL_PRECO DECIMAL(11,2),
    DT_CADASTRO TIMESTAMP NOT NULL,
    DS_IMAGEM VARCHAR(1000)
);

/**********************/
/*
    VENDA
    ESTOQUE
*/
CREATE TABLE TB_VENDA(
    PK_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) CONSTRAINT PK_PRODUTO_CATEGORIA PRIMARY KEY,
    FK_COMPRADOR INT, /* CÓDIGO DO USUÁRIO */
    DT_VENDA TIMESTAMP,
    VL_PRODUTOS DECIMAL(18,2),
    VL_FRETE DECIMAL(18,2),
    VL_TOTAL DECIMAL(18,2),
    NR_PARCELAS INT,
    NR_PRAZOINI INT, /* DE ENTRAGA */
    NR_PRAZOFIM INT,
    DS_ENDERECO VARCHAR(60),
    DS_NUMERO VARCHAR(8),
    DS_BAIRRO VARCHAR(60),
    DS_COMPLEMETO VARCHAR(100),
    DS_CIDADE VARCHAR(50),
    DS_UF CHAR(2),
    DS_CEP VARCHAR(10),
    DS_FORMAPAG VARCHAR(30),
    DS_TRANSPORTADORA VARCHAR(60),
    DT_ALTERACAO TIMESTAMP,
    TG_STATUS INT
);

CREATE TABLE ES_MOVIMENTOS(
    PK_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) CONSTRAINT PK_ES_MOVIMENTOS PRIMARY KEY,
    FK_PRODUTO BIGINT NOT NULL,
    FK_PEDIDO BIGINT,
    TG_MOVIMENTO CHAR(1),
    QT_MOVIMENTO INT,
    DH_MOVIMENTO TIMESTAMP
);

CREATE TABLE TB_ITEMVENDA(
    PK_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_TB_ITEMVENDA PRIMARY KEY,
    FK_PRODUTO BIGINT NOT NULL,
    FK_PEDIDO BIGINT,
    QT_VENDA INT,
    VL_PREUNI DECIMAL(18,2),
    VL_TOTAL DECIMAL(18,2),
    DH_MOVIMENTO TIMESTAMP
);
ALTER TABLE TB_ITEMVENDA ADD CONSTRAINT FK_PRODUTO FOREIGN KEY (FK_PRODUTO) REFERENCES TB_PRODUTO(ID_PRODUTO);

ALTER TABLE ES_MOVIMENTOS ADD CONSTRAINT FK_PRODUTO FOREIGN KEY (FK_PRODUTO) REFERENCES TB_PRODUTO(ID_PRODUTO);

CREATE TRIGGER TR_ATUALIZASALDO AFTER INSERT, DELETE, UPDATE ON ES_MOVIMENTOS referencing new as insertedrow