package entities;

// Desenvolvedor herda os atributos e métodos de Funcionario e assina o contrato da interface Bonificavel
public class Desenvolvedor extends Funcionario implements Bonificavel {

	// Construtor da subclasse
	public Desenvolvedor(String nome, Double salarioBase, Cargo cargo) {
		// Repassa os dados para o construtor da classe mãe (Funcionario)
		super(nome, salarioBase, cargo);
	}
	
	// Implementação obrigatória da interface Bonificavel
	@Override
	public Double calcularBonus() {
		// Regra de negócio: o desenvolvedor recebe 10% (0.1) do salário base como bônus
		return getSalarioBase() * 0.1;
	}
	
	// Sobrescreve o método da superclasse Funcionario
	@Override
	public Double calcularSalario() {
		// Calcula o salário total somando o salário base ao bônus de 10%
		return getSalarioBase() + calcularBonus();
	}
	
	// Sobrescreve o método toString() de Funcionario
	@Override
	public String toString() {
		// Reutiliza o texto gerado por Funcionario (super.toString())
		// e adiciona o valor do bônus calculado com duas casas decimais
		return super.toString() + " | Bônus: R$ " + String.format("%.2f", calcularBonus());
	}
}
