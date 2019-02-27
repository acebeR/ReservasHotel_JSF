package modelo;

import java.io.Serializable;
import javax.persistence.*;
import modelo.Diaria;

/**
 * Entity implementation class for Entity: DiariaAvulsa
 *
 */
@Entity
@DiscriminatorValue("avulsa")
public class DiariaAvulsa extends Diaria implements Serializable {
	private static final long serialVersionUID = 1L;

	private double valor;
	private Pessoa cliente;

	public DiariaAvulsa() {
		super();
	}   
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@ManyToOne
	@JoinColumn(name="cod_pessoa")
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
   
}
