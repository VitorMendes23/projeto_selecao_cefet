package principal;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Vendedor extends beneficiado{
	private static final double SALARIO_VENDEDOR  = 12000.00;
	private static final double VALOR_ANO_SERVICO  = 1800.00;
	private static final double VALOR_BENEFICO  = 0.3;


	private double valorSalarioTotalMes;
	private Map<String, Double> vendas;  //armazana o valor das vendas, tendo a data(mes/ano) como chave

	
	public double getValorSalarioTotalMes() {
		return valorSalarioTotalMes;
	}

	public void setValorSalarioTotalMes(double valorSalarioTotalMes) {
		this.valorSalarioTotalMes = valorSalarioTotalMes;
	}
	
	public void adicionaVendaMes(String mesAno, double valor) {
		this.vendas.put(mesAno, valor);
	}
	public Map<String, Double> getVendas() {
		return vendas;
	}

	public void setVendas(Map<String, Double> vendas) {
		this.vendas = vendas;
	}
	

	public Vendedor(String nome, int mesContatacao, int anoContratacao) {
		super(nome, mesContatacao, anoContratacao, VALOR_BENEFICO);
		this.valorSalarioTotalMes = calculaValorPorMes();
		this.vendas = new HashMap<>();
	}
	public Vendedor() {
		super();
		this.valorSalarioTotalMes = calculaValorPorMes();
		this.vendas = new HashMap<>();
	}
	
	
	public double calculaValorPorMes() {
		//calcular o salario todal deste funcionario
		double valorTotal;
		LocalDate dataAtual = LocalDate.now();
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
		long anosTrabalhados = ChronoUnit.YEARS.between(dataEntrada, YearMonth.from(dataAtual));

		if(anosTrabalhados > 0)
			valorTotal = SALARIO_VENDEDOR + (VALOR_ANO_SERVICO * anosTrabalhados);
		else
			valorTotal = SALARIO_VENDEDOR;
		

		return valorTotal;
		
	}
	public double calculaValorPorMesEspecifico(int mes, int ano) {
		//calcular o salario todal deste funcionario em um mes especifico
		double valorTotal;
        YearMonth dataParaCalculo = YearMonth.of(ano, mes);
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
        long anos = dataEntrada.until(dataParaCalculo, ChronoUnit.YEARS);

		if(anos > 0)
			valorTotal = SALARIO_VENDEDOR + (VALOR_ANO_SERVICO * anos);
		else
			valorTotal = SALARIO_VENDEDOR;
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String dataFormatada = dataParaCalculo.format(formatter);
		
        double valorTotalVenda = (this.vendas.get(dataFormatada) * VALOR_BENEFICO);
		
		valorTotal = valorTotal + valorTotalVenda;

		return valorTotal;
		
	}

	public double calculaValorSomenteSalario(int mes, int ano) {
		double valorTotal;
        YearMonth dataParaCalculo = YearMonth.of(ano, mes);
		YearMonth dataEntrada = YearMonth.of(this.anoContratacao, this.mesContratacao);
        long anos = dataEntrada.until(dataParaCalculo, ChronoUnit.YEARS);

		if(anos > 0)
			valorTotal = SALARIO_VENDEDOR + (VALOR_ANO_SERVICO * anos);
		else
			valorTotal = SALARIO_VENDEDOR;
		
		
		return valorTotal;
		
	}
	public double calculaValorSomenteBeneficio(int mes, int ano) {
		//calcular o beneficio todal deste funcionario
		double valorTotal = calculaValorPorMesEspecifico(mes, ano);
		double valorSomenteSalario = calculaValorSomenteSalario(mes, ano);

		double valorFinal = valorTotal - valorSomenteSalario;
		
		return valorFinal;
		
	}
	public double calculaValorSomenteVendaMes(int mes, int ano) {
		//calcular venda desde funcionario
        YearMonth dataParaCalculo = YearMonth.of(ano, mes);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        String dataFormatada = dataParaCalculo.format(formatter);
		
        double valorTotalVenda = this.vendas.get(dataFormatada);
		
		return valorTotalVenda;
		
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




