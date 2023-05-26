package principal;

import java.util.ArrayList;

public class GestaoGastos { //classe que implementa todos os metodos de calculos que abrangem todo o sistema

	public static double valorPagoMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;
        
        for(Empregado empregado : listaEmpregados) {
           
                if (empregado instanceof beneficiado) {
                	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
                	if(funcionarioComBeneficio instanceof Secretario) {
                		Secretario secretario = (Secretario) empregado;
                    	if (secretario.getAnoContratacao() < ano || (secretario.getAnoContratacao() == ano && secretario.getMesContratacao() <= mes)) {
                    		valorTotalPago += secretario.calculaValorPorMesEspecifico(mes, ano);
                    	}
                    	
                	}else if(funcionarioComBeneficio instanceof Vendedor) {
                		Vendedor vendedor = (Vendedor) empregado;
                    	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                    		valorTotalPago += vendedor.calculaValorPorMesEspecifico(mes, ano);
                    	}
                	}
                }else if(empregado instanceof Gerente) {
                	Gerente gerente = (Gerente) empregado;
                	if (gerente.getAnoContratacao() < ano || (gerente.getAnoContratacao() == ano && gerente.getMesContratacao() <= mes)) {
                		valorTotalPago += gerente.calculaValorPorMesEspecifico(mes, ano);
                	}
                }
        }
        return valorTotalPago;

	}
	public static double valorPagoEmSalario(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;
        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getAnoContratacao() < ano || (secretario.getAnoContratacao() == ano && secretario.getMesContratacao() <= mes)) {
                		valorTotalPago += secretario.calculaValorSomenteSalario(mes, ano);
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                		valorTotalPago += vendedor.calculaValorSomenteSalario(mes, ano);
                	}
            	}
            }else if(empregado instanceof Gerente) {
            	Gerente gerente = (Gerente) empregado;
            	if (gerente.getAnoContratacao() < ano || (gerente.getAnoContratacao() == ano && gerente.getMesContratacao() <= mes)) {
            		valorTotalPago += gerente.calculaValorPorMesEspecifico(mes, ano);
            	}
            }
    }
        
        return valorTotalPago;

	}
	
	public static double valorPagoEmBeneficios(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getAnoContratacao() < ano || (secretario.getAnoContratacao() == ano && secretario.getMesContratacao() <= mes)) {
                		valorTotalPago += secretario.calculaValorSomenteBeneficio(mes, ano);
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                		valorTotalPago += vendedor.calculaValorSomenteBeneficio(mes, ano);
                	}
            	}
            }
        }
        return valorTotalPago;

	}
	
	public static Empregado valorMaisAltoMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		Empregado empreg= null;
        double maiorValor = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getAnoContratacao() < ano || (secretario.getAnoContratacao() == ano && secretario.getMesContratacao() <= mes)) {
                		double valorRecebido = secretario.calculaValorPorMesEspecifico(mes, ano);
                		if(valorRecebido > maiorValor) {
                			empreg = secretario;
                			maiorValor = valorRecebido;
                		}
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                		double valorRecebido = vendedor.calculaValorPorMesEspecifico(mes, ano);
                		if(valorRecebido > maiorValor) {
                			empreg = vendedor;
                			maiorValor = valorRecebido;
                		}
                	}
            	}
            }else if(empregado instanceof Gerente) {
            	Gerente gerente = (Gerente) empregado;
            	if (gerente.getAnoContratacao() < ano || (gerente.getAnoContratacao() == ano && gerente.getMesContratacao() <= mes)) {
            		double valorRecebido = gerente.calculaValorPorMesEspecifico(mes, ano);
            		if(valorRecebido > maiorValor) {
            			empreg = gerente;
            			maiorValor = valorRecebido;
            		}
            	}
            }
    }
		return empreg;
	}
	public static String valorMaisAltoEmBeneficiosMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		String nome = "";
        double maiorValor = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getAnoContratacao() < ano || (secretario.getAnoContratacao() == ano && secretario.getMesContratacao() <= mes)) {
                		double valorRecebido = secretario.calculaValorSomenteBeneficio(mes, ano);
                		if(valorRecebido > maiorValor) {
                			nome = secretario.getNome();
                			maiorValor = valorRecebido;
                		}
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                		double valorRecebido = vendedor.calculaValorSomenteBeneficio(mes, ano);
                		if(valorRecebido > maiorValor) {
                			nome = vendedor.getNome();
                			maiorValor = valorRecebido;
                		}
                	}
            	}
            }
        }
		
		return nome;
	}
	public static Empregado MaiorVendaMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		Empregado empreg= null;
        double maiorValor = 0;
        
        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getAnoContratacao() < ano || (vendedor.getAnoContratacao() == ano && vendedor.getMesContratacao() <= mes)) {
                		double valorRecebido = vendedor.calculaValorSomenteVendaMes(mes, ano);
                		if(valorRecebido > maiorValor) {
                			empreg = vendedor;
                			maiorValor = valorRecebido;
                		}
                	}
                	
            	}
            }
        }
        
        return empreg;
	}
}






