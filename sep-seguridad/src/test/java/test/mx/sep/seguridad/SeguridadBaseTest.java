package test.mx.sep.seguridad;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mx/sep/seguridad/seguridad-config.xml")
@ActiveProfiles("desarrollo")
public abstract class SeguridadBaseTest {

}
