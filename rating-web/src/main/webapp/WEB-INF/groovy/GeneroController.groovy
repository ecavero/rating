import com.ecavero.rating.web.despachadores.*
import com.ecavero.rating.web.pool.*
import groovy.xml.*


def conn = ConnectionPool.obtenerConexion()
def generos = GeneroDespachador.obtenerGeneros conn

response.contentType = "text/xml"

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)

xml.generos {
	generos.each {
		g ->
		genero {
			g.each {
				key, value ->
				"$key"(value)
			}
		}
	}
}

println sw.toString()
