import com.ecavero.rating.web.despachadores.*
import com.ecavero.rating.web.pool.*
import groovy.xml.*

def conn = ConnectionPool.obtenerConexion()
def idGenero = params.idGenero as int
def niveles = params.nivel
def idElemento = params.idElemento as int
def edadMin = params.edadMin as int
def edadMax = params.edadMax as int
def ratio = RatioDespachador.obtenerRatio conn, idGenero, niveles, idElemento, edadMin, edadMax

response.contentType = "text/xml"

def sw = new StringWriter()
def xml = new MarkupBuilder(sw)

xml.ratio {
	mkp.yield ratio
}

println sw.toString()
