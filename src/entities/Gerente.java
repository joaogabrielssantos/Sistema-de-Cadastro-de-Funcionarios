package entities;

// Gerente herda de Funcionario (é um funcionário) e implementa Bonificavel (tem direito a bônus)
public class Gerente extends Funcionario implements Bonificavel {
	
	// Atributo específico da classe Gerente (quantidade de subordinados)
	private Integer qtdSub;

	// Construtor da subclasse
	public Gerente(String nome, Double salarioBase, Cargo cargo, Integer qtdSub) {
		// Repassa os atributos comuns para o construtor da superclasse Funcionario
		super(nome, salarioBase, cargo);
		this.qtdSub = qtdSub;
	}

	// Getter e Setter para o atributo específico
	public Integer getQtdSub() {
		return qtdSub;
	}

	public void setQtdSub(Integer qtdSub) {
		this.qtdSub = qtdSub;
	}
	
	// Implementação obrigatória do método definido na interface Bonificavel
	@Override
	public Double calcularBonus() {
		// Regra de negócio: o gerente ganha R$ 100,00 de bônus por cada subordinado
		return qtdSub * 100.0;
	}
	
	// Sobrescreve o método da classe Funcionario
	@Override
	public Double calcularSalario() {
		// Soma o salário base (herdado) com o bônus calculado acima
		return getSalarioBase() + calcularBonus();
	}
	
	// Sobrescreve o método toString() da classe Funcionario
	@Override
	public String toString() {
		// Chama super.toString() para obter os dados base de Funcionario
		// e concatena o valor do bônus formatado com duas casas decimais
		return super.toString() + " | Bônus: R$ " + String.format("%.2f", calcularBonus());
	}
}
