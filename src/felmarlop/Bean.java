package felmarlop;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class Bean{
	
	
	private Locale locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	private boolean checked;
	private String mes;
	private String numero;
	private String[] colores;
	
    public Locale getLocale() {
        return locale;
    }
    public String getIdioma(){
    	return locale.toString();
    }

    public void cambiarLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean b) {
		this.checked = b;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAprobadas() {
		String salida;
		if(checked){
			if(this.getIdioma().equals("es") || this.getIdioma().equals("es_ES")){
				salida = "Ya has terminado la carrera.";
			}else{
				salida = "You have finished your degree";
			}
			
		}else{
			if(this.getIdioma().equals("es") || this.getIdioma().equals("es_ES")){
				salida = "Te faltan "+numero+" asignaturas para terminar.";
			}else{
				salida = numero+" subjetcts left to finish.";
			}
		}
		return salida;
	}
	public String[] getColores() {
		return colores;
	}
	public void setColores(String[] colores) {
		this.colores = colores;
	}
}
