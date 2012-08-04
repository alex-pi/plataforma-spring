package test.mx.sep.sajja.dao;

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
 * 
 * @author Alejandro Pimentel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mx/sep/sajja/datos/datos-mybatis-config.xml")
@ActiveProfiles("testing")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public abstract class BaseDaoTest {

}
