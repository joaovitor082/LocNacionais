package entidades;

import entidades.ENUM.GeneroFilme;

public class Filme {
  private int idFilme;
  private String nomeFilme;
  private GeneroFilme genero;
  private int anoLancamento;
  private String diretor;
  private String sinopse;
  private int duracao;
  private int classificacaoIndicativa;
  private boolean disponivel;
  
  
  public Filme(int idFilme, String nomeFilme, GeneroFilme genero, int anoLancamento, String diretor, String sinopse, int duracao, int classificacaoIndicativa, boolean disponivel) {
    this.idFilme = idFilme;
    this.nomeFilme = nomeFilme;
    this.genero = genero;
    this.anoLancamento = anoLancamento;
    this.diretor = diretor;
    this.sinopse = sinopse;
    this.duracao = duracao;
    this.classificacaoIndicativa = classificacaoIndicativa;
    this.disponivel = disponivel;
  }

  public String getNomeFilme() {
    return nomeFilme;
  }


  public void setNomeFilme(String nomeFilme) {
    this.nomeFilme = nomeFilme;
  }


  public GeneroFilme getGenero() {
    return genero;
  }


  public void setGenero(GeneroFilme genero) {
    this.genero = genero;
  }


  public int getAnoLancamento() {
    return anoLancamento;
  }


  public void setAnoLancamento(int anoLancamento) {
    this.anoLancamento = anoLancamento;
  }


  public String getDiretor() {
    return diretor;
  }


  public void setDiretor(String diretor) {
    this.diretor = diretor;
  }


  public String getSinopse() {
    return sinopse;
  }


  public void setSinopse(String sinopse) {
    this.sinopse = sinopse;
  }


  public int getDuracao() {
    return duracao;
  }


  public void setDuracao(int duracao) {
    this.duracao = duracao;
  }


  public int getClassificacaoIndicativa() {
    return classificacaoIndicativa;
  }


  public void setClassificacaoIndicativa(int classificacaoIndicativa) {
    this.classificacaoIndicativa = classificacaoIndicativa;
  }


  public boolean isDisponivel() {
    return disponivel;
  }


  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }

  
}
