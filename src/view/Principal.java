package view;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {
	public static void main(String[] args) {
	ArquivosController control = new ArquivosController();
	
	String caminho = "C:\\temp\\";
	String arquivo = "generic-food.csv";
	
	try {
		control.lerDiretorio(caminho);
		control.lerArquivo(caminho, arquivo);
		
		
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}
	
	}
}
