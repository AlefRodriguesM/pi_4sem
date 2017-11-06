package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andrey
 */
public class Produto implements Serializable {

    private Long id;

    private String nome;

    private String descricao;

    private String descricaoResumida;
    
    private int quantidade;

    private String imagem;

    private BigDecimal preco;

    private Date dtCadastro;

    private List<Categoria> categorias;

    private List<ImagemProduto> imagens;

    private String observacoes;

    //private List<ItemCompra> itensCompra;
    public Produto() {

    }

    public Produto(Long id, String nome, String descricao, String descricaoResumida,int quantidade, BigDecimal preco, Date dtCadastro, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoResumida = descricaoResumida;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dtCadastro = dtCadastro;
        this.imagem = imagem;
    }

    public Produto(Long id, String nome, String descricao, String descricaoResumida, int quantidade, BigDecimal preco, Date dtCadastro, String imagem, List<ImagemProduto> imagens, List<Categoria> categorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoResumida = descricaoResumida;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dtCadastro = dtCadastro;
        this.imagens = imagens;
        this.categorias = categorias;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    public void setDescricaoResumida(String descricaoResumida) {
        this.descricaoResumida = descricaoResumida;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = imagens;
    }
//
//  public List<ItemCompra> getItensCompra() {
//    return itensCompra;
//  }
//
//  public void setItensCompra(List<ItemCompra> itensCompra) {
//    this.itensCompra = itensCompra;
//  }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", descricaoResumida=" + descricaoResumida + ", quantidade= " + quantidade + ", preco=" + preco + ", dtCadastro=" + dtCadastro + ", categorias=" + categorias + ", imagens=" + imagens + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
