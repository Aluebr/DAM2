package ejemplo7;

public class CincoHebrasConVector {

    public static void main(String[] args) {

        int numHebras = 5;
        Tarea[] numHebra = new Tarea[numHebras];

        for (int i = 0; i < numHebras; i++) {
            Tarea t = new Tarea(i);
            numHebra[i] = t;
            t.start();
        }

        for (Tarea tarea1 : numHebra) {
            try {
                tarea1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("Todas las hebras han terminado");
    }
}

class Tarea extends Thread {
    private int idHebra;

    public Tarea(int idHebra) {
        this.idHebra = idHebra;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hola soy la hebra: " + idHebra);
        }
    }
}
