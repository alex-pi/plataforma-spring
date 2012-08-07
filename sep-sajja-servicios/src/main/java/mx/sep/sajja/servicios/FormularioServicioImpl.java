package mx.sep.sajja.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.sep.sajja.dao.ArchivoDao;
import mx.sep.sajja.dao.FormularioDao;
import mx.sep.sajja.modelo.Archivo;
import mx.sep.sajja.modelo.Formulario;


@Service
public class FormularioServicioImpl implements FormularioServicio {

	@Autowired
	private FormularioDao formularioDao;
	
	public List<Formulario> consultarModulos() {
		return formularioDao.consultarTodos();
	}

	public Long guardarFormulario(Formulario formulario) {
		formularioDao.guardarFormulario(formulario);
		
		return formulario.getId();
	}	

}
