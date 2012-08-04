package mx.sep.sajja.web.util;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Calse de de utilería para simplificar el trabajo con objetos Locale
 * dentro de la aplicación.
 * 
 * @author Alejandro Pimentel
 *
 */
public class LocaleUtil {

	/**
	 * Obtiene el objeto Locale obtenido por Spring según el 
	 * {@link LocaleResolver} que se configure en el contexto web.
	 * 
	 * @return
	 */
    public static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
