import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Supermercado.Arquivo;
import Supermercado.BD;
import Supermercado.Estoque;
import Supermercado.Funcionario;
import Supermercado.Produto;

public class BDTest {
	private static BD bd;
	
	@BeforeClass
	public static void init() {
		Estoque estoqueLocal = new Estoque();
        bd = new BD(estoqueLocal);
        Arquivo arquivo = new Arquivo();
        arquivo.getProdutos(estoqueLocal);
        arquivo.getFuncionarios(bd);
        
	}
	
	@Test
	public void loginFuncionarioTest() {
		
		boolean test = bd.loginFuncionario("catarina", "root");
        boolean test2 = bd.loginFuncionario("fasfaf", "fasfaf");
        
        assertEquals(true, test);
        assertEquals(false, test2);
	}
	
	@Test
	public void cadastrarFuncionarioTest() {
		
		bd.cadastrarFuncionario("Isaac", "isaac", "123456", 1);
		Funcionario f = bd.getFuncionario("isaac");
		assertNotEquals(null, f);
        
	}

}
