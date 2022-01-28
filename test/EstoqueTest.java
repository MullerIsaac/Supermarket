import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Supermercado.Arquivo;
import Supermercado.BD;
import Supermercado.Estoque;
import Supermercado.Produto;

public class EstoqueTest {
	private static Estoque estoqueLocal2;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		Produto.codProd = 0;
		estoqueLocal2 = new Estoque();
        Arquivo arquivo = new Arquivo();
        arquivo.getProdutos(estoqueLocal2);
	}
	

	@Test
	public void InserirProdutoTest() {
		estoqueLocal2.inserirProduto(5.3f, "Feijão Preto 1kg", 20f, 1);
		Produto p = estoqueLocal2.buscarProduto(25);
		assertEquals("Feijão Preto 1kg", p.getNome());
		
		estoqueLocal2.inserirPrateleira(p, 5f);
		float quant = estoqueLocal2.quantidadeEstoque(p);
		assertEquals(25f, quant, 0);
	}
	
	@Test
	public void getEstoqueArquivo() {
		Produto p = estoqueLocal2.buscarProduto(1);
		assertEquals("Cenoura a granel kg", p.getNome());
	}
	
	@Test 
	public void inserirPrateleiraTest() {
		Produto p = estoqueLocal2.buscarProduto(1);
		estoqueLocal2.inserirPrateleira(p, 5f);
		
		float quant = estoqueLocal2.quantidadeEstoque(p);
		assertEquals(15f, quant, 0f);
	}
	
	@Test 
	public void retirarPrateleiraTest() {
		Produto p = estoqueLocal2.buscarProduto(1);
		estoqueLocal2.retirarPrateleira(p, 5f);
		
		float quant = estoqueLocal2.quantidadeEstoque(p);
		assertEquals(10f, quant, 0f);
	}
	

}
