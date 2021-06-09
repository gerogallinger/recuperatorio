package recuperatorio.ejercicio02;

import recuperatorio.ejercicio02.excepciones.BusquedaProductoException;
import recuperatorio.ejercicio02.excepciones.StockINsucienteException;

import java.util.List;
import java.util.Random;

public class Database {
	
	private static List<Producto> _PRODUCTOS;
	public static void loadProductos() {
		Random r = new Random();
		for(int i=0;i<10;i++) {
			_PRODUCTOS.add(new Producto(i+1, "PRODUCTO "+i, 3, r.nextDouble()*100));
		}
	}
	
	public static Producto buscarProducto(Integer id) throws DatabaseException, BusquedaProductoException {
		for(Producto p : _PRODUCTOS) {
			if(p.getId().equals(id)) {
				return p;
			}
			else {
				BusquedaProductoException e = new BusquedaProductoException("Falló la busqueda del producto");
				throw e;

			}



		}
		return null;
	}
	
}
