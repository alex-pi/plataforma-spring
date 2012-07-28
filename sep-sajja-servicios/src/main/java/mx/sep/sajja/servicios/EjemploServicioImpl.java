package mx.sep.sajja.servicios;

import mx.sep.sajja.servicios.util.ErrorNegocio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EjemploServicioImpl implements EjemploServicio {

	private static final Logger log = LoggerFactory.getLogger(EjemploServicioImpl.class);
	
	public void ejemploManejoErrorNegocio(){
		throw new ErrorNegocio("Aqui se explica lo que salió mal con la lógica de negocio.");
	}

}
