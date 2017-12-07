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
    DS_IMAGEM VARCHAR(1000),
    DT_VALIDADEDESC TIMESTAMP,
    VL_PORDESC DECIMAL(4,2)
);

/**********************/
/*
    VENDA
    ESTOQUE
*/

CREATE TABLE TB_VENDA(
    PK_ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) CONSTRAINT PK_PRODUTO_CATEGORIA PRIMARY KEY,
    FK_COMPRADOR BIGINT, /* CÓDIGO DO USUÁRIO */
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
    DS_COMPLEMENTO VARCHAR(100),
    DS_CIDADE VARCHAR(50),
    DS_UF CHAR(2),
    DS_CEP VARCHAR(10),
    DS_FORMAPAG VARCHAR(30),
    DS_TRANSPORTADORA VARCHAR(60),
    DT_ALTERACAO TIMESTAMP,
    TG_STATUS INT
);

CREATE TABLE ES_MOVIMENTOS(
    PK_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_ES_MOVIMENTOS PRIMARY KEY,
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
ALTER TABLE TB_ITEMVENDA ADD CONSTRAINT FK_PRODUTO_ITEMPROD FOREIGN KEY (FK_PRODUTO) REFERENCES TB_PRODUTO(ID_PRODUTO);

ALTER TABLE ES_MOVIMENTOS ADD CONSTRAINT FK_PRODUTO_MOVPROD FOREIGN KEY (FK_PRODUTO) REFERENCES TB_PRODUTO(ID_PRODUTO);

CREATE TRIGGER "TR_ATUALIZASALDO"
AFTER INSERT ON "ES_MOVIMENTOS" 
REFERENCING NEW AS NOVO -- 'NEW' SIMBOLIZA UMA TABELA DO REGISTRO QUE ACABOU DE SER INSERIDO, ESTOU DANDO O ALIAS NOVO A ELA
FOR EACH ROW MODE DB2SQL -- PARA CADA LINHA AFETADA (NÃO SEI O QUE SIGNIFICA MODE, PROVAVELMENTE O TIPO DE ALGORITIMO QUE ELE UTILIZA)
    UPDATE TB_PRODUTO 
    SET
        QT_ESTOQUE = (  SELECT 
                            SUM(CASE
                                    WHEN MOV.TG_MOVIMENTO = 'E'
                                    THEN MOV.QT_MOVIMENTO
                                    ELSE MOV.QT_MOVIMENTO * -1
                                END) AS QT_MOVIMENTO
                        FROM ES_MOVIMENTOS MOV 
                        WHERE 
                            MOV.FK_PRODUTO = NOVO.FK_PRODUTO)
    WHERE
        ID_PRODUTO = NOVO.FK_PRODUTO
;

CREATE TRIGGER "TR_REALIZARMOVIMENTACAO"
AFTER INSERT ON "TB_ITEMVENDA" 
REFERENCING NEW AS NOVO -- 'NEW' SIMBOLIZA UMA TABELA DO REGISTRO QUE ACABOU DE SER INSERIDO, ESTOU DANDO O ALIAS NOVO A ELA
FOR EACH ROW MODE DB2SQL -- PARA CADA LINHA AFETADA (NÃO SEI O QUE SIGNIFICA MODE, PROVAVELMENTE O TIPO DE ALGORITIMO QUE ELE UTILIZA)
    INSERT INTO ES_MOVIMENTOS
        (FK_PRODUTO, FK_PEDIDO, TG_MOVIMENTO, QT_MOVIMENTO, DH_MOVIMENTO)
    VALUES
        (NOVO.FK_PRODUTO, NOVO.FK_PEDIDO, 'E', NOVO.QT_VENDA, NOVO.DH_MOVIMENTO)
;

CREATE TABLE TB_CLIENTES (
    ID_CLIENTE BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) CONSTRAINT PK_CLIENTE PRIMARY KEY, 
    DS_NOME VARCHAR(50),
    DS_SOBRENOME VARCHAR(100),
    DS_EMAIL VARCHAR(80),
    DS_SENHA VARCHAR(80),
    DS_ENDERECO VARCHAR(60),
    DS_NUMERO VARCHAR(8),
    DS_BAIRRO VARCHAR(60),
    DS_COMPLEMENTO VARCHAR(100),
    DS_CIDADE VARCHAR(50),
    DS_UF CHAR(2),
    DS_CEP VARCHAR(10),
    DT_CADASTRO TIMESTAMP NOT NULL,
    DS_PAPEL CHAR(15)
)

;