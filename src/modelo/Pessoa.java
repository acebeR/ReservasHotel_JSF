package modelo;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private Endereco endereco;
	private Collection<Reserva> reservas;
	private Collection<DiariaAvulsa> diariasAvulsas;

	public Pessoa() {
		super();
	}
	
	@Id
	@GeneratedValue(generator="genpessoa")
	@SequenceGenerator(sequenceName="pessoa_codigo_seq", name="genpessoa")
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Column(nullable=false, unique=true)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(mappedBy="cliente")
	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}

	@OneToMany(mappedBy="cliente")
	public Collection<DiariaAvulsa> getDiariasAvulsas() {
		return diariasAvulsas;
	}

	public void setDiariasAvulsas(Collection<DiariaAvulsa> diariasAvulsas) {
		this.diariasAvulsas = diariasAvulsas;
	}
   
}
