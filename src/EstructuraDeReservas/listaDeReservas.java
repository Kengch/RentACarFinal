/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeReservas;
import EstructuraDeVehiculos.listaDeVehiculos;
import EstructuraDeVehiculos.vehiculo;
import EstructuraDeClientes.BinaryTreeClientes;
import EstructuraDeClientes.persona;
import java.util.Scanner;
/**
 *
 * @author Keng
 */
public class listaDeReservas {
    private node inicio;
    private int tamaño;
    private BinaryTreeClientes listaClientes;
    private listaDeVehiculos listaVehiculos;
    
    public listaDeReservas(BinaryTreeClientes listaClientes, listaDeVehiculos listaVehiculos){
        this.inicio = null;
        this.tamaño = 0;
        this.listaClientes = listaClientes;
        this.listaVehiculos = listaVehiculos;
    }
    
    public Boolean esVacio(){
        if (inicio == null) {
            return true;
        }
        return false;
    }
    
    public void crearReserva(vehiculo _vehiculo, persona _cliente){
        if ( this.listaClientes.existeCliente(_cliente) == false) {
          System.out.println("El usuario no existe en la lista de personas");
        }
        if ( this.listaVehiculos.existeVehiculo(_vehiculo) == false) {
          System.out.println("El vehiculo no existe en la lista de vehiculos");
        }
        
       

        reserva _reserva = new reserva();
        
        _reserva.setVehiculo(_vehiculo);
        _reserva.setCliente(_cliente);
        
        node nuevo = new node();
        nuevo.setValor(_reserva);
        
        if (esVacio()) {
            inicio = nuevo;
        }
        else{
            node aux = inicio;
            while(aux.getNext() != null){
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
        }
        tamaño++;
    }
}
