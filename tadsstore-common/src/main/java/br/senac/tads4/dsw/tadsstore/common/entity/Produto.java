package br.senac.tads4.dsw.tadsstore.common.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_PRODUTO")

public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;
    
    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "DS_DESCRICAO")
    private String descricao;

    @Column(name = "DS_DESCRICAORESUMIDA")
    private String descricaoResumida;
    
    @Column(name = "QT_ESTOQUE")
    private int quantidade;

    @Column(name = "DS_IMAGEM")
    private String imagem;

    @Column(name = "VL_PRECO")
    private double preco;

    @Column(name = "DT_CADASTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;
    
    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, String descricaoResumida,int quantidade, double preco, Date dtCadastro, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoResumida = descricaoResumida;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dtCadastro = dtCadastro;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public boolean estoqueDisponivel(int qtMovimentar){
        boolean temEstoque = false;
        
        if (this.quantidade < qtMovimentar || this.quantidade <= 0) {
            temEstoque = false;
        }else{
            temEstoque = true;
        }
        
        return temEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", descricaoResumida=" + descricaoResumida + ", quantidade= " + quantidade + ", preco=" + preco + ", dtCadastro=" + dtCadastro + ", imagem=" + imagem + '}';
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
