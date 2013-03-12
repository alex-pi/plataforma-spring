package mx.sep.sajja.servicios;

import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.modelo.Usuario;

public interface EjemploServicio {

	void ejemploMensajeErrorNegocio();
	
	void ejemploCodigoMensajeErrorNegocio();

    void transaccionAtomica(Escuela escuela, Usuario usuario, String nombreEscuela);

    void transaccionRegistroParcial(Escuela escuela, String nombreEscuela);
}
