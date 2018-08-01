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

    public void mover(){
        if (orientacion==0){
            posicion[0]=+1;
        }else if (orientacion == 1){
            posicion[1]=-1;
        }else if (orientacion == 2){
            posicion[0]=-1;
        }else if (orientacion == 3){
            posicion[1]=+1;
        }
    }

    public Boolean puedeMover(String[][] mapa){
        Boolean re = true;
        try{
            switch (orientacion){
                case 0:
                    if (mapa[posicion[0]][posicion[1]]=="*"){
                    re=false;
                    }
                    break;
                case 1:
                    if (mapa[posicion[0]][posicion[1]]=="*"){
                    re= false;
                    }
                    break;
                case 2 :
                    if(mapa[posicion[0]][posicion[1]]=="*"){
                    re=false;
                    }
                    break;
                case 3:
                    if (mapa[posicion[0]][posicion[1]]=="*"){
                    re=false;
                    }
                    break;
                default:
                    break;
            }
        }catch(IndexOutOfBoundsException e){
            re= false;
        }
        return re;
    }

    public void girar (){
        orientacion=(orientacion + 1) % 4;
    }

    public String interpretarOrientacion(){
        String o= "";
        switch (orientacion){
            case 0:
                o = ">";
                break;
            case 1:
                o = "v";
                break;
            case 2:
                o = "<";
                break;
            case 3:
                o = "^";
                break;
        }
        return o;
    }
}

