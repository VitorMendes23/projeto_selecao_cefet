package principal;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Secretario extends beneficiado {
	
	private static final double SALARIO_SECRETARIO  = 7000.00;
	private static final double VALOR_ANO_SERVICO  = 1000.00;
	private static final double VALOR_BENEFICO  = 0.2;


	private double valorSalarioTotalMes;

	public double getValorSalarioTotalMes() {
		return valorSalarioTotalMes;
	}

	public void setValorSalarioTotalMes(double valorSalarioTotalMes) {
		this.valorSalarioTotalMes = valorSalarioTotalMes;
	}

	public Secretario(String nome, int mesContatacao, int anoContratacao) {
		super(nome, mesContatacao, anoContratacao, VALOR_BENEFICO);
		this.valorSalarioTotalMes = calculaValorPorMes();
	}
	public Secretario() {
		super();
		this.valorSalarioTotalMes = calculaValorPorMes();
	}
	
	public double calculaValorPorMes() {
		//calcular o salario todal deste funcionario
		double valorTotal;
		LocalDate dataAtual = LocalDate.now();
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
		long anosTrabalhados = ChronoUnit.YEARS.between(dataEntrada, YearMonth.from(dataAtual));

		if(anosTrabalhados > 0)
			valorTotal = SALARIO_SECRETARIO + (VALOR_ANO_SERVICO * anosTrabalhados);
		else
			valorTotal = SALARIO_SECRETARIO;
		
		valorTotal = valorTotal + (valorTotal*VALOR_BENEFICO);
		
		return valorTotal;

	}
	public double calculaValorPorMesEspecifico(int mes, int ano) {
		//calcular o salario todal deste funcionario
		double valorTotal;
        YearMonth dataParaCalculo = YearMonth.of(ano, mes);
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
        long anos = dataEntrada.until(dataParaCalculo, ChronoUnit.YEARS);

		if(anos > 0)
			valorTotal = SALARIO_SECRETARIO+ (VALOR_ANO_SERVICO * anos);
		else
			valorTotal = SALARIO_SECRETARIO;
		
		valorTotal = valorTotal + (valorTotal*VALOR_BENEFICO);

		
		return valorTotal;
		
	}
	public double calculaValorSomenteSalario(int mes, int ano) {
		double valorTotal;
        YearMonth dataParaCalculo = YearMonth.of(ano, mes);
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
        long anos = dataEntrada.until(dataParaCalculo, ChronoUnit.YEARS);

		if(anos > 0)
			valorTotal = SALARIO_SECRETARIO+ (VALOR_ANO_SERVICO * anos);
		else
			valorTotal = SALARIO_SECRETARIO;
		
		
		return valorTotal;
		
	}
	public double calculaValorSomenteBeneficio(int mes, int ano) {
		//calcular o beneficio todal deste funcionario
		double valorTotal = calculaValorPorMesEspecifico(mes, ano);
		double valorSomenteSalario = calculaValorSomenteSalario(mes, ano);

		double valorFinal = valorTotal - valorSomenteSalario;
		
		return valorFinal;
		
	}

	@Override
	public double calculaValorSomenteSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculaValorSomenteBeneficio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculaValorPorMesEspecifico() {
		// TODO Auto-generated method stub
		return 0;
	}
}
