import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;



public class ApachetPoi {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\arquivo.xls");
		
		if(file.exists()) {
			file.createNewFile();
		}
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("A");
		pessoa1.setIdade(20);
		pessoa1.setEmail("numero1@gmail.com");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("B");
		pessoa2.setIdade(20);
		pessoa2.setEmail("numero2@gmail.com");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("C");
		pessoa3.setIdade(20);
		pessoa3.setEmail("numero3@gmail.com");

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();/*Vai ser usado para escrever a planilha*/
		HSSFSheet linhaPessoa = hssfWorkbook.createSheet("Planilhas de pessoas Jdev Treinamento");/*Cria a planilha*/
		
		int numeroLinha = 0;//controle para acrescentar linhas
		for (Pessoa p : pessoas) {
			Row linha = linhaPessoa.createRow(numeroLinha++);/*Criando a linha na planilha*/
			
			int celula = 0; 
			
			Cell cellNome = linha.createCell(celula ++);
			cellNome.setCellValue(p.getNome());
			
			Cell cellEmail = linha.createCell(celula ++);
			cellEmail.setCellValue(p.getEmail());
			
			Cell cellIdade = linha.createCell(celula ++);
			cellIdade.setCellValue(p.getIdade());
			
			
		}/*Terminou de montar a planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);/*Escreve a planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha foi criada");
		
	}

}
