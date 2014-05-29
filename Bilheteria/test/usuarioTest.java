import static org.junit.Assert.*;

import java.sql.Date;

import models.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class usuarioTest {
	
	Usuario userTest;
	Date d = new Date(System.currentTimeMillis());
	
	@Before
	public void setUp(){
		userTest = new Usuario("Ze", "0902341044", "ze@ze.com", "RuaDoZe", "8456047294", d, "zedatapioca", "zedatapioca", 0, "BairroDoZe", "Japecanga", "RN");
	}
	
	@Test
	public void testCase1(){
		String nome = "Ze"; 
		String cpf = "0902341044"; 
		String email = "ze@ze.com"; 
		String telefone = "8456047294";
		String usuario = "zedatapioca"; 
		String senha = usuario; 
		String endereco = "RuaDoZe"; 
		String bairro = "BairroDoZe"; 
		
		Usuario ze = new Usuario(nome, cpf, email, endereco, telefone, d, usuario, senha, 0, bairro, "Japecanga", "RN");
		
		
		assertTrue(ze != null);
	}
	
	@After
	public void tearDown() {}
	

}
