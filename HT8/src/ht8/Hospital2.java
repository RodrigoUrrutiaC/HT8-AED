
package ht8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * @author Rodrigo Urrutia 16139
 * @version 06.04.2018
 */

public class Hospital2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nombre, descripcion, codigo;
        PriorityQueue<Paciente> pq = new PriorityQueue<>();
        
        FileReader fr;
        BufferedReader br;
        
        fr = new FileReader("pacientes.txt");
        br = new BufferedReader(fr);

        String linea;

        System.out.println("Lista de pacientes: \n");
        while((linea=br.readLine())!=null){
            int lugar1 = linea.indexOf(',');
            nombre = linea.substring(0, lugar1);
            String resto = linea.substring(lugar1+2);
            int lugar2 = resto.indexOf(',');
            descripcion = resto.substring(0, lugar2);
            codigo = resto.substring(lugar2+2);
            System.out.println(linea);
            Paciente enfermo = new Paciente(nombre, descripcion, codigo);
            pq.add(enfermo);
        }
        
        System.out.println("\nPacientes atendidos en orden: \n");
        while(!pq.isEmpty()){
            Paciente siguiente = pq.poll();
            System.out.println(siguiente.getNombre()+", "+siguiente.getDescripcion()+", "+siguiente.getCodigo());
        }
    }
    
}