public class Cliente implements ClienteInt{
    private String nombre;
    private int puntos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void acumularPuntos(ReservaInt reserva) {
        this.puntos += reserva.calcularCosto() / 100;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Puntos: " + puntos;
    }
    
}
