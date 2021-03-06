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
@Table(name = "TB_ITEMVENDA")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;

    @Column(name = "FK_PRODUTO")
    private Long produto;
    
    @Column(name = "FK_PEDIDO")
    private Long pedido;
    
    @Column(name = "QT_VENDA")
    private int qtVenda;
    
    @Column(name = "VL_PREUNI")
    private double vlPreuni;

    @Column(name = "VL_TOTAL")
    private double vlTotal;
    
    @Column(name = "DH_MOVIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtMovimento;

    public ItemVenda() {

    }

    public ItemVenda(Long id, Long produto, Long pedido, int qtVenda, double vlPreuni, double vlTotal, Date dtMovimento) {
        this.id = id;
        this.produto = produto;
        this.pedido = pedido;
        this.qtVenda = qtVenda;
        this.vlPreuni = vlPreuni;
        this.vlTotal = vlTotal;
        this.dtMovimento = dtMovimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Long getPedido() {
        return pedido;
    }

    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }

    public int getQtVenda() {
        return qtVenda;
    }

    public void setQtVenda(int qtVenda) {
        this.qtVenda = qtVenda;
    }

    public double getVlPreuni() {
        return vlPreuni;
    }

    public void setVlPreuni(double vlPreuni) {
        this.vlPreuni = vlPreuni;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Date getDtMovimento() {
        return dtMovimento;
    }

    public void setDtMovimento(Date dtMovimento) {
        this.dtMovimento = dtMovimento;
    }
    
    
}
