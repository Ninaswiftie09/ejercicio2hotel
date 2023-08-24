// Nombre: Nina Nájera Marakovits, 231088
// Ejercicio 2 Hotel

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum Clasclientes {
    REGULAR,
    FRECUENTE,
    VIP
}

enum Clashabitaciones {
    ESTANDAR,
    DELUXE,
    SUITE
}

class Cliente {
    String nombre;
    Clasclientes clasificacion;

    public Cliente(String nombre, Clasclientes clasificacion) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
    }

    public String nombrecliente() {
        return nombre;
    }

    public Clasclientes clasicliente() {
        return clasificacion;
    }
}

class Habitacion {
    int numero;
    boolean disponible;

    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public int numerohabitacion() {
        return numero;
    }

    public boolean disponibilidad() {
        return disponible;
    }

    public void asignarcliente() {
        disponible = false;
    }
    
    public void liberar() {
        disponible = true;
    }
}

class Reserva {
    Cliente cliente;
    Habitacion habitacion;

    public Reserva(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        habitacion.asignarcliente();
    }

    public Cliente cliente() {
        return cliente;
    }

    public Habitacion habitacion() {
        return habitacion;
    }
}

class Informacion {
    private Scanner leer;

    public Informacion() {
        leer = new Scanner(System.in);
    }

    public Cliente infocliente() {
        System.out.print("nombre del cliente: ");
        String nombre = leer.nextLine();
        
        System.out.println("clasificación del cliente:");
        for (int i = 0; i < Clasclientes.values().length; i++) {
            System.out.println(i + ". " + Clasclientes.values()[i]);
        }
        int a = leer.nextInt();
        leer.nextLine(); 
        return new Cliente(nombre, Clasclientes.values()[a]);
    }

    public Clashabitaciones infohabitacion() {
        System.out.println("clasificación de la habitación:");
        for (int i = 0; i < Clashabitaciones.values().length; i++) {
            System.out.println(i + ". " + Clashabitaciones.values()[i]);
        }
        int a = leer.nextInt();
        leer.nextLine();
        return Clashabitaciones.values()[a];
    }

    public int numhabitacion() {
        System.out.print("número de habitación: ");
        return leer.nextInt();
    }

    public String observaciones() {
        leer.nextLine(); 
        System.out.print("Ingrese observaciones: ");
        return leer.nextLine();
    }

    public void Mensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

public class ejercicio2 {
    public static void main(String[] args) {
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(001));
        habitaciones.add(new Habitacion(002));
        habitaciones.add(new Habitacion(003));

        Informacion informacion = new Informacion();

        Cliente cliente = informacion.infocliente();
        Clashabitaciones tipoHabitacion = informacion.infohabitacion();
        int numeroHabitacion = informacion.numhabitacion();
        String observaciones = informacion.observaciones();

        Habitacion habitacionReservada = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.numerohabitacion() == numeroHabitacion && habitacion.disponibilidad()) {
                habitacionReservada = habitacion;
                break;
            }
        }

        if (habitacionReservada != null) {
            Reserva reserva = new Reserva(cliente, habitacionReservada);
            habitacionReservada.liberar();
            informacion.Mensaje("Reserva realizada con éxito : " + cliente.nombrecliente());
        } else {
            informacion.Mensaje("Habitación no disponible.");
        }
    }
}



