package clases;

import java.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        //Defino las listas de instrucciones, mapa, muros y pilas de monedas
        List<Muro> muros = new ArrayList<Muro>();
        List<PilaMonedas> monedas = new ArrayList<PilaMonedas>();
        List<String>mapa =  new ArrayList<String>();
        List<String> instrucciones = new ArrayList <String>();
        List <Robot> robots = new ArrayList<Robot>();

        //Consigo el mapa y lo almaceno en la lista.
        try{
            Stream<String> lines = Files.lines(Paths.get("C:/Users/fuent/OneDrive/Documents/2018/POO/RURPLE/RURPLE-lab/mapa1.txt"),
                    StandardCharsets.UTF_8);
            lines.forEach(s  -> mapa.add(s));
            //mapa.stream().forEach(p-> System.out.println(p));
        }catch(IOException e ){
            System.out.println("Error!");
        }

        //Consigo las instrucciones y las almaceno en la lista.
        try{
            Stream <String> lines = Files.lines (Paths.get("C:/Users/fuent/OneDrive/Documents/2018/POO/RURPLE/RURPLE-lab/instrucciones.txt"),
                    StandardCharsets.UTF_8);
            lines.forEach(a -> instrucciones.add(a));
            //lines.forEach(b -> System.out.println(b));
        }catch(IOException e){
            System.out.println("Error!");
        }

        //Interpreto la informacion del mapa
        for (int c = 0;c <mapa.size();c++){
            System.out.print(mapa.get(c));
            String [] spl=mapa.get(c).split("");
            for(int i = 0;i<spl.length;i++){
                //System.out.print(spl[c]);
                if (spl[c].equals(">")) {
                    robots.add(new Robot(i, c, 0, 0));
                    System.out.println("Slu2");
                }else if (spl[c].equals("1")) {
                    monedas.add(new PilaMonedas(i, c, 1));

                } else if (spl[c].equals("2")) {
                    monedas.add(new PilaMonedas(i, c, 2));

                } else if (spl[c].equals("3")) {
                    monedas.add(new PilaMonedas(i, c, 3));

                } else if (spl[c].equals("4")) {
                    monedas.add(new PilaMonedas(i, c, 4));

                } else if (spl[c].equals("5")) {
                    monedas.add(new PilaMonedas(i, c, 5));

                } else if (spl[c].equals("6")) {
                    monedas.add(new PilaMonedas(i, c, 6));

                } else if (spl[c].equals("7")) {
                    monedas.add(new PilaMonedas(i, c, 7));

                } else if (spl[c].equals("8")) {
                    monedas.add(new PilaMonedas(i, c, 8));

                } else if (spl[c].equals("9")) {
                    monedas.add(new PilaMonedas(i, c, 9));

                } else if (spl[c].equals("<")) {
                    robots.add(new Robot(i, c, 2, 0));
                    System.out.println("Slu2");

                } else if (spl[c].equals("\\-")) {
                    muros.add(new Muro(i, c));


                } else if (spl[c].equals("^")) {
                    robots.add(new Robot(i, c, 3, 0));
                    System.out.println("Slu2");

                } else if (spl[c].equals("v")) {
                    robots.add(new Robot(i, c, 1, 0));
                    System.out.println("Slu2");

                }
            }
            System.out.println("");
        }

        //filtrar(mapa,muros,monedas,robots);
        System.out.println("Numero de elementos en mapa: "+mapa.size());
        System.out.println("Numero de elementos en muros: "+muros.size());
        System.out.println("Numero de elementos en monedas:"+monedas.size());
        System.out.println("Numero de elementos en robots: "+robots.size());
        System.out.println("Numero de instrucciones: "+instrucciones.size());


        //Instancio el robot del mapa
        if (!robots.isEmpty()){
            Robot  robot = robots.get(0);
            for (int control =0;control < instrucciones.size();control++){
                actualizarMapa(mapa,muros,monedas,robots);
                mapa.forEach(a -> System.out.println(a));
                String inst = instrucciones.get(control);
                switch(inst){
                    case "MOVE":
                        if (robot.puedeMover(mapa)){
                            robot.mover();
                        }
                        break;
                    case "ROTATE":
                        robot.girar();
                        break;
                    case "PICK":
                        for(int i = 0;i<monedas.size();i++){
                            if (monedas.get(i).getPosicion() == robot.getPosicion()){
                                //El metodo recoger le suma monedas al robot y le resta a la pila de monedas.
                                robot.recoger(monedas.get(i));
                            }else{
                                System.out.println("La instruccion PICK no se pudo ejecutar porque no hay una pila de monedas en la posicion...");
                            }
                        }
                        break;
                    default:
                        System.out.println("-----------------------------------------");
                        System.out.println("");
                        System.out.println("Hay una linea en blanco...");
                        System.out.println("");
                        System.out.println("-----------------------------------------");
                }
            }
        }else{
            System.out.println("Hay un error en la lectura...");
        }



    }
    //Este metodo interpreta la información del archivo del mapa, agregando objetos de pilas de monedas, muros y robots a sus respectivas listas
    public static  void filtrar(List<String> mapa, List<Muro> muro, List<PilaMonedas> moneda, List <Robot> robots ){



    }
    public static void actualizarMapa(List<String> mapa,List<Muro> muro, List<PilaMonedas> moneda, List <Robot> robo){

        List <String[]> temp = new ArrayList<>();
        for (int i = 0;i<mapa.size();i++){
            temp.add(mapa.get(i).split(""));
        }

        Robot robot = robo.get(0);

        for (int a = 0;a<temp.size();a++){
            for (int b = 0;b<mapa.get(a).length();b++){
                if (temp.get(a)[b]=="v"){
                    temp.get(a)[b]=" ";
                    break;
                }else if (temp.get(a)[b]==">"){
                    temp.get(a)[b]=" ";
                    break;
                }else if (temp.get(a)[b]=="<"){
                    temp.get(a)[b]=" ";
                    break;
                }else if (temp.get(a)[b]=="^"){
                    temp.get(a)[b]=" ";
                    break;
                }
            }
            break;
        }
        temp.get(robot.getPosicion()[1])[0]=robot.interpretarOrientacion();

        for (int c = 0;c<moneda.size();c++){
            if (temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]!="v"){
                temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]= String.valueOf(moneda.get(c).getCantidad());
            }else if (temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]!="<"){
                temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]= String.valueOf(moneda.get(c).getCantidad());
            }else if (temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]!=">"){
                temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]= String.valueOf(moneda.get(c).getCantidad());
            }else if(temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]!="^"){
                temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]= String.valueOf(moneda.get(c).getCantidad());
            }
            if (temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]=="0"){
                temp.get(moneda.get(c).getPosicion()[1])[moneda.get(c).getPosicion()[0]]=" ";
            }
        }

        for (int d  = 0;d< temp.size();d++){
            String linea = "";
            for(int e  = 0;e <temp.get(d).length;e++){
                linea = linea + temp.get(d)[e];
            }
            mapa.set(d,linea);
        }

    }
}
