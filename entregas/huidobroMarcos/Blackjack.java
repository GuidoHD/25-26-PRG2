import java.util.Scanner;

class Blackjack{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

         while (opcion != 3) {
            Baraja baraja = new Baraja();
            Mano mano = new Mano();

            // Repartir dos cartas iniciales
            mano.agregarCarta(baraja.sacarCarta());
            mano.agregarCarta(baraja.sacarCarta());

            boolean partidaTerminada = false;

        }
    }

    



}