package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Funcionario> f = new ArrayList<>();

		System.out.print("Quantos funcionarios quer registrar? ");
		int n = sc.nextInt();
		

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.print("Insira o nome do funcionário: ");
			String nome = sc.nextLine();
			System.out.print("Insira o salário base do funcionário: ");
			double salarioBase = sc.nextDouble();
			System.out.println("Insira o cargo do funcionário \n 1 - Gerente \n 2 - Desenvolvedor \n 3 - Estágiario");
			int c = sc.nextInt();
			switch(c) {
			case 1:
				System.out.print("Insira a quantidade de subordinados: ");
				int qtdSub = sc.nextInt();
				Funcionario g = new Gerente(nome, salarioBase, Cargo.GERENTE,qtdSub);
				f.add(g);
				break;
			case 2:
				Funcionario d = new Desenvolvedor(nome, salarioBase, Cargo.DESENVOLVEDOR);
				f.add(d);
				break;
			case 3:
				Funcionario e = new Estagiario(nome, salarioBase, Cargo.ESTAGIARIO);
				f.add(e);
			}
			
		}
		for(Funcionario obj : f) {
			System.out.println(obj);
		}
		sc.close();
	}
}
