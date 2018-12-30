package view;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Aluno;
import util.Arquivo;

public class Main {

	public static void main(String[] args) {
		gerarJson();
		lerJson();
	}
	
	/**
	 * Método responsável por gerar um List com alguns objetos do tipo aluno. Esse List é convrtido em uma String contendo 
	 * um json com todos os objetos alunos do List, por fim, a String é armazenada em um arquivo.
	 * 
	 */
	public static void gerarJson() {
		List<Aluno> todos = new ArrayList<>(); 
		todos.add(new Aluno(123, "Joao", 7.5));
		todos.add(new Aluno(456, "Carlos", 4.5));
		todos.add(new Aluno(789, "Maria", 10));
		todos.add(new Aluno(741, "Arthur", 5.9));
		
		Gson gson = new Gson();
		
		String jsonGerado = gson.toJson(todos);
		
		Arquivo.gravarDados(jsonGerado);
	}

	/**
	 * Método responsável por recuperar uma String do arquivo gerado, converter o json para um Array de objetos do tipo 
	 * Aluno e apresenta todos os alunos recuperados.
	 * 
	 */
	public static void lerJson() {
		String jsonLido = Arquivo.lerDados();
		
		Gson gson = new Gson();
		
		Aluno[] todos = gson.fromJson(jsonLido, Aluno[].class);
		
		for(Aluno a : todos) {
			System.out.println(a.toString());
		}
	}
	
}
