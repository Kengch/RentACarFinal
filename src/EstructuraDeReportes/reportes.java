/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeReportes;
import EstructuraDeVehiculos.listaDeVehiculos;
import EstructuraDeSolicitudes.listaDeSolicitudes;
import EstructuraDeClientes.BinaryTreeClientes;
/**
 *
 * @author Keng
 */
public class reportes {
    private listaDeSolicitudes solicitudes;
    private listaDeVehiculos vehiculos;
    public reportes(listaDeSolicitudes _solicitudes, listaDeVehiculos _vehiculos){
        this.solicitudes = _solicitudes;
        this.vehiculos = _vehiculos;
    }
    
    public void reportesAlquileresRealizados(){
        solicitudes.reporte();
    }
    
    public void reporteDeVehiculo(){
        vehiculos.reporte();
    }
}
