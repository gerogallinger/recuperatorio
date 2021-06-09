package recuperatorio.ejercicio01;


import java.time.LocalDateTime;
import java.util.List;

public class Afiliado {

	private String nombre;
	private String apellido;
	private Integer CUIT;
	private LocalDateTime fechaNacimiento;
	private Plan plan;
	private List<Prestacion> prestaciones;

	//GETTERS AND SETERS



	public double facturar() {
		double montoTotal=0;
		//no entendi bien la consigna, asumi que el metodo tiene que calcular el monto total de todas las prestaciones que recibió

		for(int i =0;i<prestaciones.size();i++){
			double monto=0;
			if(this.prestaciones.get(i).getTipoPres().equals(TipoPrestacion.POR_COPAGO)){
				//prestaciones autorizadas
				if(this.prestaciones.get(i).isPreAprobada()){
					//tipo de afiliado P10
					if(this.plan.equals(Plan.P10)){
						monto = this.prestaciones.get(i).getPractica().getCosto() * 0.5;
					}else //tipo de plan P50
						if(this.plan.equals(Plan.P50)){
							monto = this.prestaciones.get(i).getPractica().getCosto() * 0.2;
						}
				}//si no son autorizdas
				else {
					monto = this.prestaciones.get(i).getPractica().getCosto() * 0.8;
				}

			} //prestaciones obligatorias
			else{
				if(this.plan.equals(Plan.P10)){
					monto = this.prestaciones.get(i).getPractica().getCosto() * 0.3;
				}else //tipo de plan P50
					if(this.plan.equals(Plan.P50)){
						monto = 20 ;
					}
			}
			montoTotal = montoTotal + monto;

		}
		//retorno el monto total de todas las prestaciones de este afiliado
		return montoTotal;
	}

	public void registrarPrestacion(Prestacion p ) throws Exception3PracticasMes {

		prestaciones.add(p);
		int contadorPrestaciones=0;

		for(int i =0; i<prestaciones.size();i++){
			if(p.getTipoPres().equals(TipoPrestacion.POR_COPAGO)){
				if(p.getFechaEfectuada().getMonth().equals(prestaciones.get(i).getFechaEfectuada().getMonth())){
					contadorPrestaciones++;
					//contador que se incrementa si la prestacion a agregar tiene el mismo mes que alguna de las otras
					//prestaciones que se agregaron por copago
				}

			}
		}
		if(contadorPrestaciones<=3){
			Exception3PracticasMes e = new Exception3PracticasMes("Se agregaron mas de 3 practicas por copago este mes");
			throw e;

		}




	}


}
