import java.time.LocalDate;
import java.util.List;

public class GestorDisponibilidad {
    private List<Reserva> reservas;

    public GestorDisponibilidad(List<HabitacionGeneral<? extends Comodidad>> habitaciones, List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int contarReservas(HabitacionGeneral<?> hab, LocalDate fechaInicio, LocalDate fechaFin) {
        int cantReservas = 0;
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(hab) &&
                    (reserva.getFechaInicio().isBefore(fechaFin) && reserva.getFechaFin().isAfter(fechaInicio))) {
                cantReservas++;
            }
        }
        return cantReservas;
    }
}
