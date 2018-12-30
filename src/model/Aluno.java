package model;

/**
 * Classe que representa uma entidade aluno de uma disciplina qualquer.
 * 
 * @author ednilsonrossi
 * 
 */
public class Aluno {

	private int ra;
	private String nome;
	private double media;
	
	public Aluno() {	}
	
	public Aluno(int ra, String nome, double media) {
		this.ra = ra;
		this.nome = nome;
		this.media = media;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "[Aluno: " + nome + " (" + ra + ") Média: " + media + "]";
	}
	
}
