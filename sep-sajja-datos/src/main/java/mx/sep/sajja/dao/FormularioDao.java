package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.Formulario;

public interface FormularioDao {
	
	List<Formulario> consultarTodos();
	void guardarFormulario(Formulario formulario);

}
