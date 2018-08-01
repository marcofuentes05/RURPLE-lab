package clases;

import java.util.ArrayList;
import java.util.List;

public class Map {
    String [][] mapa;
    List<Muro> muros = new ArrayList<>();
    List<PilaMonedas> monedas = new ArrayList<>();
    Robot robot;
    int alto;
    int ancho;
    int cantidadInstrucciones;
    String[] instrucciones;

    public Map(List <String> archivo, List<String> inst){
        alto = archivo.size();
        ancho = archivo.get(0).length();
        int cantidadInstrucciones = inst.size();
        instrucciones = new String[cantidadInstrucciones];
        mapa = new String[alto][ancho];
        for (int i = 0;i<archivo.size();i++){
            String [] linea = archivo.get(i).split("");
            for (int j = 0;j<linea.length;j++){
                mapa[i][j]=linea[j];
            }
        }
        for (int x = 0;x<alto;x++){
            for (int y =0;y<ancho;y++){
                switch (mapa[x][y]){
                    case"1":
                        monedas.add(new PilaMonedas(x,y,1));
                        break;
                    case"2":
                        monedas.add(new PilaMonedas(x,y,2));
                        break;
                    case"3":
                        monedas.add(new PilaMonedas(x,y,3));
                        break;
                    case"4":
                        monedas.add(new PilaMonedas(x,y,4));
                        break;
                    case"5":
                        monedas.add(new PilaMonedas(x,y,5));
                        break;
                    case"6":
                        monedas.add(new PilaMonedas(x,y,6));
                        break;
                    case"7":
                        monedas.add(new PilaMonedas(x,y,7));
                        break;
                    case"8":
                        monedas.add(new PilaMonedas(x,y,8));
                        break;
                    case"9":
                        monedas.add(new PilaMonedas(x,y,9));
                        break;
                    case"*":
                        muros.add(new Muro(x,y));
                        break;
                    case"^":
                        robot = new Robot(x,y,3,0);
                        break;
                    case">":
                        robot = new Robot(x,y,0,0);
                        break;
                    case"v":
                        robot = new Robot(x,y,1,0);
                        break;
                    case"<":
                        robot= new Robot(x,y,2,0);
                        break;
                    default:
                        break;
                }
            }
        }
        cantidadInstrucciones=inst.size();
        for (int c  = 0;c<cantidadInstrucciones;c++){
            instrucciones[c]=inst.get(c);
        }
    }
    public String imprimir(){
        String m="";
        for (int i = 0;i<alto;i++){
            for (int j = 0;j<ancho;j++){
                m = m + mapa[i][j];
            }
            m = m+"\n";
        }
        return m;
    }

    public void actualizarMapa(){
        int i = robot.getPosicion()[0];
        int j = robot.getPosicion()[1];
        if (mapa[i][j]==" "){
            mapa[i][j]=robot.interpretarOrientacion();
        }
        /**try{
            if (mapa[i][j]==" "){
                mapa[i][j]=robot.interpretarOrientacion();
            }
        }catch(Exception e){}**/

        for (int x = 0;x<monedas.size();x++){
            int a = monedas.get(x).getPosicion()[0];
            int b = monedas.get(x).getPosicion()[1];
            if (mapa[a][b] != String.valueOf(monedas.get(x).getCantidad())){
                mapa[a][b]=String.valueOf(monedas.get(x).getCantidad());
            }
        }
        for (int x = 0;x<alto;x++){
            for (int y = 0;y<ancho;y++){
                if (mapa[x][y]=="v"){
                    mapa[x][y]=" ";
                    break;
                }else if (mapa[x][y]=="<"){
                    mapa[x][y]=" ";
                    break;
                }else if (mapa[x][y]==">"){
                    mapa[x][y]=" ";
                    break;
                }else if (mapa[x][y]=="^"){
                    mapa[x][y]=" ";
                    break;
                }
            }
        }


    }
}