package entities;

public abstract class Funcionario {
	private String nome;
	private Double salarioBase;
	private Cargo cargo;
	
	// Inicializa os atributos comuns a todos os tipos de funcionários
	public Funcionario(String nome, Double salarioBase, Cargo cargo) {
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	// Obriga cada subclasse (Gerente, Desenvolvedor, Estagiario) a implementar sua própria regra de cálculo
	public abstract Double calcularSalario();
	
	// Monta o texto base exibido quando o objeto é impresso ou quando super.toString() é chamado nas subclasses
	// Chama calcularSalario() da própria subclasse em tempo de execução para exibir o valor já atualizado
	@Override
	public String toString() {
		return cargo + " " + nome + " - Salário: R$" + String.format("%.2f", calcularSalario());
	}
}
