import com.ecavero.rating.web.despachadores.*
import com.ecavero.rating.web.pool.*
import groovy.xml.*


def conn = ConnectionPool.obtenerConexion()
def niveles = NivelDespachador.obtenerNiveles conn

response.contentType = "text/xml"

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)

xml.niveles {
	niveles.each {
		n ->
		nivel {
			n.each {
				key, value ->
				"$key"(value)
			}
		}
	}
}

println sw.toString()
