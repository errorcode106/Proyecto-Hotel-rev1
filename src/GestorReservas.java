import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<ReservaInt> reservas;

    public GestorReservas() {
        this.reservas = new ArrayList<>();
    }

    public void realizarReserva(Cliente cliente, HabitacionInt<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        Reserva reserva = new Reserva(cliente, habitacion, fechaInicio, fechaFin);
        reservas.add(reserva);
        cliente.acumularPuntos(reserva);
    }
    
    
    
    public void cancelarReserva(ReservaInt reserva) {
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    public void modificarReserva(ReservaInt reserva, LocalDate fechaInicio, LocalDate fechaFin) {
        reserva.modificarFechas(fechaInicio, fechaFin);
    }

    public double calcCostoReserva(ReservaInt reserva) {
        return reserva.calcularCosto();
    }

    public List<ReservaInt> getReservas() {
        return reservas;
    }
    
}
