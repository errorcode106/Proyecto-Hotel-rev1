import java.time.LocalDate;

public interface ReservaInt {
    ClienteInt getCliente();
    HabitacionInt<?> getHabitacion();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    double calcularCosto();
    void cancelarReserva();
    void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin);
}
