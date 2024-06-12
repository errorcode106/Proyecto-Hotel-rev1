import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class App {
    private static GestorDisponibilidad gestorDisp;
    private static GestorReservas gestorReservas;

    public static void main(String[] args) {
        // Instanciar una lista de habitaciones
        List<HabitacionGeneral<? extends Comodidad>> habitaciones = new ArrayList<>();
        
        // Instanciar una lista de reservas
        List<Reserva> reservas = new ArrayList<>();
        
        // Instanciar el gestor de disponibilidad
        gestorDisp = new GestorDisponibilidad(habitaciones, reservas);
        
        // Instanciar el gestor de reservas
        gestorReservas = new GestorReservas();
        
        // Crear 3 instancias de habitaciones
        HabitacionSimple habitacionSimple = new HabitacionSimple("Simple", 100.0, new ArrayList<>());
        HabitacionDoble habitacionDoble = new HabitacionDoble("Doble", 150.0, new ArrayList<>());
        HabitacionSuite habitacionSuite = new HabitacionSuite("Suite", 200.0, new ArrayList<>());
        
        // Crear 6 instancias de comodidades de una u otra subclase definida
        ComodidadBasica camaExtra = new ComodidadBasica("Cama Extra", 20.0);
        ComodidadBasica servicioHabitacion = new ComodidadBasica("Servicio a la Habitación", 30.0);
        ComodidadPremium jacuzzi = new ComodidadPremium("Jacuzzi", 50.0, "Premium");
        ComodidadPremium champagne = new ComodidadPremium("Champagne", 70.0, "Premium");
        ComodidadPremium gimnasioPrivado = new ComodidadPremium("Gimnasio Privado", 100.0, "VIP");
        ComodidadPremium mayordomo = new ComodidadPremium("Mayordomo", 120.0, "VIP");
        
        // Agrego comodidades a las habitaciones
        habitacionSimple.getComodidades().add(camaExtra);
        habitacionSimple.getComodidades().add(servicioHabitacion);
        
        habitacionDoble.getComodidades().add(camaExtra);
        habitacionDoble.getComodidades().add(servicioHabitacion);
        
        habitacionSuite.getComodidades().add(gimnasioPrivado);
        habitacionSuite.getComodidades().add(mayordomo);
        habitacionSuite.getComodidades().add(jacuzzi);
        habitacionSuite.getComodidades().add(champagne);

        // Muestro en pantalla la información de las habitaciones
        System.out.println();
        System.out.println(habitacionSimple);
        System.out.println();
        System.out.println(habitacionDoble);
        System.out.println();
        System.out.println(habitacionSuite);
        System.out.println();

        
        // Se crea 2 instancias de clientes
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        // Se muestra los puntos acumulados para cada cliente hasta el momento es 0, porq recien se instanciaron los clientes
        System.out.println(cliente1);
        System.out.println();
        System.out.println(cliente2);
        System.out.println();
        // Se realizan reservas para cada cliente
        for (int i = 0; i < 2; i++) {
            gestorReservas.realizarReserva(cliente1, habitacionSimple, LocalDate.now(), LocalDate.now().plusDays(2));
            gestorReservas.realizarReserva(cliente1, habitacionDoble, LocalDate.now(), LocalDate.now().plusDays(5));
            gestorReservas.realizarReserva(cliente1, habitacionSuite, LocalDate.now(), LocalDate.now().plusDays(1));

            gestorReservas.realizarReserva(cliente2, habitacionSimple, LocalDate.now(), LocalDate.now().plusDays(3));
            gestorReservas.realizarReserva(cliente2, habitacionDoble, LocalDate.now(), LocalDate.now().plusDays(4));
        }

        // Muestro las reservas de cada cliente
        for (Cliente cliente : List.of(cliente1, cliente2)) {
            System.out.println("Reservas para " + cliente.getNombre() + ":");
            for (ReservaInt reserva : gestorReservas.getReservas()) {
                if (reserva.getCliente().equals(cliente)) {
                    System.out.println("Reserva para " + cliente.getNombre() + " - Tipo de habitación: "
                            + reserva.getHabitacion().getTipo() + ", Fecha de inicio: " + reserva.getFechaInicio()
                            + ", Fecha de fin: " + reserva.getFechaFin());
                }
            }
            System.out.println(); 
        }
        
        // Calcular el costo de las habitaciones reservadas y mostrar
        double costoTotalCliente1 = 0;
        double costoTotalCliente2 = 0;
        for (ReservaInt reserva : gestorReservas.getReservas()) {
            if (reserva.getCliente().equals(cliente1)) {
                costoTotalCliente1 += gestorReservas.calcCostoReserva(reserva);
            } else if (reserva.getCliente().equals(cliente2)) {
                costoTotalCliente2 += gestorReservas.calcCostoReserva(reserva);
            }
        }
        System.out.println("Costo total para Cliente 1: $" + costoTotalCliente1);
        System.out.println("Costo total para Cliente 2: $" + costoTotalCliente2);
        
        // Calcular los puntos acumulados para cada cliente y mostrarlos
        int puntosCliente1 = cliente1.getPuntos();
        int puntosCliente2 = cliente2.getPuntos();
        System.out.println("Puntos acumulados para Cliente 1: " + puntosCliente1);
        System.out.println("Puntos acumulados para Cliente 2: " + puntosCliente2);

        
    }


    public static GestorDisponibilidad getGestor() {
        return gestorDisp;
    }

    public static GestorReservas getGestorReservas() {
        return gestorReservas;
    }
}
   
