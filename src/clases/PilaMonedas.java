package clases;

public class PilaMonedas {
    public int[] posicion = new int[2];
    public int cantidad;

    public PilaMonedas(int x, int y, int c){
        posicion[0]=x;
        posicion[1]=y;
        cantidad = c;

    }
    public int[] getPosicion(){
        return posicion;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void restarMonedas(){
        cantidad = cantidad-1;
    }
}
