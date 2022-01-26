import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import Supermercado.Arquivo;
import Supermercado.BD;
import Supermercado.Caixa;
import Supermercado.Estoque;
import Supermercado.Item;
import Supermercado.Produto;
import Supermercado.Venda;

public class VendaTest {
	private static BD bd;
	private static Estoque estoqueLocal3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Produto.codProd=0;
		estoqueLocal3 = new Estoque();
        bd = new BD(estoqueLocal3);
        Arquivo arquivo = new Arquivo();
        arquivo.getProdutos(estoqueLocal3);
        arquivo.getFuncionarios(bd);
	}

	@Test
	public void adicionarProdutoVendaTest() {
		Caixa caixa = new Caixa(bd);
		Venda venda = new Venda(caixa.getIdCaixa(), "catarina");
		
		Produto p1 = estoqueLocal3.buscarProduto(1);
		Produto p2 = estoqueLocal3.buscarProduto(3);
		Produto p3 = estoqueLocal3.buscarProduto(5);
		Item i1 = new Item(p1, 5f);
		Item i2 = new Item(p2, 5f);
		Item i3 = new Item(p3, 5f);
		
		venda.adicionarProdutoVenda(i1);
		venda.adicionarProdutoVenda(i2);
		venda.adicionarProdutoVenda(i3);
		
		ArrayList<Item> pc = (ArrayList<Item>) venda.getProdutosCompra();
		ArrayList<Item> pctest = new ArrayList<Item>();
		pctest.add(i1);
		pctest.add(i2);
		pctest.add(i3);
		
		assertEquals(pc, pctest);
		
	}
	
	@Test
	public void removerProdutoVendaTest() {
		Caixa caixa = new Caixa(bd);
		Venda venda = new Venda(caixa.getIdCaixa(), "catarina");
		
		Produto p1 = estoqueLocal3.buscarProduto(1);
		Produto p2 = estoqueLocal3.buscarProduto(3);
		Produto p3 = estoqueLocal3.buscarProduto(5);
		Item i1 = new Item(p1, 5f);
		Item i2 = new Item(p2, 5f);
		Item i3 = new Item(p3, 5f);
		
		venda.adicionarProdutoVenda(i1);
		venda.adicionarProdutoVenda(i2);
		venda.adicionarProdutoVenda(i3);
		
		ArrayList<Item> pc = (ArrayList<Item>) venda.getProdutosCompra();
		ArrayList<Item> pctest = new ArrayList<Item>();
		pctest.add(i1);
		pctest.add(i2);
		pctest.add(i3);
		
		venda.removerProdutoVenda(i3);
		
		assertNotEquals(pc, pctest);
		
	}
	
	@Test
	public void CalcularTrocoTest() {
		Caixa caixa = new Caixa(bd);
		Venda venda = new Venda(caixa.getIdCaixa(), "catarina");
		
		Produto p1 = estoqueLocal3.buscarProduto(1);
		Produto p2 = estoqueLocal3.buscarProduto(3);
		Produto p3 = estoqueLocal3.buscarProduto(5);
		Item i1 = new Item(p1, 5f);
		Item i2 = new Item(p2, 5f);
		Item i3 = new Item(p3, 5f);
		
		venda.adicionarProdutoVenda(i1);
		venda.adicionarProdutoVenda(i2);
		venda.adicionarProdutoVenda(i3);
		
		float valortest = i1.getValorTotal() + i2.getValorTotal()+i3.getValorTotal();
		
		assertEquals(20 -valortest, 20 - venda.getValorTotal(), 0f);
		
	}

}
