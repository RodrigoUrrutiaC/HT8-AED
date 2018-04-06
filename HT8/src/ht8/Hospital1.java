
package ht8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rodrigo Urrutia 16139
 * @version 1.0
 * @since 06.04.2018
 */

/**
 * CORRA ESTE MAIN PARA UTILIZAR IMPLEMENTACION VECTORHEAP
 */

public class Hospital1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nombre, descripcion, codigo;
        VectorHeap<Paciente> pq = new VectorHeap<>();
        
        FileReader fr;
        BufferedReader br;
        
        //Se lee el archivo
        fr = new FileReader("pacientes.txt");
        br = new BufferedReader(fr);

        String linea;
        
        System.out.println("ESTE MAIN UTILIZA LA IMPLEMENTACION VECTORHEAP: \n");
        System.out.println("Lista de pacientes: \n");
        while((linea=br.readLine())!=null){
            int lugar1 = linea.indexOf(',');
            nombre = linea.substring(0, lugar1);
            String resto = linea.substring(lugar1+2);
            int lugar2 = resto.indexOf(',');
            //Separa las comas
            descripcion = resto.substring(0, lugar2);
            codigo = resto.substring(lugar2+2);
            System.out.println(linea);
            Paciente enfermo = new Paciente(nombre, descripcion, codigo);
            //Para cada paciente, se crea un objeto tipo paciente
            pq.add(enfermo);
            //Y se agregan al VectorHeap
        }

        System.out.println("\nPacientes atendidos en orden: \n");
        while(!pq.isEmpty()){
            //Recorre a los pacientes y los quita de la lista en orden de prioridad
            Paciente siguiente = pq.remove();
            System.out.println(siguiente.getNombre()+", "+siguiente.getDescripcion()+", "+siguiente.getCodigo());
        }
    }
    
}