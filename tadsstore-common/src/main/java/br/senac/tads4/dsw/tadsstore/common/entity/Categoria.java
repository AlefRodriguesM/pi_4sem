package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author andrey
 */
public class Categoria implements Serializable {

  private Integer id;

  private String nome;

  private List<Produto> produtos;

  public Categoria() {

  }

  public Categoria(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public String toString() {
    return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 47 * hash + Objects.hashCode(this.id);
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
    final Categoria other = (Categoria) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }
}