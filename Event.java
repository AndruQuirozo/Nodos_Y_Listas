 

public class Event {
    int data; // El dato de 1-100
    String scientist; // El científico (Rosen o Einstein)
    String eventType; // Tipo de evento
    Event next;

    Event(int data, String scientist) {
        this.data = data;
        this.scientist = scientist;
        this.eventType = ""; // Que tipo de evento es
        this.next = null;
    }

    // Getters y setters para los atributos

    public int getData() {
        return data;
    }

    public String getScientist() {
        return scientist;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setScientist(String scientist) {
        this.scientist = scientist;
    }

    public void displayEvent() {
        System.out.println("[" + data + "|" + scientist + "|" + eventType + "]");
    }
}
