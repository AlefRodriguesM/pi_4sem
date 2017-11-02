/*
 * The MIT License
 *
 * Copyright 2016 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads4.dsw.tadsstore.common.service.fakeimpl;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.ImagemProduto;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class ProdutoServiceFakeImpl implements ProdutoService {

    private static final Map<Long, Produto> MAPA_PRODUTOS = new LinkedHashMap<Long, Produto>();

    private static final String DESCRICAO_PADRAO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
            + "Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. "
            + "Suspendisse commodo cursus turpis. Etiam ac enim egestas, sollicitudin libero ac, eleifend risus. "
            + "Phasellus nec posuere magna, in vehicula elit. "
            + "Etiam rhoncus, ipsum eget dapibus vulputate, massa nisi feugiat odio, a consectetur urna diam id risus. "
            + "Morbi sed pharetra nisl, nec aliquam ex. Morbi congue urna ut semper aliquam. "
            + "Sed aliquet turpis ac sem egestas dignissim. Praesent interdum dapibus cursus. "
            + "Cras posuere tempor lectus, ac porttitor tellus maximus vel.";

    private static final String DESCRICAORESUMIDA_PADRAO = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
            + "Aenean vel ipsum vehicula, venenatis leo nec, ornare felis. Ut consectetur est vel pulvinar tempus. ";

    static {
        CategoriaService categorias = new CategoriaServiceFakeImpl();
        Produto produto = new Produto(1L, "Processador Intel Core i3-7350k",
                "Características:\n"
                + "- Marca: Intel\n"
                + "- Modelo: BX80677I37350K \n"
                + "\n"
                + "Especificações:\n"
                + "- Processador i3-7350K\n"
                + "- Kaby Lake\n"
                + "- Litografia: 14nm\n"
                + "\n"
                + "Atuação:\n"
                + "- Número de núcleos: 2\n"
                + "- Cache: 4MB SmartCache\n"
                + "- TDP: 60W\n"
                + "- Tópicos: 4\n"
                + "- Velocidade do Bus : 8 GT/s DMI3\n"
                + "- Frequência do Processador: 4.20 GHz \n"
                + "\n"
                + "Memória:\n"
                + "- Tamanho máx. da Memória (depende do tipo de memória): 64GB\n"
                + "- Não suporta memória ECC\n"
                + "- Número máximo de de canais de memória: 2",
                "Processador Intel Core i3-7350k Kaby Lake 7a Geração, Cache 4MB, 4.2GHz LGA 1151",
                new BigDecimal(823.41), new Date(), "https://images6.kabum.com.br/produtos/fotos/88076/88076_index_gg.jpg",
                Arrays.asList(new ImagemProduto(1L, "Bla bla bla", "https://images6.kabum.com.br/produtos/fotos/88076/88076_index_gg.jpg"), new ImagemProduto(2L, "Xpto Xpto", "https://images6.kabum.com.br/produtos/fotos/88076/88076_index_gg.jpg"), new ImagemProduto(3L, "Chola mais", "https://images6.kabum.com.br/produtos/fotos/88076/88076_index_gg.jpg")),
                Arrays.asList(categorias.obter(1), categorias.obter(3)));
        MAPA_PRODUTOS.put(produto.getId(), produto);

        produto = new Produto(2L, "Nobreak SMS 2200va mono 220v",
                "Características:\n"
                + "- Marca: SMS\n"
                + "- Modelo: 27746\n"
                + " \n"
                + "Especificações: \n"
                + "- Microprocessador: RISC/FLASH de alta velocidade \n"
                + "- Comunicação Inteligente: padrões RS-232 e USB (acompanha cabo USB tipo A-B)\n"
                + "- Tensão: Monovolt 220V \n"
                + "- Tomadas: 10 tomadas 10A\n"
                + "- Autoteste: Ao ser ligado, realiza teste dos circuitos internos e baterias\n"
                + "- Leds: indicam o modo de operação e nível de carga das baterias (modo bateria) ou o nível de potência de saída (modo rede).\n"
                + "- Conector: Tipo engate rápido para expansão de autonomia \n"
                + "- Fusível: Rearmável\n"
                + "- 2200VA\n"
                + "- Entrada: 220VAC\n"
                + "- Saída: 220VAC",
                "Nobreak SMS 2200va mono 220v Power Vision - 27746 preto compacto",
                new BigDecimal(589.90), new Date(), "https://images8.kabum.com.br/produtos/fotos/75738/75738_index_gg.jpg",
                Arrays.asList(new ImagemProduto(4L, "Bla bla bla", "https://images8.kabum.com.br/produtos/fotos/75738/75738_index_gg.jpg"), new ImagemProduto(5L, "Xpto Xpto", "https://images8.kabum.com.br/produtos/fotos/75738/75738_index_gg.jpg")),
                Arrays.asList(categorias.obter(1), categorias.obter(3)));
        MAPA_PRODUTOS.put(produto.getId(), produto);
        
        
        produto = new Produto(3L, "Monitor LG 23.6´ LED Full HD D-Sub",
                "Características:\n"
                + "- Marca: LG\n"
                + "- Modelo: 24M38H-B.AWZ\n"
                + " \n"
                + "Especificações:\n"
                + " \n"
                + "Tela:\n"
                + "- Tamanho: 23,6\"\n"
                + "- Tipo de Tela: LED TN (Full HD)\n"
                + "- Brilho: 200 cd/m²\n"
                + "- Resolução Máxima: 1920 x 1080\n"
                + "- Contraste Dinâmico: 1000:1\n"
                + "- Suporte de Cores: 16,7 Milhões\n"
                + "- Pixel Pitch: 0,2715 x 0,2715 mm\n"
                + "- Tempo de Resposta: 5ms\n"
                + "- Revestimento de Tela: Anti-Glare treatment (3H)\n"
                + "- Ângulo de Visão: 170º / 160º\n"
                + "- Vesa: 100 x 100mm\n"
                + " \n"
                + "Alimentação:\n"
                + "- Tipo: Adaptador\n"
                + "- Voltagem: 100-240Vac, 50 / 60Hz (entrada)\n"
                + " \n"
                + "Frequência Analógica e Digital:\n"
                + "- H: 30~83 kHz\n"
                + "- V: 56~75 Hz",
                "Monitor LG 23.6´ LED Full HD D-Sub HDMI VESA Preto - 24M38H-B.AWZ .2 x 186.7 x 415.1 mm",
                new BigDecimal(799.88), new Date(), "https://images8.kabum.com.br/produtos/fotos/91708/91708_index_gg.jpg",
                Arrays.asList(new ImagemProduto(6L, "Bla bla bla", "https://images8.kabum.com.br/produtos/fotos/91708/91708_index_gg.jpg")),
                Arrays.asList(categorias.obter(1), categorias.obter(3), categorias.obter(6)));
        MAPA_PRODUTOS.put(produto.getId(), produto);
        
        
        produto = new Produto(4L, "Game FIFA 18 PS4 (PRE-VENDA)",
                "- Renovação do drible: No FIFA 18, você vai poder avançar entre os defensores com a confiança e habilidade de poder mudar de direção rapidamente, como fazem os melhores jogadores. As novas mecânicas permitem aos jogadores inserir mais criatividade em situações de mano a mano. Realize toques de bola mais definidos, faça viradas mais fechadas e explore um ataque mais dinâmico.",
                "Com a tecnologia Frostbite, o EA SPORTS FIFA 18 elimina o limite entre o mundo virtual e o real.",
                new BigDecimal(212.41), new Date(), "https://images9.kabum.com.br/produtos/fotos/90909/90909_index_gg.jpg",
                Arrays.asList(new ImagemProduto(7L, "Bla bla bla", "https://images9.kabum.com.br/produtos/fotos/90909/90909_index_gg.jpg"), new ImagemProduto(8L, "Xpto Xpto", "https://images9.kabum.com.br/produtos/fotos/90909/90909_index_gg.jpg")),
                Arrays.asList(categorias.obter(1), categorias.obter(4)));
        MAPA_PRODUTOS.put(produto.getId(), produto);
        
        
        produto = new Produto(5L, "Smartphone Samsung Galaxy J5 Prime SM-G570M, Quad Core 1.4Ghz",
                "Smartphone Samsung Galaxy J5 Prime SM-G570M, Quad Core 1.4Ghz, Android 6.0.1,Tela 5, 32GB, 13MP, Leitor Digital, Dual Chip, Desbl - Dourado",
                "O Galaxy J5 Prime possui um design premium com corpo em metal, tela de 5”",
                new BigDecimal(764.58), new Date(), "https://images5.kabum.com.br/produtos/fotos/90475/90475_index_gg.jpg",
                Arrays.asList(new ImagemProduto(9L, "Bla bla bla", "https://images5.kabum.com.br/produtos/fotos/90475/90475_index_gg.jpg"), new ImagemProduto(10L, "Xpto Xpto", "https://images5.kabum.com.br/produtos/fotos/90475/90475_index_gg.jpg")),
                Arrays.asList(categorias.obter(1), categorias.obter(5), categorias.obter(7), categorias.obter(8)));
        MAPA_PRODUTOS.put(produto.getId(), produto);
    }

    @Override
    public List<Produto> listar(int offset, int quantidade) {
        return new ArrayList<Produto>(MAPA_PRODUTOS.values());
    }

    @Override
    public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade) {
        List<Produto> lista = new ArrayList<Produto>();
        for (Map.Entry<Long, Produto> entry : MAPA_PRODUTOS.entrySet()) {
            Produto p = entry.getValue();
            if (p.getCategorias().contains(categoria)) {
                lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public Produto obter(long idProduto) {
        return MAPA_PRODUTOS.get(idProduto);
    }

    @Override
    public void incluir(Produto p) {
        // new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Produto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long idProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
