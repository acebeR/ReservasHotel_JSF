package beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class GeralBean {
	private Locale locale;
	private List<Locale> localesDisponiveis;
	
	public GeralBean() {
		localesDisponiveis = new ArrayList<Locale>();
		
		Iterator<Locale> it = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		
		while (it.hasNext()) {
			localesDisponiveis.add(it.next());
		}
		
		// Atribuindo o locale sugerido pelo browser
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		
		// Atribuindo o locale default do faces-config
		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
		
		// Atribuindo o locale calculado pelo UIViewRoot
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}
	
	public void atualizarLocale(ActionEvent e) {
		Locale l = (Locale) e.getComponent().getAttributes().get("locale");
		if (l != null) {
			locale = l;
		}
		
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public List<Locale> getLocalesDisponiveis() {
		return localesDisponiveis;
	}
	public void setLocalesDisponiveis(List<Locale> localesDisponiveis) {
		this.localesDisponiveis = localesDisponiveis;
	}

	@Override
	public String toString() {
		return "GeralBean [locale=" + locale + ", localesDisponiveis="
				+ localesDisponiveis + "]";
	}
}
