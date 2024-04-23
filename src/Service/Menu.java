package Service;

import java.util.List;
import java.util.Scanner;
import Utils.GerenciadorDerProduto;
import models.Produto;

public class Menu {
	
	Scanner sc = new Scanner(System.in);

	GerenciadorDerProduto gs = new GerenciadorDerProduto();

	public Menu() {
		gs.verificaECriar("produto.txt");

	}

	public void criarProduto() {
		System.out.println("Digite o nome: ");
		String nome = sc.next();

		System.out.println("Digite seu preço: ");
		double preco = sc.nextDouble();
		
		System.out.println("digite a sua quantidade");
		int quantidade = sc.nextInt();
		long id = getNextId();

		Produto u = new Produto(id, nome, preco, quantidade);
		gs.adicionarNovoProduto(u);
		
		

	}

	public void editar() {
		System.out.println("Digite o id do Produto: ");
		long id = sc.nextLong();
		
		System.out.println("Digite um novo nome: ");
		String nome = sc.next();
		
		System.out.println("Digite a nova senha: ");
		double preco = sc.nextDouble();
		
		System.out.println("digite a sua quantidade");
		int quantidade = sc.nextInt();
		
		
		gs. editaproduto(id, nome, preco, quantidade);
		
	}

	public void deletar() {
		System.out.println("Digite o Id do Produto a ser deletado: ");
		int id = sc.nextInt();
		gs. deletarProduto(id);

	}

	public void listar() {
		gs.listarProduto();
	}
	
	public void listarEspefico() {
		System.out.println("Digite o id do usuario que deseja detalhar: ");
		int id = sc.nextInt();
		gs.listarEspecifico(id);
		
	}
	//public void fazerLogin() {
		//System.out.print("Digite seu nome: ");
		//String nome = sc.next();
		//System.out.print("Digite sua senha: ");
		//String senha = sc.next();
		//gs.fazerLogin(nome, senha);
	//}

	public long getNextId() {
		List<Produto> produtos = gs.lerProtudo();
		long maxId = 0;
		for (Produto produto : produtos) {
			long id = produto.getId();

			if (id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}

}



	

