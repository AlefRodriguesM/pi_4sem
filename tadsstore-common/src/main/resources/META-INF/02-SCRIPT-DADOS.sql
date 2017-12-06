INSERT INTO TB_PRODUTO (DS_NOME, DS_DESCRICAORESUMIDA, DS_DESCRICAO, QT_ESTOQUE, VL_PRECO, DT_CADASTRO, DS_IMAGEM) VALUES (
'Placa de vídeo GTX 1080ti',
'Placa de Vídeo VGA NVIDIA EVGA GEFORCE GTX 1080 Ti 11GB FTW3',
'Características:
- Marca: EVGA
- Modelo: 11G-P4-6694-KR

Especificações:

Interface:
- PCI Express 3.0

Chipset:
- Fabricante: NVIDIA
- GPU: GeForce GTX 1080 Ti
- Clock principal: 1480 MHz
- Boost Clock: 1582 MHz
- CUDA: 3584

Memória:
- Clock eficaz: 11016 MHz
- Tamanho da memória: 11GB
- Interface de memória: 352-Bit
- Tipo de memória: GDDR5X

API 3D:
- DirectX 12
- OpenGL 4.5

Portas:
- 1 x HDMI 2.0
- 3 x DisplayPort 1.4
- 1 x Dual-Link DVI-D

Geral:
- Resolução Máxima: 7680 x 4320
- Monitores Suportados: 4 (máx)
- Suporte SLI: 2-Way SLI
- Realidade virtual
- Resfriador: Triple Fans
- Sistemas operacionais suportados: Windows 10 32/64-bit, Windows 8 32/64-bit, Windows 7 32/64-bit
- Requisitos de sistema: Fonte de alimentação de 600W ou superior
- Conector de força: Alimentação PCI-E de 8 pinos ou 6 + de 2 pinos disponíveis
- Dual-Link DVI suportado
- HDCP
- Comprimento máximo da GPU: 300 mm 
 
Conteúdo da embalagem:
- 01 Placa de Vídeo VGA NVIDIA EVGA
- 01 Drive
- 01 Guia do Usuário



Garantia
12 meses de garantia

Peso
1900 gramas (bruto com embalagem)',
0,
2199.90,
CURRENT_TIMESTAMP,
'https://images6.kabum.com.br/produtos/fotos/88076/88076_index_gg.jpg'
)

;

INSERT INTO TB_PRODUTO (DS_NOME, DS_DESCRICAORESUMIDA, DS_DESCRICAO, QT_ESTOQUE, VL_PRECO, DT_CADASTRO, DS_IMAGEM) VALUES (
'Intel Core i7-7700K',
'Processador Intel Core i7-7700K Kaby Lake 7a Geração, Cache 8MB 4.2GHz (4.5GHz Max Turbo)',
'Características:
- Marca: Intel
- Modelo: BX80677I77700K

Especificações:
- Kaby Lake 
- Core i7-7700K
- 7ª Geração
- Status: Roadmap
- Livre de Conflito
- Soquetes suportados: FCLGA1151

Performance:
- Cores: 4
- Tópicos: 8
- Frequência de Base: 4.20 GHz
- Frequência Turbo Máx.: 4,50 GHz
- Cache: 8MB
- Velocidade Bus: 100 MHz DMI
- TDP: 91W

Memória:
- Tamanho máximo de memória (depende do tipo de memória: 64GB
- Número máx. de canais de memória: 2

Gráficos:
- Processador Gráfico: Gráficos Intel® HD 630
- Frequência da base de Gráficos: 350,00 MHz
- Frequência Dinãmica máx. de gráficos: 1,15GHz
- Memória Máxima de Video gráfico: 64GB
- Suporta 4K:  a 60Hz
- Resolução Máxima (HDMI 1.4): 4096x2304 @ 24Hz
- Resolução máxima (DP): 4096x2304 @ 60Hz
- Resolução máx. (eDP) - Painel Integrado): 4096x2304 @ 60Hz
- Suporte para DirecX: 12
- Suporte OpenGL: 4.4
- Monitores compatíveis: 3

Opções de expansão:
- Ecalabilidade: 1S Somente
- Revisão PCI Express: 3,0
- Configurações PCI Express: Até 1x16, 2x8, 1x8 + 2x4
- Núm máx de PCI Express Lanes: 16

Tecnologias Avançadas:
- Intel® Virtualization Technology (VT-x) 
- Intel® Hyper-Threading Technology
- Tecnologia Turbo Boost: 2.0
- Extensões de conjunto de intruções: SSE4.1 / 4.2, AVX 2.0
- Proteção do SO

Conteúdo da embalagem:
- 01 Processador Intel Core i7-7700K Kaby Lake 7ª Geração



Garantia
12 meses de garantia

Peso
75 gramas (bruto com embalagem)',
0,
1574.00,
CURRENT_TIMESTAMP,
'https://images8.kabum.com.br/produtos/fotos/75738/75738_index_gg.jpg'
)

