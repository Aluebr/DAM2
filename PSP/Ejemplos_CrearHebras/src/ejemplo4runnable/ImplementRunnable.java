package ejemplo4runnable;



public class ImplementRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea2(0));
        Thread t2 = new Thread(new Tarea2 (1));

        t1.start();
        t2.start();


    }
}
class Tarea2 implements Runnable{

    int idHebra;

    public Tarea2(int idHebra) {
        this.idHebra = idHebra;
    }

    public void run() {
        System.out.println("Soy la hebra:" + idHebra);
    }

}
