
package ht8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * @author Rodrigo Urrutia 16139
 * @version 1.0
 * @since 06.04.2018
 */

/**
 * CORRA ESTE MAIN PARA UTILIZAR JCF IMPORTANDO PRIORITYQUEUE
 */

public class Hospital2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nombre, descripcion, codigo;
        PriorityQueue<Paciente> pq = new PriorityQueue<>();
        
        FileReader fr;
        BufferedReader br;
        // Se lee el archivo
        fr = new FileReader("pacientes.txt");
        br = new BufferedReader(fr);

        String linea;

        System.out.println("ESTE MAIN UTILIZA JCF IMPORTANDO PRIORITYQUEUE: \n");
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
            //Para cada paciente, se crea un objeto tipo paciente
            Paciente enfermo = new Paciente(nombre, descripcion, codigo);
            //Se utiliza el PriorityQueue importado para agregar al paciente
            pq.add(enfermo);
        }
        
        System.out.println("\nPacientes atendidos en orden: \n");
        while(!pq.isEmpty()){
            //Recorre a los pacientes y los quita de la lista en orden de prioridad
            Paciente siguiente = pq.poll();
            System.out.println(siguiente.getNombre()+", "+siguiente.getDescripcion()+", "+siguiente.getCodigo());
        }
    }
    
}