package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Cargo;
import entities.Desenvolvedor;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;

public class Programa {
	public static void main(String[] args) {
		// Define o padrão norte-americano para aceitar ponto (.) como separador decimal
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Boa prática: programar voltado para a interface (List) e não para a implementação (ArrayList)
		// O polimorfismo permite armazenar Gerente, Desenvolvedor e Estagiario na mesma lista de Funcionario
		List<Funcionario> funcionarioLista = new ArrayList<>();
		
		boolean entradaValida = false;
		int n = 0;

		// Loop de validação para garantir que a quantidade de funcionários seja um inteiro positivo
		while (!entradaValida) {
			try {
				System.out.print("Quantos funcionários quer registrar? ");
				n = sc.nextInt();
				
				// Regra de negócio: não permite cadastrar 0 ou números negativos
				if (n <= 0) {
					throw new IllegalArgumentException("O número de funcionários deve ser maior que zero.");
				}
				
				// Se não houve exceção, a entrada é válida e o loop pode encerrar
				entradaValida = true;

			} catch (IllegalArgumentException e) {
				// Captura o erro lançado manualmente acima
				System.out.println("Erro: " + e.getMessage());

			} catch (InputMismatchException e) {
				// Captura o erro caso o usuário digite texto ou decimais em vez de um inteiro
				System.out.println("Erro: Digite apenas números inteiros.");
				sc.nextLine(); // Limpa o buffer do Scanner para evitar loop infinito
			}
		}

		System.out.println("\nIniciando o cadastro de " + n + " funcionário(s)...");

		// Loop principal para cadastrar os 'n' funcionários
		for (int i = 1; i <= n; i++) {
			System.out.println("\n--- Dados do #" + i + " funcionário ---");
			
			// Consome a quebra de linha pendente do nextInt() anterior
			sc.nextLine(); 
			
			System.out.print("Insira o nome do funcionário: ");
			String nome = sc.nextLine();
			
			System.out.print("Insira o salário base do funcionário: ");
			double salarioBase = sc.nextDouble();
			
			System.out.println("Insira o cargo do funcionário:\n 1 - Gerente\n 2 - Desenvolvedor\n 3 - Estagiário");
			int c = sc.nextInt();

			// Instancia a subclasse correspondente ao cargo escolhido (Upcasting para Funcionario)
			switch (c) {
			case 1:
				System.out.print("Insira a quantidade de subordinados: ");
				int qtdSub = sc.nextInt();
				Funcionario g = new Gerente(nome, salarioBase, Cargo.GERENTE, qtdSub);
				funcionarioLista.add(g);
				break;
				
			case 2:
				Funcionario d = new Desenvolvedor(nome, salarioBase, Cargo.DESENVOLVEDOR);
				funcionarioLista.add(d);
				break;
				
			case 3:
				Funcionario e = new Estagiario(nome, salarioBase, Cargo.ESTAGIARIO);
				funcionarioLista.add(e);
				break;
				
			default:
				System.out.println("Cargo inválido! Tente cadastrar este funcionário novamente.");
				i--; // Decrementa o contador para repetir a iteração atual
				break;
			}
		}

		System.out.println("\n--- LISTA DE FUNCIONÁRIOS CADASTRADOS ---");
		
		// Percorre a lista usando for-each
		for (Funcionario obj : funcionarioLista) {
			// Ao passar 'obj' para o println, o Java chama automaticamente o método obj.toString()
			// Se as subclasses usarem super.toString(), os dados da classe Funcionario e da subclasse aparecerão aqui
			System.out.println(obj);
		}

		// Fecha o recurso Scanner para liberar memória
		sc.close();
	}
}
