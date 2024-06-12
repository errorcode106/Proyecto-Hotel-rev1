import java.time.LocalDate;
import java.util.List;

public class HabitacionSimple extends HabitacionGeneral<ComodidadBasica> {
    public HabitacionSimple(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        GestorDisponibilidad gestor = App.getGestor();
        return gestor.contarReservas(this, fechaInicio, fechaFin) < 4;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precioTotal = this.precio;
        for (ComodidadBasica comodidad : comodidades) {
            precioTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        return "HabitacionSimple {" + super.toString() + "}";
    }
}