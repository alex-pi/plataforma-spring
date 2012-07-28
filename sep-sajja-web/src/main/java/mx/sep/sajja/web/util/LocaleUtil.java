package mx.sep.sajja.web.util;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleUtil {

    public static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
