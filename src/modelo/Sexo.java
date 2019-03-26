package modelo;

public enum Sexo {
	M("Masculino"), F("Feminino");
	
	private String nome;
	
	private Sexo (String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
