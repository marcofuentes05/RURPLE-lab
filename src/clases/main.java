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
        }catch(IOException e ){
            System.out.println("Error!");
        }

        //Consigo las instrucciones y las almaceno en la lista.
        try{
            Stream <String> lines = Files.lines (Paths.get("C:/Users/fuent/OneDrive/Documents/2018/POO/RURPLE/RURPLE-lab/instrucciones.txt"),
                    StandardCharsets.UTF_8);
            lines.forEach(a -> instrucciones.add(a));
        }catch(IOException e){
            System.out.println("Error!");
        }

        System.out.println("        Mapa        ");
        mapa.forEach(a -> System.out.println(a));


        for (int control =0;control < instrucciones.size();control++){
            String inst = instrucciones.get(control);
        }
    }
    //Este metodo interpreta la información del archivo del mapa, agregando objetos de pilas de monedas, muros y robots a sus respectivas listas
    public  void filtrar(List<String> mapa, List<Muro> muro, List<PilaMonedas> moneda, List <Robot> robo ){
        String r="";
        for (int i = 0;i <mapa.size();i++){
            String spl[]=mapa.get(i).split("");
            for(int c = 0;c<spl.length;c++){
                switch(spl[c]){
                    case "*": muro.add(new Muro(i,c));
                        break;
                    case "1": moneda.add(new PilaMonedas(i,c,1));
                        break;
                    case "2": moneda.add(new PilaMonedas(i,c,2));
                        break;
                    case "3": moneda.add(new PilaMonedas(i,c,3));
                        break;
                    case "4": moneda.add(new PilaMonedas(i,c,4));
                        break;
                    case "5" :moneda.add(new PilaMonedas(i,c,5));
                        break;
                    case "6": moneda.add(new PilaMonedas(i,c,6));
                        break;
                    case "7": moneda.add(new PilaMonedas(i,c,7));
                        break;
                    case "8": moneda.add(new PilaMonedas(i,c,8));
                        break;
                    case "9": moneda.add(new PilaMonedas(i,c,9));
                        break;
                    case "<": robo.add(new Robot (i,c,2,0));
                        break;
                    case ">":robo.add(new Robot (i,c,0,0));
                        break;
                    case "^": robo.add(new Robot (i,c,3,0));
                        break;
                    case "v" : robo.add(new Robot (i,c,1,0));
                        break;
                }
            }
        }


        //return r;
    }
}
