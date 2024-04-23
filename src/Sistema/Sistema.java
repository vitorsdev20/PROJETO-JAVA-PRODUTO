package Sistema;

import java.util.Scanner;

import Service.Menu;

public class Sistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		Menu hm = new Menu();
		int opcao = 0;
		do {
			System.out.println();
			System.out.println("1 - Criar\n2 - Editar\n3 - Deletar\n4 - Listar\n9 - Sair");
			System.out.println();
			System.out.print("Escolha: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: {
				hm.criarProduto();
				continue;
			}
			case 2:
				hm.editar();
				continue;
			case 3:
				hm.deletar();
				continue;
			case 4:
				hm.listar();
				continue;	
			case 9:
				
				System.out.println("Sistema encerrado!");
			
				break;
			default:
				System.out.println("Opção invalida...");
				break;
			}

		} while (opcao != 9);
		sc.close();
		
	}

}
