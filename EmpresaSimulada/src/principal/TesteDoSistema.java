package principal;

public class TesteDoSistema {
	
	public static void main(String[] args) {
		
		ControleDados controleDados = new ControleDados();
		
		//adicionando os funcionarios no sistema 
		
		controleDados.adicionaEmpregado(new Secretario("Jorge Carvalho", 01, 2018 )); //String nome, int mesContatacao, int anoContratacao
		controleDados.adicionaEmpregado(new Secretario("Maria Souza", 12, 2015) );
		controleDados.adicionaEmpregado(new Vendedor("Ana Souza", 12, 2021) );
		controleDados.adicionaEmpregado(new Vendedor("João Mendes", 12, 2021) );
		controleDados.adicionaEmpregado(new Gerente("Juliana Alves", 07, 2017) );
		controleDados.adicionaEmpregado(new Gerente("Bento Albino", 03, 2014) );

		//adicionando o histórico de vendas dos vendedores
		
		try {
			Vendedor AnaSouza = (Vendedor) controleDados.pesquisaEmpregadoPeloNome("Ana Souza");
			
			AnaSouza.adicionaVendaMes("12/2021", 5200);
			AnaSouza.adicionaVendaMes("01/2022", 4000);
			AnaSouza.adicionaVendaMes("02/2022", 4200);
			AnaSouza.adicionaVendaMes("03/2022", 5850);
			AnaSouza.adicionaVendaMes("04/2022", 7000);

			Vendedor JoaoMendes = (Vendedor) controleDados.pesquisaEmpregadoPeloNome("João Mendes");

			JoaoMendes.adicionaVendaMes("12/2021", 3400);
			JoaoMendes.adicionaVendaMes("01/2022", 7700);
			JoaoMendes.adicionaVendaMes("02/2022", 5000);
			JoaoMendes.adicionaVendaMes("03/2022", 5900);
			JoaoMendes.adicionaVendaMes("04/2022", 6500);
			
		} catch (ClassCastException e) {
		    // Tratamento para a exceção de ClassCastException
			e.printStackTrace();
		} catch (NullPointerException e) {
		    // Tratamento para a exceção de NullPointerException
			e.printStackTrace();	
		}

		
		//Exibindo as informações e testando se todos os metodos funcionaram como o esperado
		System.out.print("Bem vindo ao sistema de controle de gastos da empresa! \n\n" );
		
		for(Empregado empreg : controleDados.getListaEmpregados()) {
			if (empreg instanceof beneficiado) {
		    	beneficiado funcionarioComBeneficio = (beneficiado) empreg;
		    	if(funcionarioComBeneficio instanceof Secretario) {
		    		Secretario secretario = (Secretario) empreg;
		    		System.out.println("O(a) secretario(a): " + secretario.getNome() +" contratado em " + secretario.mesContratacao +"/"+ secretario.anoContratacao 
		    				+ " recebe o valor de  " + secretario.calculaValorPorMesEspecifico(04, 2022)+ " reais no mes de abril/2022! \n" );
		        	
		    	}else if(funcionarioComBeneficio instanceof Vendedor) {
		    		Vendedor vendedor = (Vendedor) empreg;
		    		System.out.println("O(a) vendedor(a): " + vendedor.getNome() +" contratado em " + vendedor.mesContratacao +"/"+ vendedor.anoContratacao 
		    				+ " recebe o valor de  " + vendedor.calculaValorPorMesEspecifico(04, 2022)+ " reais no mes de abril/2022! \n" );
		    	}
		    }else if(empreg instanceof Gerente) {
		    	Gerente gerente = (Gerente) empreg;
	    		System.out.println("O(a) gerente(a): " + gerente.getNome() +" contratado em " + gerente.mesContratacao +"/"+ gerente.anoContratacao 
	    				+ " recebe o valor de  " + gerente.calculaValorPorMesEspecifico(04, 2022)+ " reais no mes de abril/2022! \n" );
		    }
		}	
		System.out.println("O gasto total no mes de abril/2022 foi de : " + GestaoGastos.valorPagoMes(controleDados.getListaEmpregados(), 04, 2022));	
		
		System.out.println("O gasto somente com salários no mes de abril/2022 foi de : " + GestaoGastos.valorPagoEmSalario(controleDados.getListaEmpregados(), 04, 2022));	

		System.out.println("O gasto somente com beneficios no mes de abril/2022 foi de : " + GestaoGastos.valorPagoEmBeneficios(controleDados.getListaEmpregados(), 04, 2022));	

		System.out.println("O funcionario(a) que recebeu o maior valor no mes de abril/2022 foi : " + GestaoGastos.valorMaisAltoMes(controleDados.getListaEmpregados(), 04, 2022).getNome());	

		System.out.println("O funcionario(a) que recebeu o valor mais alto em beneficios de abril/2022 foi : " + GestaoGastos.valorMaisAltoEmBeneficiosMes(controleDados.getListaEmpregados(), 04, 2022));	

		System.out.println("O vendedor(a) que mais vendeu em abril/2022 foi : " + GestaoGastos.MaiorVendaMes(controleDados.getListaEmpregados(), 04, 2022).getNome());	

		System.out.print("\n\n OBS: para verificar os valores de outros meses basta alterar os parametros! \n\n" );

	}

}
