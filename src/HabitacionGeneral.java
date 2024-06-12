import java.time.LocalDate;
import java.util.List;

public abstract class HabitacionGeneral<T extends Comodidad> implements HabitacionInt<T> {

    private String nombre;

    protected String tipo;
    protected double precio;
    protected List<T> comodidades;

    public HabitacionGeneral(String tipo, double precio, List<T> comodidades) {
        this.tipo = tipo;
        this.precio = precio;
        this.comodidades = comodidades;
    }



    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public List<T> getComodidades() {
        return comodidades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(tipo)
          .append(", Precio: ").append(precio)
          .append(", Comodidades: ").append(comodidades);
        return sb.toString();
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    

    @Override
    public abstract boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin);

    @Override
    public abstract double calcularPrecioTotal(LocalDate fechaInicio, LocalDate fechaFin);
}
