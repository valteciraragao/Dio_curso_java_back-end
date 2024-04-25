public class Usuario {
    public static void main(String[] args) throws Exception {
        
        SmartTv smartTv = new SmartTv();
        
        System.out.println("Bem vindo a Dio SamrtTV! Onde seus canais e jogos são muito mais divertidos.");
        System.out.println("Sua SmartTV está ligada? " + smartTv.ligado);
        System.out.println("Canal atual: " + smartTv.canal);
        System.out.println("Volume atual: " + smartTv.volume);

        smartTv.ligar();
        smartTv.aumentarVolume();
        smartTv.mudarCanal(49);
        smartTv.diminuirCanal();

        System.out.println("Bem vindo a Dio SamrtTV! Onde seus canais e jogos são muito mais divertidos.");
        System.out.println("Sua SmartTV está ligada? " + smartTv.ligado);
        System.out.println("Canal atual: " + smartTv.canal);
        System.out.println("Volume atual: " + smartTv.volume);
    }
}
