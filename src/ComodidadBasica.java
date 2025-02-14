import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ComodidadBasica extends Comodidad {

    public ComodidadBasica(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias * this.precio;
    }
}

