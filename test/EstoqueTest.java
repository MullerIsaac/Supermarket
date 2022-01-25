import static org.junit.Assert.*;

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
		estoqueLocal2 = new Estoque();
        Arquivo arquivo = new Arquivo();
        arquivo.getProdutos(estoqueLocal2);
	}

	@Test
	public void InserirProdutoTest() {
		//Coloquei 49 pois o codigo do produto é estatico
		Integer cod = new Integer(49);
		estoqueLocal2.inserirProduto(5.3f, "Feijão Preto 1kg", 20f, 1);
		Produto p = estoqueLocal2.buscarProduto(cod);
		assertEquals("Feijão Preto 1kg", p.getNome());
	}
	
	@Test
	public void getEstoqueArquivo() {
		Integer cod = new Integer(25);
		Produto p = estoqueLocal2.buscarProduto(cod);
		assertEquals("Cenoura a granel kg", p.getNome());
	}

}
