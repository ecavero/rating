import com.ecavero.rating.web.despachadores.*
import com.ecavero.rating.web.pool.*
import groovy.xml.*

def conn = ConnectionPool.obtenerConexion()
def edades = EdadDespachador.obtenerEdades conn

response.contentType = "text/xml"

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)

xml.edades {
	edades.each {
		e ->
		edad {
			e.each {
				key, value ->
				"$key"(value)
			}			
		}
	}
}

println sw.toString()
