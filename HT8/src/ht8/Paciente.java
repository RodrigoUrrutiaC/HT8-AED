
package ht8;

/**
 * @author Rodrigo Urrutia 16139
 * @version 06.04.2018
 */

public class Paciente implements Comparable <Paciente> {
   
    String nombre, descripcion, codigo;
    
    public Paciente (String nombre, String descripcion, String codigo){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
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
    
    @Override
    public String toString(){
        return (nombre+" - "+descripcion+" - "+descripcion);
    }
}