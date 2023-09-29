package creacionHebras;

public class CreacionHebrasUnaClase {
    public static void main(String[] args) {
        Tarea3 t3 = new Tarea3(0);
        Tarea3 t3b = new Tarea3(1);

        t3.start();
        t3b.start();
    }
}

class Tarea3 extends Thread{
    private int idHebra;
    public Tarea3 (int idHebra){
        this.idHebra = idHebra;
    }
    public void run(){
        if (idHebra == 0){
            for(int i = 0; i < 3; i++){
                System.out.println("Hola");
            }
        }else{
            for(int i = 0; i < 3; i++){
                System.out.println("Adios");
            }
        }
    }
}