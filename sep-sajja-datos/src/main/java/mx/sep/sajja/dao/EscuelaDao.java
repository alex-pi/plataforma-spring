package mx.sep.sajja.dao;

import java.util.List;

import mx.sep.sajja.modelo.Escuela;

/**
 * 
 * @author Alejandro Pimentel
 *
 */
public interface EscuelaDao {

	List<Escuela> consultarTodos();
	List<Escuela> consultarTodosCached();
    Integer guardar(Escuela escuela);
    Integer modificarPorNombre(Escuela escuela);
    List<Escuela> consultarPorAntiguedad(Integer antiguedad);
}
