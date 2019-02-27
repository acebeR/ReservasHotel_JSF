package modelo;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Quarto
 *
 */
@Entity
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String numero;
	private TipoDeQuarto tipo;
	private Collection<Diaria> diarias;

	public Quarto() {
		super();
	}   
	@Id
	@GeneratedValue(generator="genquarto")
	@SequenceGenerator(name="genquarto", sequenceName="quarto_codigo_seq")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Enumerated(EnumType.STRING)
	public TipoDeQuarto getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeQuarto tipo) {
		this.tipo = tipo;
	}
	@OneToMany(mappedBy="quarto")
	public Collection<Diaria> getDiarias() {
		return diarias;
	}
	public void setDiarias(Collection<Diaria> diarias) {
		this.diarias = diarias;
	}
	
}
