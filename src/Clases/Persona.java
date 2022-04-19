package Clases;

/**
 * @author gabriel.reca
 *
 * clase objeto de persona donde definiremos los atrib y constructores para cuando instanciamos, los getters y setters para acceder a los valores y el toString para cuando la imprimamos
 */
public class Persona
{
    /**
     * los 3 atrib que usaremos para instanciar
     */
    private String nombre;
    private String poblacion;
    private Integer edad;

    /**
     *
     * @param nombre
     * @param poblacion
     * @param edad
     *
     * constructor que usaremos en el main para instanciar
     */
    public Persona(String nombre, String poblacion, Integer edad)
    {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    /**
     *
     * getters y setters
     */
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPoblacion()
    {
        return poblacion;
    }

    public void setPoblacion(String poblacion)
    {
        this.poblacion = poblacion;
    }

    public Integer getEdad()
    {
        return edad;
    }

    public void setEdad(Integer edad)
    {
        this.edad = edad;
    }

    /**
     *
     * toString para imprimir el objeto
     */
    @Override
    public String toString() {
        return
                "nombre:" + nombre + '.' +
                " poblacion:" + poblacion + '.' +
                " edad:" + edad;
    }
}
