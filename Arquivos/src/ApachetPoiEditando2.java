import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachetPoiEditando2 {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\arquivo.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/* Prepara a entrada do arquivo xls*/
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);//Pegando a planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {/*Enquanto tiver linha*/
			
			Row linha = linhaIterator.next();/* Dados da linha */
			
			String valorCelula = linha.getCell(0).getStringCellValue();
			
			linha.getCell(0).setCellValue(valorCelula + " **** Valor gerado na aula");
					
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}
	

}
