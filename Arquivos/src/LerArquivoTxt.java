//import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream entrada = new FileInputStream("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\arquivo.xls");
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//pega a primeira planilha do nosso arquivo exel
		
		//percorrendo as linhas
		
		Iterator<Row> linhaIterator =  planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();//Dados da pessoal na linha
			
			Iterator<Cell> celulas = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celulas.hasNext()) {/*Percorrer as celulas*/
				Cell cell = celulas.next();
			
				switch(cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
					
				case 1:
					pessoa.setEmail(cell.getStringCellValue());
					break;
					
				case 2:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				}/* Fim da celulas na linha */
				
				
			}
			
			pessoas.add(pessoa);
			
		}
	
		entrada.close();/*Terminou de ler o arquivo exel*/
		
		for (Pessoa pessoa : pessoas) {//Com a lista pode gravar no banco de dados
			System.out.println(pessoa);
		}
	
	}

}
	/* Modulo 16 - Aula 5
	 * 
	 * FileInputStream entradaArquivo =
		new FileInputStream(new File("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\arquivo.txt"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		while (lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			System.out.println(linha);
			
			if(linha != null && !linha.isEmpty()) {
				
				String[] dados = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setIdade(Integer.parseInt(dados[1]));
				pessoa.setEmail(dados[2]);
				
				pessoas.add(pessoa);
				
			}
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoas);
		}
		
		
	}
	 */

	
	