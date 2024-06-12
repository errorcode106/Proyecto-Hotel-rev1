import java.util.List;

public class Habitacion {
    private String tipo;
    private double precio;

    public Habitacion(String tipo, double precio, List<Comodidad> comodidades) {
        this.tipo = tipo;
        this.precio = precio;
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
