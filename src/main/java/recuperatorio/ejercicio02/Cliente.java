package recuperatorio.ejercicio02;

import recuperatorio.ejercicio02.excepciones.BusquedaProductoException;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private Integer id;
	private List<Pedido> pedidos;
	private Integer maximoProductosHabilitados;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void crearPedido(Integer nroPedido) {
		if(this.pedidos==null)this.pedidos = new ArrayList<Pedido>();
		this.pedidos.add(new Pedido(nroPedido));
	}
	
	public void agregarProducto(Integer nroPedido, Integer idProducto,Integer cantidad) throws DatabaseException, BusquedaProductoException {

		Producto p = Database.buscarProducto(idProducto);
		// verificar si el stock existente alcanza para agregarlo al pedido				

		// verificar si el cliente cumple la condicion pedida para agregar el producto
		Pedido pedido = this.buscarPorNro(nroPedido);
		pedido.addDetalle(p, cantidad);


		if(getCantProductosDisponibles()>0){
			//si el cliente no supera el maximo habilitado se puede agregar el producto al pedido
			pedidos.add(pedido);
		}

	}
	
	public Pedido buscarPorNro(Integer nroPedido) {
		for(Pedido p : this.pedidos) {
			if(p.getNroPedido().equals(nroPedido)) return p;
		}
		return null;
	}
	
	public List<Producto> productosMontoMayor(Double monto){
		return null;
	}
	
	public Double compraPromedio() {
		return 0.0;
	}

	public Integer getCantProductosDisponibles(){
		Integer totalProductosPedidos=0;

		for(int i = 0; i<pedidos.size();i++){
			for(int j = 0; j<pedidos.get(i).getDetalles().size();j++){
				totalProductosPedidos  += pedidos.get(i).getDetalles().get(j).getCantidad();
				//obtengo la cantidad de productos pedidos
			}
		}
		//si el numero que retorna es positivo significa que el total de productos pedidos no supera el maximo
		//si retorna numero negativo significa que el total de productos pedidos es mayor al maximo que tiene habilitado
		return maximoProductosHabilitados - totalProductosPedidos;
	}

	
}
