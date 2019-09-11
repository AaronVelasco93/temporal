/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_generica;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Aaron
 */
public class UsoEmpleado {
    
    public static void main(String[] args) {
       
        /*
        Empleado listaEmpleados [] = new Empleado[3];
            
        listaEmpleados[0] = new Empleado("Aaron", 24, 8500);
        listaEmpleados[1] = new Empleado("Analia", 24, 8000);
        listaEmpleados[2] = new Empleado("Jesus", 26, 11000);
        */
        //array 
        ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
        
       // listaEmpleado.ensureCapacity(9);//tamaño inicial
        
              
        listaEmpleado.add(new Empleado("Aaron", 24, 8500));
        listaEmpleado.add(new Empleado("Analia", 24, 8000));
        listaEmpleado.add(new Empleado("Jesus", 26, 11000));
        listaEmpleado.add(new Empleado("Jose", 35, 1500));
        listaEmpleado.add(new Empleado("Jose", 35, 1500));
        listaEmpleado.add(new Empleado("Aaron", 24, 8500));
        listaEmpleado.add(new Empleado("Analia||", 24, 8000));
        listaEmpleado.add(new Empleado("Jesus2", 26, 11000));
        listaEmpleado.add(new Empleado("Jose3", 35, 1500));
        listaEmpleado.add(new Empleado("Jose4", 35, 1500));
        listaEmpleado.add(new Empleado("Aaron5", 24, 8500));
        listaEmpleado.add(new Empleado("Analia6", 24, 8000));
        listaEmpleado.add(new Empleado("Jesus7", 26, 11000));
        listaEmpleado.add(new Empleado("Jose8", 35, 1500));
        listaEmpleado.add(new Empleado("Jose9", 35, 1500));
        listaEmpleado.add(new Empleado("Aaron0", 24, 8500));
        listaEmpleado.add(new Empleado("Analia1", 24, 8000));
        listaEmpleado.add(new Empleado("Jesus2", 26, 11000));
        listaEmpleado.add(new Empleado("Jose3", 35, 1500));
        listaEmpleado.add(new Empleado("Jose45", 35, 1500));
       
        /* 
       listaEmpleado.trimToSize();
       listaEmpleado.add(new Empleado("Olga", 35, 1500));
        
       listaEmpleado.set(1, new Empleado("Olga", 35, 1500));
       
        System.out.println(listaEmpleado.get(4).dameDatos());
       
        System.out.println(listaEmpleado.size());
        */
        /*
        for(Empleado e:listaEmpleado){
            System.out.println(e.dameDatos());
        }
        */
        Iterator<Empleado> mi_iterador=  listaEmpleado.iterator();
        
        while (mi_iterador.hasNext()) {          
            
            System.out.println(mi_iterador.next().dameDatos());
        }
        
        /*
        
        for (int i=0; i<listaEmpleado.size();i++){
            
            Empleado e = listaEmpleado.get(i);
            
            System.out.println(i+" "+e.dameDatos());
        }
        */
    }
    
}

class Empleado{
    //contructor
    public Empleado (String nombre, int edad, double salario){
    
        this.nombre = nombre;
        this.edad=edad;
        this.salario=salario;
        
    }

    
    
    public String dameDatos(){//get
        return "El empleado se llama: "+nombre+" .Tiene: "+edad+"años. Y un salario de "+salario;
    }
    //encapsulamiento
    private String nombre;
    private int edad;
    private double salario;

}
