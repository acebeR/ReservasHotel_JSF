package conversores;

import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="conversorLocale")
public class LocaleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		String[] dados = value.split("_");
		Locale l = null;
		if (dados.length == 2) l = new Locale(dados[0],dados[1]);
		else l = new Locale(value);
		
		return l;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value.toString();
	}

}
