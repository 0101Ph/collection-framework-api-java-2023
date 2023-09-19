package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

	public class CarrinhoDeCompras {
		//atributos
	private List<Item> itemList;
	
	public CarrinhoDeCompras() {
		this.itemList = new ArrayList<>();
	}
	
	//Começo dos métodos:
	//Adiciona um item ao carrinho com o nome, preço e quantidade especificados.
	public void adicionarItem(String nome, double preco, int quant) {
		Item item = new Item(nome, preco, quant);
		this.itemList.add(item);
	} 
	
	//Remove um item do carrinho com base no seu nome.
	public void removerItem(String nome) {
		List<Item> itensParaRemover = new ArrayList<>();
		
		if (!itemList.isEmpty()) {
			for (Item i : itemList) {
				if (i.getNome().equalsIgnoreCase(nome)){
					itensParaRemover.add(i);
				}
			}
			itemList.removeAll(itensParaRemover);
			}
		else {
			System.out.println("O Carrinho está vazio");
		}
		} 
	
	// Calcula e retorna o valor total do carrinho, levando em consideração o preço e a quantidade de cada item.
	public double calcularValorTotal(){
		
		if (!itemList.isEmpty()){
			double valorTotal = 0d;
			for (Item item : itemList){
				double valorItem = item.getPreco()* item.getQuant();
				
				valorTotal = valorTotal + valorItem;
			}
			return valorTotal;
			} else {
				throw new RuntimeException("A lista está vazia");
			}
	}
	//Exibe todos os itens presentes no carrinho, mostrando seus nomes, preços e quantidades.
	public void exibirItens() {

	if (!itemList.isEmpty()) {
		System.out.println(itemList);
	}
	else {
		throw new RuntimeException("O carrinho está vazio");
	}
	}
	//Fim dos métodos
	
	//Aqui será exibido na tela
	public static void main (String[] args) {
		//Instancia
		CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
		
		//add os itens
		carrinhoDeCompras.adicionarItem("Pacote de arroz", 50.55, 2);
		carrinhoDeCompras.adicionarItem("Pacote de feijão", 40.39, 2);
		carrinhoDeCompras.adicionarItem("Ovos", 25.19, 1);
		
		//aqui exibe os itens
		carrinhoDeCompras.exibirItens();
		
		//calcular 
		System.out.println("O valor total é de: " + carrinhoDeCompras.calcularValorTotal());
	
		//remover
		carrinhoDeCompras.removerItem("Ovos");
		
		//atualização
		carrinhoDeCompras.exibirItens();
		
		//calcular novamente
		 System.out.println("O valor total é de: " + carrinhoDeCompras.calcularValorTotal());
		
		
	}
}
