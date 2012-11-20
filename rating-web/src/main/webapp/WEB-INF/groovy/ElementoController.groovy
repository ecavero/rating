import com.ecavero.rating.web.despachadores.*
import com.ecavero.rating.web.pool.*
import groovy.xml.*


def conn = ConnectionPool.obtenerConexion()
def elementos = ElementoDespachador.obtenerElementos conn

response.contentType = "text/xml"

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)

xml.elementos {
	elementos.each {
		e ->
		elemento {
			e.each {
				key, value ->
				"$key"(value)
			}
		}
	}
}

println sw.toString()
