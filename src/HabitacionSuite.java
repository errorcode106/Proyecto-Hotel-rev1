import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class HabitacionSuite extends HabitacionGeneral<ComodidadPremium> {
    public HabitacionSuite(String tipo, double precio, List<ComodidadPremium> comodidades) {
        super(tipo, precio, comodidades);
    }

    @Override
    public boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin) {
        GestorDisponibilidad gestor = App.getGestor();
        return gestor.contarReservas(this, fechaInicio, fechaFin) < 5 && ChronoUnit.DAYS.between(fechaInicio, fechaFin) >= 3;
    }

    @Override
    public double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        double precioTotal = this.precio;
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (dias > 5) {
            precioTotal *= 0.85; 
        }
        for (ComodidadPremium comodidad : comodidades) {
            precioTotal += comodidad.calcularCosto(fechaInicio, fechaFin);
        }
        return precioTotal;
    }

    @Override
    public String toString() {
        return "HabitacionSuite {" + super.toString() + "}";
    }
}