  
public class Nodo {
    Nodo antes;
    Event event;
    Nodo despues;

    Nodo(Event event) {
        this.antes = null;
        this.event = event;
        this.despues = null;
    }

    Nodo(Event event, Nodo antes, Nodo despues) {
        this.antes = antes;
        this.event = event;
        this.despues = despues;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Nodo getNext() {
        return despues;
    }

    public void setNext(Nodo next) {
        this.despues = next;
    }

    public Nodo getAntes() {
        return antes;
    }

    public void setAntes(Nodo antes) {
        this.antes = antes;
    }

    public void imprimirSiguiente() {
        System.out.println(this.despues.getEvent().getData());
    }
}
