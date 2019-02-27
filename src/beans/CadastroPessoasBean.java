package beans;

import modelo.Pessoa;
import modelo.PessoaFisica;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="cadastroPessoasBean")
@SessionScoped
public class CadastroPessoasBean {

	private Pessoa pessoaSelecionada;
	private Collection<Pessoa> lista;
	
	public CadastroPessoasBean() {
		pessoaSelecionada = new PessoaFisica();
		lista = new ArrayList<Pessoa>();
		
		for(int x = 0; x < 10;x++) {
			Pessoa p = new PessoaFisica();
			p.setNome(String.format("Fulano %02d", x));
			p.setEmail(String.format("Fulano%02d@teste.com", x));
			p.setTelefone(String.format("9999.88%02d", x));
			
			lista.add(p);
		}
	}

	public void salvar() {
		if(!lista.contains(pessoaSelecionada)) {
			lista.add(pessoaSelecionada);
		}
	}
	public String cancelar() {
		return "primeiro.jsf";
	}
	public void excluir() {
		lista.remove(pessoaSelecionada);
		pessoaSelecionada = new PessoaFisica();
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}

	public Collection<Pessoa> getLista() {
		return lista;
	}

	public void setLista(Collection<Pessoa> lista) {
		this.lista = lista;
	}
	
	
}
