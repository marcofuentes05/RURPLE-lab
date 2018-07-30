package clases;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public class Robot {

    public final int DERECHA = 0;
    public final int IZQUIERDA = 2;
    public final int ARRIBA = 3;
    public final int ABAJO = 1;

    public int []posicion = new int[2];
    public int orientacion;
    public int cantidadMonedas;

    public Robot(int x, int y, int o, int c){
        posicion[0]=x;
        posicion[1]= y;
        orientacion = o;
        cantidadMonedas = c;
    }
    public int [] getPosicion(){
        return posicion;
    }
    public int getOrientacion(){
        return orientacion;
    }
    public int getMonedas(){
        return cantidadMonedas;
    }
    public void recoger(PilaMonedas a){
        a.restarMonedas();
        cantidadMonedas =+1;
    }
    public void mover(Boolean puedeMover){
        if (orientacion==0){
            if (puedeMover){
                posicion[0]=+1;
            }
        }else if (orientacion == 1){
            if (puedeMover){
                posicion[1]=-1;
            }
        }else if (orientacion == 2){
            if(puedeMover){
                posicion[0]=-1;
            }
        }else if (orientacion == 3){
            if (puedeMover){
                posicion[1]=+1;
            }
        }
    }
    public Boolean puedeMover(int orient, List<String> mapa){
        Boolean re = true;
        switch (orient){
            case 0: if (mapa.get(posicion[0]+1)=="*"){
                re=false;
            }
            break;
            case 1: if (mapa.get(posicion[1]-1)=="*"){
                re= false;
            }
            break;
            case 2 : if(mapa.get(posicion[0]-1)=="*"){
                re=false
            }
            break;
            case 3: if (mapa.get(posicion[1]+1)=="*"){
                re=false;
            }
            break;
            default:
        }
        return re;

    }
    public void girar (){
        orientacion=(orientacion + 1) % 4;
    }
}
