/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeReservas;
import EstructuraDeVehiculos.listaDeVehiculos;
import EstructuraDeVehiculos.vehiculo;
import EstructuraDeClientes.BinaryTreeClientes;
import EstructuraDeClientes.persona;

/**
 *
 * @author Keng
 */
public class reserva {
    private vehiculo vehiculo;
    private persona cliente;
   
    
    public reserva(){
        this.vehiculo = null;
        this.cliente = null;
    }

    public vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public persona getCliente() {
        return cliente;
    }

    public void setCliente(persona cliente) {
        this.cliente = cliente;
    }

 

}
