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
        
        	assertEquals(true, test);
	}
	
	@Test
	public void cadastrarFuncionarioTest() {
		
		bd.cadastrarFuncionario("Isaac", "isaac", "123456", 1);
		Funcionario f = bd.getFuncionario("isaac");
		assertNotEquals(null, f);
        
	}
	
	@Test
	public void setFuncionarioTest() {
		
		bd.cadastrarFuncionario("Teste", "isaacteste", "123456", 1);
		bd.setFuncionarios();
		Arquivo arq = new Arquivo();
		arq.getFuncionarios(bd);
		Funcionario f = bd.getFuncionario("isaacteste");
        
		assertNotEquals(null, f);
	}

}
