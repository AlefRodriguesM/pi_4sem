INSERT INTO TB_CATEGORIA (DS_CATEGORIA) VALUES
('Memória RAM'),
('Processador'),
('Placa mãe'),
('Placa de vídeo'),
('Gabinete'),
('Jogos'),
('Fonte para Desktop'),
('Notebook'),
('Teclado'),
('Mouse');

INSERT INTO TB_PRODUTO (DS_PRODUTO, DS_DETALHES, DH_INCLUSAO, VL_PREUNI) VALUES
('Placa de vídeo GTX 1080ti', '', CURRENT_TIMESTAMP, 2199.90),
('Processador intel i7 7700k', '', CURRENT_TIMESTAMP, 1390.90);

INSERT INTO TB_IMAGENS (DS_NOME, DS_IMAGEM, ID_PRODUTO) VALUES 
('picture01.jpg', 'Imagem Placa de vídeo GTX 1080ti', 1),
('picture02.jpg', 'Processador intel i7 7700k', 2);

INSERT INTO TB_PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA) VALUES 
(1, 1),
(2, 2);

INSERT INTO TB_VENDA (FK_COMPRADOR, DT_VENDA, VL_PRODUTOS, VL_FRETE, VL_TOTAL, DS_ENDERECO, DS_NUMERO, DS_BAIRRO, DS_CIDADE, DS_CEP, DS_FORMAPAG) 
VALUES (1, CURRENT_TIMESTAMP, 200, 20, 220, 'PROF. CARLOS REIS', '39', 'PINHEIROS', 'SÃO PAULO', '05424020', 'BOLETO')