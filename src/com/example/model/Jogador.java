package com.example.model;

public class Jogador {
	
	//Dados do jogador
	private Integer idJogador;
	private String nomeJogador;
	
	//Estatisticas
	private Integer rodadas;
	private Integer vitorias;
	private Integer derrotas;
	private Integer pontos;
	private Double average; //Percentual de vitórias.
	
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Integer getRodadas() {
		return rodadas;
	}
	public void setRodadas(Integer rodadas) {
		this.rodadas = rodadas;
	}
	public Integer getVitorias() {
		return vitorias;
	}
	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}
	public Integer getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}
	public void setPontos(Integer pontos){
		this.pontos = pontos;
	}
	public Integer getPontos(){
		return pontos;
	}
	public Double getAverage() {
		return average;
	}
	public void setAverage(Double average) {
		this.average = average;
	}
	public int getIdJogador(){
		return idJogador;
	}
	public void setIdJogador(Integer id){
		this.idJogador = id;
	}

}
