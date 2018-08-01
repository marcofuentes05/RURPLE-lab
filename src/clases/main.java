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
        List<String>mapa =  new ArrayList<String>();
        List<String> instrucciones = new ArrayList <String>();
        //Consigo el mapa y lo almaceno en la lista.
        try{
            Stream<String> lines = Files.lines(Paths.get("C:/Users/fuent/OneDrive/Documents/2018/POO/RURPLE/RURPLE-lab/mapa1.txt"),StandardCharsets.UTF_8);
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

        Map map = new Map(mapa,instrucciones);

        for (int control =0;control < map.instrucciones.length;control++){
            System.out.println(control);
            String inst = map.instrucciones[control];
            switch(inst){
                case "MOVE":
                    if (map.robot.puedeMover(map.mapa)){
                        map.robot.mover();
                    }
                    break;
                case "ROTATE":
                    map.robot.girar();
                    break;
                case "PICK":
                    for(int i = 0;i<map.monedas.size();i++){
                        if (map.monedas.get(i).getPosicion() == map.robot.getPosicion()){
                            //El metodo recoger le suma monedas al robot y le resta a la pila de monedas.
                            map.robot.recoger(map.monedas.get(i));
                        }
                    }
                    break;
                default:
            }
            map.actualizarMapa();
            System.out.println(map.imprimir());

            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println("Ha fallado el timer...");
            }
        }
    }
}
