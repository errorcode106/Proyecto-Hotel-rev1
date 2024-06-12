import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ComodidadPremium extends Comodidad {
    private String especialidad;

    public ComodidadPremium(String nombre, double precio, String especialidad) {
        super(nombre, precio);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public double calcularCosto(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        double costoBase = dias * this.precio;
        return costoBase + (costoBase * 0.25);
    }
}
