
 import java.util.Random;

public class Randoms {
    
    public String getCientifico() {

        String[] scientist = {"Rosen", "Einstein"};

        Random random = new Random();
        
        int indice = random.nextInt(scientist.length);

        String cientificoSeleccionado = scientist[indice];

        return cientificoSeleccionado;
    }

    public int getNumero(){

        Random random = new Random();

        int numero = random.nextInt(1, 100);

        return numero;

    }
}
