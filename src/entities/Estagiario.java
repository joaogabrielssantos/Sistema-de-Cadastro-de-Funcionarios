package entities;

// A classe Estagiario herda atributos e métodos da classe mãe (superclasse) Funcionario
public class Estagiario extends Funcionario {

	// Construtor da subclasse Estagiario
	public Estagiario(String nome, Double salarioBase, Cargo cargo) {
		// Chama o construtor da superclasse (Funcionario) para inicializar os atributos herdados
		super(nome, salarioBase, cargo);
	}
	
	// Sobrescreve o método abstrato/genérico da classe Funcionario
	@Override
	public Double calcularSalario() {
		// Regra de negócio do estagiário: recebe apenas o salário base, sem bônus ou acréscimos
		return getSalarioBase();
	}

	// Sobrescreve o toString() da classe Funcionario
	@Override
	public String toString() {
		return super.toString();
	}
}
