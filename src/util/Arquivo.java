package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Classe responsável por facilitar a interação do sistema entre o arquivo de dados.
 * Os métodos desta classe gravam uma string no ARQUIVO e recuperam os dados no mesmo
 * ARQUIVO.
 * 
 * @author ednilsonrossi
 *
 */
public class Arquivo {
	
	/**
	 * Atributo representa o nome do arquivo. Optou-se por fixar o nome do arquivo no diretório
	 * do projeto por questão de exemplo.
	 */
	public static final String ARQUIVO = "dados.dat";
	
	/**
	 * Método responável por gravar os argumento txt no arquivo. É esperado que o argumento possua um
	 * json. Além disso, o método sobreescreve os dados existentes no arquivo, assim, sempre deve-se
	 * inserir o json completo com todos os dados.
	 * 
	 * @param txt contendo json com os dados para serem armazenados.
	 */
	public static void gravarDados(String txt) {
		if(txt != null && !txt.isEmpty()) {
			OutputStream outputStream = null;
			OutputStreamWriter outputStreamWriter = null;
			try {
				outputStream = new FileOutputStream(ARQUIVO);
				outputStreamWriter = new OutputStreamWriter(outputStream);
				for(char c : txt.toCharArray()) {
					outputStream.write(c);
				}
				outputStreamWriter.close();
				outputStream.close();
			}catch (IOException e) {
				System.out.println("Erro ao gravar dados em arquivo.\n Mensagem: " + e);
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Método responsável por recuperar os dados do ARQUIVO. Os dados são convertidos em String e retornados
	 * para a chamada.
	 * 
	 * @return json com os dados gravados no arquivo.
	 */
	public static String lerDados() {
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String linha;
        
        try {
	        inputStream = new FileInputStream(ARQUIVO);
	        inputStreamReader = new InputStreamReader(inputStream);
	        bufferedReader = new BufferedReader(inputStreamReader);
	
	        while((linha = bufferedReader.readLine()) != null){
	        	sb.append(linha);
	        }
	        
	        bufferedReader.close();
        }catch (IOException e) {
			System.out.println("Erro ao recuperar os dados do arquivo. Mensagem: " + e);
			e.printStackTrace();
		}
        
        return sb.toString();
	}
}
