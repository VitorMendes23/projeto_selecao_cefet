package principal;

public abstract class Empregado {
	
	protected String nome;
	protected int mesContratacao;
	protected int anoContratacao;
	//protected double valorSalarioTotalMes;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMesContratacao() {
		return mesContratacao;
	}
	public void setMesContatacao(int mesContatacao) {
		this.mesContratacao = mesContatacao;
	}
	public int getAnoContratacao() {
		return anoContratacao;
	}
	public void setAnoContratacao(int anoContratacao) {
		this.anoContratacao = anoContratacao;
	}
//	public double getValorSalarioTotalMes() {
//		return valorSalarioTotalMes;
//	}
//	public void setValorSalarioTotalMes(double valorSalarioTotalMes) {
//		this.valorSalarioTotalMes = valorSalarioTotalMes;
//	}
	
	public Empregado(String nome, int mesContatacao, int anoContratacao) {
		this.nome = nome;
		this.mesContratacao = mesContatacao;
		this.anoContratacao = anoContratacao;
//		this.valorSalarioTotalMes = valorSalarioTotalMes;
	}
	public Empregado() {
		this.nome = "";
		this.mesContratacao = 0;
		this.anoContratacao = 0;
	}
	
	public abstract double calculaValorPorMes();
	public abstract double calculaValorPorMesEspecifico();

	
}
