import static org.junit.Assert.*;
import models.Setor;

import org.junit.Test;

import controllers.EstadioCtrl;


public class setorTest {

	models.Setor setor1;
	models.Setor setor2;
	
	@Test
	public void testCriarSetor() {
		setor1 = new models.Setor("A", (long) 1);
		setor1.save();
		
		setor2 = new models.Setor("B", (long) 2);
		setor2.save();		
	}

	@Test
	public void testSetorApagar() {
		Setor s = Setor.find("id", (long) 1).first();
		s.delete();
	}

	@Test
	public void testSalvarAlteracoesSetor() {
		Setor s = Setor.find("id", (long) 2).first();
		s.nome = "C";
		s.save();
	}

}