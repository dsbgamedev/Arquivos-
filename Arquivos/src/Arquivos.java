import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {

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

		File arquivo = new File("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\arquivo.txt");// arquivo

		if (arquivo.exists()) {
			arquivo.createNewFile();
		}

		FileWriter escrever_no_arquivo = new FileWriter(arquivo);

		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
		}

		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

	}

}
