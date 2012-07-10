package test.mx.sep.sajja.servicios;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mx/sep/sajja/servicios/config/application-context-test.xml")
@ActiveProfiles("desarrollo")
public abstract class BaseServicioTest {

}
