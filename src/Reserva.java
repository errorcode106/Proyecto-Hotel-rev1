import java.time.LocalDate;
import java.util.Objects;

public class Reserva implements ReservaInt {
    private Cliente cliente;
    private HabitacionInt<?> habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, HabitacionInt<?> habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    
    @Override
    public ClienteInt getCliente() {
        return (ClienteInt) cliente;
    }

    @Override
    public HabitacionInt<?> getHabitacion() {
        return (HabitacionInt<?>) habitacion;
    }

    @Override
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public double calcularCosto() {
        return habitacion.calcularPrecioTotal(fechaInicio, fechaFin);
    }

    @Override
    public void cancelarReserva() {
        
    }

    @Override
    public void modificarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva that = (Reserva) o;
        return Objects.equals(cliente, that.cliente) &&
                Objects.equals(habitacion, that.habitacion) &&
                Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, habitacion, fechaInicio, fechaFin);
    }

    @Override
    public String toString() {
        return "Reserva para " + cliente.getNombre() + " - Tipo de habitación: " + habitacion.getNombre() +
                ", Fecha de inicio: " + fechaInicio + ", Fecha de fin: " + fechaFin;
    }

}

