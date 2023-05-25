package principal;

public abstract class beneficiado extends Empregado{
	
	protected double valorBeneficio;

	public double getValorBeneficio() {
		return valorBeneficio;
	}

	public void setValorBeneficio(double valorBeneficio) {
		this.valorBeneficio = valorBeneficio;
	}

	public beneficiado(String nome, int mesContatacao, int anoContratacao, double valorBeneficio) {
		super(nome, mesContatacao, anoContratacao);
		this.valorBeneficio = valorBeneficio;
	}
	public beneficiado() {
		super();
		this.valorBeneficio = 0;
	}
	public abstract double calculaValorSomenteSalario();
	public abstract double calculaValorSomenteBeneficio();

}
