package Launcher;

import Clases.Persona;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main
{
    public static void main(String [] args) throws IOException {
        //lista que almacenara objetos de personas
        List<Persona> listaPersonas = new ArrayList<>();

        //instancia de persona sin inicializar
        Persona persona;

        //String que usaremos como auxiliar para leer el fichero
        String cadena = "";

        //array que almacenara cada una de las partes que splitearemos de la variable cadena
        String [] partes = new String[2];

        //indicamos el fichero a leer en este caso no usamos ruta absoluta porque se encuentra el fichero en el proyecto
        //FileReader y BufferedReader son clases necesarias para leer el fichero
        File file = new File("fichero.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        //crearemos un bucle que leera mientras haya algo que leer
        while((cadena = br.readLine()) != null)
        {
            /**
             * este try esta aqui para que cuando llegue al segundo registro habra un arrayindexoutofbounds debido a que
             * la funcion split no dividira en 3 partes entonces cuando quiera crear la instancia de esta me saltara esa
             * excepcion. Por tanto lo englobo en un try-catch y en el catch hago esa instancia especifica
             * y ahora dentro del try pongo una condicion para que las partes del array correspondidas con la ciudad
             * para las que esten vacias, en su constructor se instancie como 'desconocida' y para el resto de posibilidades
             * todo se desarrolla normal
             */
            try
            {
                partes = cadena.split(":");
                Integer edad = Integer.parseInt(partes[2]);

                if(partes[1].equals(""))
                {
                    persona = new Persona(partes[0], "desconocida", edad);
                    listaPersonas.add(persona);
                }
                else
                {
                    persona = new Persona(partes[0], partes[1], edad);
                    listaPersonas.add(persona);
                }

            }catch(ArrayIndexOutOfBoundsException e)
            {
                persona = new Persona(partes[0], partes[1], null);
                listaPersonas.add(persona);
            }
        }

        /**
         * hago un stream de la lista y como hay una edad null no podra llevar a cabo la comparacion por tanto
         * encapsulo el iterador en un optional y cambio la edad a una imposible para poder llevar a cabo la comparacion
          */
        listaPersonas.stream()
                .filter(n -> Optional.of(n).map(Persona::getEdad).orElse(1000) < 25)

                .forEach(System.out::println);
    }
}
