package test.mx.sep.sajja.servicios;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esta clase establece por medio de anotaciones la configuración para ejecutar los tests.
 * 
 * - Primero se indica que JUnit será el encargado de ejecutar las mismas y evaluar los resultados.
 * - Después el archivo que contiene la configuración de spring para iniciar el contendor y sus beans.
 * - Se activa el profile con el que se debe iniciar el contenedor.
 * - Se indica el nombre del bean que se encargará de manejar la transacción. Además para el caso de los tests, por definición
 *   siempre debemos regresar al estado de los datos en que iniciamos, así que al terminar cada test se hará rollback.
 * - Por último indicamos con @Transactional que todas los test, a menos que indiquemos lo contrario, iniciarán una transacción.
 * 
 * @author Alejandro Pimentel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mx/sep/sajja/servicios/config/application-context-test.xml")
@ActiveProfiles("testing")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public abstract class BaseServicioTest {

}
