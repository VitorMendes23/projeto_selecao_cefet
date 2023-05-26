package principal;

import java.util.ArrayList;

public class ControleDados {
	
	private ArrayList<Empregado> listaEmpregados; //"armazena" todos os funcionarios

	public ArrayList<Empregado> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(ArrayList<Empregado> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}

	public ControleDados(ArrayList<Empregado> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}
	public ControleDados() {
		this.listaEmpregados = new ArrayList<>();
	}
	
	public void adicionaEmpregado(Empregado novoEmpregado) {
		this.listaEmpregados.add(novoEmpregado);
	}
	public void removeEmpregado(Empregado novoEmpregado) {
		this.listaEmpregados.remove(novoEmpregado);
	}

	public Empregado pesquisaEmpregadoPeloNome(String nome) {
		
		for(Empregado empreg : this.listaEmpregados) {
			if (empreg instanceof beneficiado) {
		    	beneficiado funcionarioComBeneficio = (beneficiado) empreg;
		    	if(funcionarioComBeneficio instanceof Secretario) {
		    		Secretario secretario = (Secretario) empreg;
					if(secretario.getNome().equals(nome)) {
						return secretario;
					}
		        	
		    	}else if(funcionarioComBeneficio instanceof Vendedor) {
		    		Vendedor vendedor = (Vendedor) empreg;
					if(vendedor.getNome().equals(nome)) {
						return vendedor;
					}
		    	}
		    }else if(empreg instanceof Gerente) {
		    	Gerente gerente = (Gerente) empreg;
				if(gerente.getNome().equals(nome)) {
					return gerente;
				}
		    }
		}
		
		return null;
	}
}
	
