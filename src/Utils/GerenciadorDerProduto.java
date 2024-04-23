package Utils;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class GerenciadorDerProduto {
	
	private static final String NOME_PRODUTO = "produtos.txt";

	// verificar a existencia do nosso banco e criar caso nao exista
	public void verificaECriar(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);
		// verificar se o arquivo existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando.");
		} else // tente criar, caso de erro, exibe o erro
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado...");
			} catch (IOException e) {
				System.err.println("Ocorreu um erro ao criar o arquivo" + e.getMessage());
			}
	}

	public void adicionarNovoProduto(Produto produto) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_PRODUTO, true))) {

			bw.write(produto.toString());
			bw.newLine();
			System.out.println("Usuario cadastrado com sucesso");

		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());

		}

	}

	public List<Produto> lerProtudo() {
		List<Produto> produtos = new ArrayList<Produto>();
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_PRODUTO))) {
			String linha;

			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";");

				// adicionar usuario na lista-
				produtos.add(new Produto(Long.parseLong(partes[0]), partes[1], Double.parseDouble(partes[2]), Integer.parseInt(partes[3])));

			}
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return produtos;
	}

	public void deletarProduto(int id) {
		List<Produto> produtos = lerProtudo();
		if (produtos.removeIf(produto -> produto.getId() == id)) {
			reescreverArquivo(produtos);
			System.out.println("Usuario deletado com sucesso");
		} else {
			System.err.println("Usuario nao encontrado");
		}

	}

	public void reescreverArquivo(List<Produto> produtos) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_PRODUTO))) {
			for (Produto produto : produtos) {
				bw.write(produto.toString());
				bw.newLine();
			}

		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao reescrever o arquivo");
		}
	}

	public void listarProduto() {
		List<Produto> produtos = lerProtudo();
		if (produtos.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Lista de usuarios: ");
			for (Produto produto : produtos) {
				System.out.println(
						"ID:" + produto.getId() + " Nome:" + produto.getNome() + " preco:" + produto.getPreco() + " quant:" + produto.getQuantidade() );
			}
		}

	}

	public void editaproduto(long id, String novoNome, double novopreco, int novoquant) {
		List<Produto> produtos = lerProtudo();
		boolean encontrado = false;
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produto.setNome(novoNome);
				produto.setPreco(novopreco);
				produto.setQuantidade(novoquant);
				encontrado = true;
				break;
			}
		}

		if (encontrado) {
			reescreverArquivo(produtos);
			System.out.println("Usuario editado com sucesso");
		} else {
			System.out.println("usuario nao encontrado");
		}

	}

	public void listarEspecifico(int id) {
		List<Produto> produtos = lerProtudo();
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				System.out.println(
						"ID:" + produto.getId() + " Nome:" + produto.getNome() + " Senha:" + produto.getPreco()  + " quantidade:" + produto.getQuantidade());

			}

		}

	}

	//public void fazerLogin(String nome, String senha) {
		//List<Produto> produtos = lerProtudo();
		//boolean existe = false;
		//for (Produto produto : produtos) {
			//if (Produto.getNome().equals(nome) && produtos.getSenha().equals(senha)) {
				//existe = true;
				//System.out.println("Login feito com sucesso");
			//}
		//}
		
		//if (existe != true) {
			//System.err.println("Nome ou senha incorretos!");

		//}


}
