//package compiladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Principal{
	public static void main(String[] args)throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		//InputStreamReader r = new InputStreamReader(System.in);    
		// BufferedReader leitura = new BufferedReader(r);
		AnalisadorLexico analisadorLexico = new AnalisadorLexico(1);
		int caracter = 0;
		String codigo = "";
		while((caracter = bf.read()) != -1) {
			if(caracter != 13){
			 	//System.out.println((char)caracter + " ASC: " + caracter);
				codigo += (char)caracter;
			}

		}


		int o = 0;
		try {
			while(!codigo.isEmpty()) {
				//System.out.println(codigo);
				codigo = analisadorLexico.Analisar(codigo);
				System.out.println("---->" + analisadorLexico.registroLexico.lexema);
				o++;
			}
		}catch(StringIndexOutOfBoundsException e) {}
	}	
}

/*public class Principal {

	public static void main(String[] args) throws IOException{
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		AnalisadorLexico analisadorLexico = new AnalisadorLexico(1);
		
		String path = input.readLine();
		//int n = path.length();
		//System.out.println(n);
		String codigo = "";

		for(int i = 1; path != null; i++){
			
			codigo += path + "\n";
			path = input.readLine();
			//if(path == null){
			//	codigo += path;
			//	//System.out.println(codigo);
			//}
		}

		int o = 0;
		try {
			while(!codigo.isEmpty()) {
				//System.out.println(codigo);
				codigo = analisadorLexico.Analisar(codigo);
				System.out.println("---->" + analisadorLexico.registroLexico.lexema);
				o++;
			}
		}catch(StringIndexOutOfBoundsException e) {}	
	}
}*/


/*public class Principal {
	public static void main(String[] args) throws IOException{
		
	    Path wiki_path = Paths.get("C:/Users/Jone/Desktop/COMPILA/compilation-master/compiladores", "teste_6.l");
	    
		AnalisadorLexico analisadorLexico = new AnalisadorLexico(1);
		
		byte[] wikiArray = Files.readAllBytes(wiki_path); //lendo o arquivo
		byte[] codigoFonte = new byte[wikiArray.length]; //vetor de byte para retirar o '\r' da string
		
		int j = 0;
		for(int i = 0; i<wikiArray.length;i++) {
			if(wikiArray[i] != 13) { // caracter \r
				codigoFonte[j] = wikiArray[i];
				j++;
			}
		}
		
	    String codigo = new String(codigoFonte, "ASCII");
		
		int o = 0;
		
			while(!codigo.isEmpty()) {
				//System.out.println(codigo);
				codigo = analisadorLexico.Analisar(codigo);
				System.out.println("---->" + analisadorLexico.registroLexico.lexema);
				o++;
			}
	
		codigo = analisadorLexico.Analisar(codigo);
		AnalisadorSintatico analisadorSintatico = new AnalisadorSintatico(analisadorLexico.registroLexico.token, codigo, analisadorLexico);
		analisadorSintatico.Proc_S();
	}
}*/
