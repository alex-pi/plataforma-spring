package mx.sep.sajja.servicios;

import java.util.List;

import mx.sep.sajja.modelo.Escuela;
import mx.sep.sajja.servicios.util.CatalogosEnum;

public interface CatalogosServicio {

	List<Escuela> consultarEscuelas(CatalogosEnum escuelas);
}
