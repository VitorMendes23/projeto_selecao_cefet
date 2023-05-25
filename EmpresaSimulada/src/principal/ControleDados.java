package principal;

import java.util.ArrayList;

public class ControleDados {
	
	private ArrayList<Empregado> listaEmpregados;

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

}
