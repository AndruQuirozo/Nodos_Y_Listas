 

public class ListaDobleEnlazada {

    Event cabeza;
    Event cola;
    Event eventoA = null;
    Event eventoB = null;
    Event eventoC = null;

    ListaDobleEnlazada() {
        Event cabeza = null;
        Event cola = null;
    }

    public boolean vacio() {
        return cabeza == null;
    }

    public boolean sonCoprimos(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int resultado = 0;

        do {
            resultado = min;
            min = max % min;
            max = resultado;
        } while (min != 0);

        return max == 1;
    }

    public boolean esPrimo(int numero) {
        if (numero == 1) {
            return false;
        }

        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void empezar() {
        int contadorEventoA = 0;
        int contadorEventoB = 0;
        int contadorEventoC = 0;
        int contadorNodos = 0;

        for (int i = 1; i <= 22; i++) {
            if (!vacio()) {
                contadorNodos++;
                Randoms numero = new Randoms();
                String cientifico = numero.getCientifico();
                int dato = numero.getNumero();

                // Crear un nuevo Event en lugar de modificar Nodo
                Event nuevoEvento = new Event(dato, cientifico);
                nuevoEvento.next = cabeza;
                cabeza = nuevoEvento;

                boolean datob = esPrimo(dato);

                if (datob && contadorEventoA == 0) {
                    cabeza.setEventType("Evento A");
                    cabeza.setScientist("Einstein");
                    eventoA = cabeza;
                    contadorEventoA = 1;

                    System.out.println("Se ha producido un evento de Tipo A:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    cabeza.displayEvent();
                    System.out.println("\n");
                } else if (datob && eventoA != null && contadorEventoB == 0) {
                    cabeza.setEventType("Evento B");
                    eventoB = cabeza;
                    contadorEventoB = 1;

                    System.out.println("Se ha producido un evento de Tipo B:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    cabeza.displayEvent();
                    System.out.println("\n");

                    contadorEventoC = 0;
                } else if (eventoA != null && eventoB != null && sonCoprimos(dato, eventoA.getData()) && contadorEventoC == 0) {
                    cabeza.setEventType("Evento C");
                    contadorEventoC = 1;

                    System.out.println("Se ha producido un evento de Tipo C:" + dato);
                    System.out.println("Este evento reposa en el nodo:" + contadorNodos);
                    cabeza.displayEvent();
                    System.out.println("\n");

                    if (esPrimo(dato) && eventoA.getScientist().equals("Einstein")) {
                        System.out.println("El científico " + cabeza.getScientist() + " viajó al pasado y entregó datos clave para el avance del proyecto a " + eventoA.getScientist());
                        System.out.println("[" + cabeza.getData() + "|" + cabeza.getScientist() + "|" + cabeza.getEventType() + "]" + "<=" + "[" + eventoB.getData() + "|" + eventoB.getScientist() + "|" + eventoB.getEventType() + "]" + "<=" + "[" + eventoA.getData() + "|" + eventoA.getScientist() + "|" + eventoA.getEventType() + "]");
                        System.out.println("\n");
                    } else {
                        System.out.println("El científico " + cabeza.getScientist() + " viajó al pasado, pero solo pudo observar");
                        System.out.println("[" + cabeza.getData() + "|" + cabeza.getScientist() + "|" + cabeza.getEventType() + "]" + "<=" + "[" + eventoB.getData() + "|" + eventoB.getScientist() + "|" + eventoB.getEventType() + "]" + "<=" + "[" + eventoA.getData() + "|" + eventoA.getScientist() + "|" + eventoA.getEventType() + "]");
                        System.out.println("\n");
                    }

                    // Reiniciamos
                    contadorEventoA = 0;
                    contadorEventoB = 0;
                }
            } else {
                Randoms numero = new Randoms();
                int dato = numero.getNumero();
                String cientifico = numero.getCientifico();

                // Crear un nuevo Event en lugar de modificar Nodo
                cabeza = cola = new Event(dato, cientifico);

                contadorNodos++;
            }
        }
    }

    public void imprimir_Lista() {
        if (!vacio()) {
            String datos = "<=";

            Event ayudante = cabeza;

            while (ayudante != null) {
                datos = datos + "[" + ayudante.getData() + "|" + ayudante.getScientist() + "|" + ayudante.getEventType() + "]<=";
                ayudante = ayudante.next;
            }

            System.out.println("Datos" + datos);
        }
    }
}