;

INSERT INTO TB_VENDA (FK_COMPRADOR, DT_VENDA, VL_PRODUTOS, VL_FRETE, VL_TOTAL, DS_ENDERECO, DS_NUMERO, DS_BAIRRO, DS_CIDADE, DS_CEP, DS_FORMAPAG, DS_TRANSPORTADORA, TG_STATUS, DT_ALTERACAO,NR_PARCELAS,NR_PRAZOINI,NR_PRAZOFIM,DS_UF,DS_COMPLEMENTO)
VALUES (1, CURRENT_TIMESTAMP, 2199.99, 20, 2229.99, 'PROF. CARLOS REIS', '39', 'PINHEIROS', 'SÃO PAULO', '05424020', 'BOLETO', 'RELAMPAGO', 1, NULL, 0, 1,5,'SP', '')

;

INSERT INTO TB_ITEMVENDA(FK_PRODUTO, FK_PEDIDO, QT_VENDA, VL_PREUNI, VL_TOTAL, DH_MOVIMENTO) VALUES (1, 100, 1, 2199.99, 2199.99, CURRENT_TIMESTAMP)

;

INSERT INTO TB_VENDA (FK_COMPRADOR, DT_VENDA, VL_PRODUTOS, VL_FRETE, VL_TOTAL, NR_PARCELAS, NR_PRAZOINI, NR_PRAZOFIM, DS_ENDERECO, DS_NUMERO, DS_BAIRRO, DS_COMPLEMENTO, DS_CIDADE, DS_UF, DS_CEP, DS_FORMAPAG, DS_TRANSPORTADORA, TG_STATUS, DT_ALTERACAO)
VALUES (1, CURRENT_TIMESTAMP, 1574.00, 20, 1594.00, 3, 1, 5, 'PROF. CARLOS REIS', '39', 'PINHEIROS', 'CASA 02', 'SÃO PAULO', 'SP', '05424020', 'BOLETO', 'RELAMPAGO', 1, NULL)

;

INSERT INTO TB_ITEMVENDA(FK_PRODUTO, FK_PEDIDO, QT_VENDA, VL_PREUNI, VL_TOTAL, DH_MOVIMENTO) VALUES (2, 1001, 1, 1574.00, 1574.00, CURRENT_TIMESTAMP)

;

INSERT INTO TB_CLIENTES (DS_NOME, DS_SOBRENOME, DS_EMAIL, DS_SENHA, DS_ENDERECO, DS_NUMERO, DS_BAIRRO, DS_COMPLEMENTO, DS_CIDADE, DS_UF, DS_CEP, DT_CADASTRO) VALUES
('Alef', 'Mendes', 'alefspam007@gmail.com', '7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', 'Av. Gonçalo de Paiva Gomes', '237', 'Jd. Primavera', 'Casa 02', 'São Paulo', 'SP', '04812-090', CURRENT_TIMESTAMP)

;