package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.Formulario;

public interface FormularioDao {
	
	List<Formulario> consultarTodos();
	Formulario consultarFormulario(Long id);
	Integer guardarFormulario(Formulario formulario);

}
