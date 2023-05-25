package principal;

import java.util.ArrayList;

public class GestaoGastos {

	public double valorPagoMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;
        
        for(Empregado empregado : listaEmpregados) {
           
                if (empregado instanceof beneficiado) {
                	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
                	if(funcionarioComBeneficio instanceof Secretario) {
                		Secretario secretario = (Secretario) empregado;
                    	if (secretario.getMesContratacao() <= mes && secretario.getAnoContratacao() <= ano) {
                    		valorTotalPago += secretario.calculaValorPorMesEspecifico(mes, ano);
                    	}
                    	
                	}else if(funcionarioComBeneficio instanceof Vendedor) {
                		Vendedor vendedor = (Vendedor) empregado;
                    	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
                    		valorTotalPago += vendedor.calculaValorPorMesEspecifico(mes, ano);
                    	}
                	}
                }else if(empregado instanceof Gerente) {
                	Gerente gerente = (Gerente) empregado;
                	if (gerente.getMesContratacao() <= mes && gerente.getAnoContratacao() <= ano) {
                		valorTotalPago += gerente.calculaValorPorMesEspecifico(mes, ano);
                	}
                }
        }
        return valorTotalPago;

	}
	public double valorPagoEmSalario(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;
        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getMesContratacao() <= mes && secretario.getAnoContratacao() <= ano) {
                		valorTotalPago += secretario.calculaValorSomenteSalario(mes, ano);
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
                		valorTotalPago += vendedor.calculaValorSomenteSalario(mes, ano);
                	}
            	}
            }else if(empregado instanceof Gerente) {
            	Gerente gerente = (Gerente) empregado;
            	if (gerente.getMesContratacao() <= mes && gerente.getAnoContratacao() <= ano) {
            		valorTotalPago += gerente.calculaValorPorMesEspecifico(mes, ano);
            	}
            }
    }
        
        return valorTotalPago;

	}
	
	public double valorPagoEmBeneficios(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
        double valorTotalPago = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getMesContratacao() <= mes && secretario.getAnoContratacao() <= ano) {
                		valorTotalPago += secretario.calculaValorSomenteBeneficio(mes, ano);
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
                		valorTotalPago += vendedor.calculaValorSomenteBeneficio(mes, ano);
                	}
            	}
            }
        }
        return valorTotalPago;

	}
	
	public Empregado valorMaisAltoMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		Empregado empreg= null;
        double maiorValor = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getMesContratacao() <= mes && secretario.getAnoContratacao() <= ano) {
                		double valorRecebido = secretario.calculaValorPorMesEspecifico(mes, ano);
                		if(valorRecebido > maiorValor) {
                			empreg = secretario;
                			maiorValor = valorRecebido;
                		}
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
                		double valorRecebido = vendedor.calculaValorPorMesEspecifico(mes, ano);
                		if(valorRecebido > maiorValor) {
                			empreg = vendedor;
                			maiorValor = valorRecebido;
                		}
                	}
            	}
            }else if(empregado instanceof Gerente) {
            	Gerente gerente = (Gerente) empregado;
            	if (gerente.getMesContratacao() <= mes && gerente.getAnoContratacao() <= ano) {
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
	public String valorMaisAltoEmBeneficiosMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		String nome = "";
        double maiorValor = 0;

        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Secretario) {
            		Secretario secretario = (Secretario) empregado;
                	if (secretario.getMesContratacao() <= mes && secretario.getAnoContratacao() <= ano) {
                		double valorRecebido = secretario.calculaValorSomenteBeneficio(mes, ano);
                		if(valorRecebido > maiorValor) {
                			nome = secretario.getNome();
                			maiorValor = valorRecebido;
                		}
                	}
                	
            	}else if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
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
	public Empregado MaiorVendaMes(ArrayList<Empregado> listaEmpregados, int mes, int ano) {
		Empregado empreg= null;
        double maiorValor = 0;
        
        for(Empregado empregado : listaEmpregados) {
            
            if (empregado instanceof beneficiado) {
            	beneficiado funcionarioComBeneficio = (beneficiado) empregado;
            	if(funcionarioComBeneficio instanceof Vendedor) {
            		Vendedor vendedor = (Vendedor) empregado;
                	if (vendedor.getMesContratacao() <= mes && vendedor.getAnoContratacao() <= ano) {
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






