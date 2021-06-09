package recuperatorio.ejercicio01;

import java.time.LocalDateTime;

public class Prestacion {

    private LocalDateTime fechaEfectuada;
    private boolean preAprobada;
    private Afiliado afiliado;
    private TipoPrestacion tipoPres;
    private Practica practica;

    //GETTERS AND SETERS

    public LocalDateTime getFechaEfectuada() {
        return fechaEfectuada;
    }

    public void setFechaEfectuada(LocalDateTime fechaEfectuada) {
        this.fechaEfectuada = fechaEfectuada;
    }

    public boolean isPreAprobada() {
        return preAprobada;
    }

    public void setPreAprobada(boolean preAprobada) {
        this.preAprobada = preAprobada;
    }

    public TipoPrestacion getTipoPres() {
        return tipoPres;
    }

    public void setTipoPres(TipoPrestacion tipoPres) {
        this.tipoPres = tipoPres;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }
}
