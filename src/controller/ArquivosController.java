package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController {

	public ArquivosController() {
		super();
	}

	public void lerDiretorio(String caminho) throws IOException {
		File dir = new File(caminho);
		if (dir.exists() && dir.isDirectory()) {
			File[] arquivos = dir.listFiles();

			for (File f : arquivos) {
				if (f.isFile()) {
					System.out.println("\t" + f.getName());
				} else {
					System.out.println("<DIR>\t" + f.getName());
				}
			}

		} else {
			throw new IOException("Diretório inválido!");
		}

	}

	public void lerArquivo(String caminho, String nome) throws IOException {
		File arq = new File(caminho, nome);
		if (arq.exists() && arq.isFile()) {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(arq)));

			String linha = buffer.readLine();
			
			String[] cabecalho = linha.split(";");
			System.out.println(cabecalho[0] + "\t" + cabecalho[1] + "\t" + cabecalho[3]);
			
			while ((linha = buffer.readLine()) != null) {
				if (!linha.trim().isEmpty()) {
					String[] celulas = linha.split(";");
					if (celulas.length >= 4 && celulas[2].toLowerCase().contains("fruit")) {
						System.out.println(celulas[0] + "\t" + celulas[1] + "\t" + celulas[3]);
					} 
				}
			}

			buffer.close();

		} else {
			throw new IOException("Arquivo inválido!");
		}
	}

}
