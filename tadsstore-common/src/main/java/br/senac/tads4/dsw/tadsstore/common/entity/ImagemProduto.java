package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;

/**
 *
 * @author andrey
 */

public class ImagemProduto implements Serializable {

  private Long id;

  private String nomeArquivo;

  private String legenda;

  private Produto produto;

  public ImagemProduto() {

  }

  public ImagemProduto(Long id, String nomeArquivo, String legenda) {
    this.id = id;
    this.nomeArquivo = nomeArquivo;
    this.legenda = legenda;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeArquivo() {
    return nomeArquivo;
  }

  public void setNomeArquivo(String nomeArquivo) {
    this.nomeArquivo = nomeArquivo;
  }

  public String getLegenda() {
    return legenda;
  }

  public void setLegenda(String legenda) {
    this.legenda = legenda;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public String getUrlArquivo() {
    return "http://localhost:8080/imagens/" + nomeArquivo;
  }

  @Override
  public String toString() {
    return "ImagemProduto{" + "id=" + id + ", legenda=" + legenda + ", nomeArquivo=" + nomeArquivo + '}';
  }

}
