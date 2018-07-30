package clases;

public class Muro {
    public int[] posicion = new int [2];

    public Muro(int a, int b){
        posicion[0]=a;
        posicion[1]=b;
    }
    public int []getPosicion(){
        return posicion;
    }
}
