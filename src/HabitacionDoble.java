import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;


public class HabitacionDoble extends HabitacionGeneral<ComodidadBasica> {
    public HabitacionDoble(String tipo, double precio, List<ComodidadBasica> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        GestorDisponibilidad gestor = App.getGestor();
        return gestor.contarReservas(this, fechaInicio, fechaFin) == 0 && ChronoUnit.DAYS.between(fechaInicio, fechaFin) >= 2;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precioTotal = this.precio;
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (dias > 3) {
            precioTotal *= 0.90; 
        }
        for (ComodidadBasica comodidad : comodidades) {
            precioTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        return "HabitacionDoble {" + super.toString() + "}";
    }
}