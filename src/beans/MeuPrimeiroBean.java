package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="meuPrimeiroBean")
public class MeuPrimeiroBean {
	private String ola = "Ola amigos";
	
	public String getOla() {
		return ola;
	}
}
