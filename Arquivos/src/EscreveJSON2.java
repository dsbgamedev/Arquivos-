import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreveJSON2 {
	
	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("25652456");
		usuario1.setNome("Douglas");
		usuario1.setSenha("123456");
		usuario1.setLogin("doug");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("1111111");
		usuario2.setNome("Userrr");
		usuario2.setSenha("123456");
		usuario2.setLogin("user");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();//E somente para organizar o codigo
		
		String jsonUser= gson.toJson(usuarios);
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\filjson.json");
		
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
		
		//**************** LENDO ARQUIVO JSON *********************//
		
		FileReader fileReader = new FileReader("C:\\Users\\Douglas\\git\\repository4\\Arquivos\\filjson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
	
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuario.add(usuario);		
		}
		
		System.out.println("leitura arquivo texto" + listUsuario);
			
	}

}
