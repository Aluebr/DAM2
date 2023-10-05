package practica1;

public class Practica_2_1_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Tarea2(0));
        Thread t2 = new Thread(new Tarea2(1));

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
        for (int i = 0; i < 1000;i++){
            System.out.println(idHebra);

        }
    }

}
