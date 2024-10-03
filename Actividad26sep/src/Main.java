import java.util.Arrays;

class DownloadThread extends Thread {

    String name;
    static long milisegundos=0;
    long timeStartMillis =0, timeEndtMillis=0;
    public DownloadThread(String name, long milisegundos) {
        this.name=name;
        this.milisegundos= milisegundos;
    }

    public void run(){
        try {
            timeStartMillis = System.currentTimeMillis();
            System.out.println("Tiempo inicial " + this.timeStartMillis + "para" + this.name);
            System.out.println("Inicianda descarga " + this.name);
            Thread.sleep(this.milisegundos);
            System.out.println("Fin de la descarga " + this.name);
            timeEndtMillis = System.currentTimeMillis();

            //sinchronized(DownloadThread.class){
            //    milisegundos += timeEndtMillis - timeStartMillis;
            //}

            System.out.println("Tiempo final "+ this.timeEndtMillis + " para " + this.name);
            System.out.println("Tiempo total del fichero " + this.name + " es " + (timeEndtMillis-timeStartMillis));
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DownloadThread[] downloadThreads = new DownloadThread[6];

        downloadThreads [0] = new DownloadThread("File1",16000);
        downloadThreads [1] = new DownloadThread("File2",500);
        downloadThreads [2] = new DownloadThread("File3",250);
        downloadThreads [3] = new DownloadThread("File4",6000);
        downloadThreads [4] = new DownloadThread("File5",7500);
        downloadThreads [5] = new DownloadThread("File6",3000);

        try {

            for (DownloadThread downloadThread : downloadThreads) {
                downloadThread.start();
            }
            for (DownloadThread downloadThread : downloadThreads){
                downloadThread.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TIEMPO TOTAL: " + DownloadThread.milisegundos);
    }
}