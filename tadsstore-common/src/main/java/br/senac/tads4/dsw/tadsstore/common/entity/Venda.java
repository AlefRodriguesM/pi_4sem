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
@Table(name = "TB_VENDA")
public class Venda {

    /*
    
    PK_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1000, INCREMENT BY 1) CONSTRAINT PK_PRODUTO_CATEGORIA PRIMARY KEY,
    FK_COMPRADOR INT, 
    DT_VENDA TIMESTAMP,
    VL_PRODUTOS DECIMAL(18,2),
    VL_FRETE DECIMAL(18,2),
    VL_TOTAL DECIMAL(18,2),
    NR_PARCELAS INT,
    NR_PRAZOINI INT, 
    NR_PRAZOFIM INT,
    DS_ENDERECO VARCHAR(60),
    DS_NUMERO VARCHAR(8),
    DS_BAIRRO VARCHAR(60),
    DS_COMPLEMETO VARCHAR(100),
    DS_CIDADE VARCHAR(50),
    DS_UF CHAR(2),
    DS_CEP VARCHAR(10),
    DS_FORMAPAG VARCHAR(30),
    DS_TRANSPORTADORA VARCHAR(60)
    
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ID")
    private Long id;

    @Column(name = "FK_COMPRADOR")
    private Long comprador;

    @Column(name = "DT_VENDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtVenda;

    @Column(name = "VL_PRODUTOS")
    private double vlProdutos;

    @Column(name = "VL_FRETE")
    private double vlFrete;

    @Column(name = "VL_TOTAL")
    private double vlTotal;

    @Column(name = "NR_PARCELAS")
    private int parcelas;

    @Column(name = "NR_PRAZOINI")
    private int prazoini;

    @Column(name = "NR_PRAZOFIM")
    private int prazofim;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_ENDERECO")
    private String endereco;

    @Column(name = "DS_NUMERO")
    private String numero;

    @Column(name = "DS_COMPLEMETO")
    private String complemento;

    @Column(name = "DS_CIDADE")
    private String cidade;

    @Column(name = "DS_UF")
    private String uf;

    @Column(name = "DS_CEP")
    private String cep;

    @Column(name = "DS_FORMAPAG")
    private String formapag;

    @Column(name = "DS_TRANSPORTADORA")
    private String transportadora;

    public Venda() {

    }

    public Venda(Long id, Long comprador, Date dtVenda, double vlProdutos, double vlFrete, double vlTotal, int parcelas, int prazoini, int prazofim, String endereco, String numero, String bairro, String complemento, String cidade, String uf, String cep, String formapag, String transportadora) {
        this.comprador = comprador;
        this.dtVenda = dtVenda;
        this.vlProdutos = vlProdutos;
        this.vlFrete = vlFrete;
        this.vlTotal = vlTotal;
        this.parcelas = parcelas;
        this.prazoini = prazoini;
        this.prazofim = prazofim;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.formapag = formapag;
        this.transportadora = transportadora;
    }

    @Override
    public String toString() {
        return "Venda{" + "comprador=" + getComprador() + ", dtVenda=" + getDtVenda() + ", vlProdutos=" + getVlProdutos() + ", vlFrete=" + getVlFrete() + ", vlTotal=" + getVlTotal() + ", parcelas=" + getParcelas() + ", prazoini=" + getPrazoini() + ", prazofim=" + getPrazofim() + ", endereco=" + getEndereco() + ", numero=" + getNumero() + ", bairro=" + getBairro() + ", complemento=" + getComplemento() + ", cidade=" + getCidade() + ", uf=" + getUf() + ", cep=" + getCep() + ", formapag=" + getFormapag() + ", transportadora=" + getTransportadora() + '}';
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

    public Long getComprador() {
        return comprador;
    }

    public void setComprador(Long comprador) {
        this.comprador = comprador;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public double getVlProdutos() {
        return vlProdutos;
    }

    public void setVlProdutos(double vlProdutos) {
        this.vlProdutos = vlProdutos;
    }

    public double getVlFrete() {
        return vlFrete;
    }

    public void setVlFrete(double vlFrete) {
        this.vlFrete = vlFrete;
    }

    public double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public int getPrazoini() {
        return prazoini;
    }

    public void setPrazoini(int prazoini) {
        this.prazoini = prazoini;
    }

    public int getPrazofim() {
        return prazofim;
    }

    public void setPrazofim(int prazofim) {
        this.prazofim = prazofim;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFormapag() {
        return formapag;
    }

    public void setFormapag(String formapag) {
        this.formapag = formapag;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }
}
