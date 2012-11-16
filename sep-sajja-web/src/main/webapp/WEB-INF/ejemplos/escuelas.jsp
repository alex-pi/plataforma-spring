<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<pre>
Este ejemplo muestra el uso del caché por anotaciones manejado por Spring. Este tipo de cache
es muy útil principalmente cuando se obtiene información de medios que de manera natural no usan
un caché por sí mismos.

Por ejemplo, si se requiere leer información de archivos que prácticamente no cambia, este tipo de 
implementación de cache resulta muy útil y fácil de implementar.

Principalmente debe aprender el uso de las anotaciones:

@Cacheable
@CachePut
@CacheEvict

Otra ventaja de esta implementación es que se puede configurar el caché en la capa aplicativa que más le acomode,
para este ejemplo se configura en el módulo de servicios, dentro del archivo:

src/main/resources/mx/sep/sajja/servicios/config/servicios-config.xml

Se usa ehcache el cual se configura en el clásico archivo: ehcache.xml

Ehcache brinda un API para acceso a los caches configurados, muestra de esto es la clase de utilería para tests que
se incluye como demo:

CacheTestHelper.java

</pre>