package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "ES_MOVIMENTOS")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;
    
    @Column(name = "FK_PRODUTO")
    private Long idProduto;
    
    @Column(name = "FK_PEDIDO")
    private Long idPedido;
    
    @Column(name = "TG_MOVIMENTO")
    private String tgMovimento;
    
    @Column(name = "QT_MOVIMENTO")
    private int qtMovimento;
    
    @Column(name = "DH_MOVIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhMovimento;
    
    public Movimento() {
    }

    public Movimento(Long id, Long idProduto, Long idPedido, String tgMovimento, int qtMovimento, Date dhMovimento) {
        this.id = id;
        this.idProduto = idProduto;
        this.idPedido = idPedido;
        this.tgMovimento = tgMovimento;
        this.qtMovimento = qtMovimento;
        this.dhMovimento = dhMovimento;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getTgMovimento() {
        return tgMovimento;
    }

    public void setTgMovimento(String tgMovimento) {
        this.tgMovimento = tgMovimento;
    }

    public int getQtMovimento() {
        return qtMovimento;
    }

    public void setQtMovimento(int qtMovimento) {
        this.qtMovimento = qtMovimento;
    }

    public Date getDhMovimento() {
        return dhMovimento;
    }

    public void setDhMovimento(Date dhMovimento) {
        this.dhMovimento = dhMovimento;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", idProduto=" + idProduto + ", idPedido=" + idPedido + ", tgMovimento=" + tgMovimento + ", qtMovimento= " + qtMovimento + ", dhMovimento=" + dhMovimento + '}';
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
        final Movimento other = (Movimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
