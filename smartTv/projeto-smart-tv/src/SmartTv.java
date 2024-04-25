public class SmartTv{
    boolean ligado = false;
    int canal = 1;
    int volume = 15;

    public void ligar(){
        ligado = true;
    }

    public void desligar(){
        ligado = false;
    }

    public void aumentarCanal(){
        canal++;
    }

    public void mudarCanal(int valor){
        canal = valor;
    }

    public void diminuirCanal(){
        canal--;
    }


    public void aumentarVolume(){
        volume++;
    }

    public void diminuirVolume(){
        volume--;
    }

}