package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.modelo.Formulario;

public interface FormularioServicio {
	
	List<Formulario> consultarModulos();
	void guardarFormulario(Formulario formulario);

}
