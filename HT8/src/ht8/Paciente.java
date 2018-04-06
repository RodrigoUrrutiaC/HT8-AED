
package ht8;

/**
 * @author Rodrigo Urrutia 16139
 * @version 1.0
 * @since 06.04.2018
 */

public class Paciente implements Comparable <Paciente> {
   
    String nombre, descripcion, codigo;
    
    /**
     * 
     * @param nombre
     * @param descripcion
     * @param codigo 
     */
    public Paciente (String nombre, String descripcion, String codigo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    
    /**
     * 
     * @return 
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * 
     * @return 
     */
    public String getDescripcion(){
        return descripcion;
    }
    
    /**
     * 
     * @return 
     */
    public String getCodigo(){
        return codigo;
    }
    
    /**
     * 
     * @param otro
     * @return 
     */
    @Override
    public int compareTo(Paciente otro){
        if (getCodigo().compareTo(otro.getCodigo()) > 0){
            return 1;
        }
        else if (getCodigo().compareTo(otro.getCodigo()) < 0){
            return -1;
        }
        else return 0;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return (nombre+" - "+descripcion+" - "+descripcion);
    }
}