/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeSolicitudes;

import EstructuraDeClientes.BinaryTreeClientes;
import EstructuraDeClientes.persona;
import EstructuraDeVehiculos.listaDeVehiculos;
import java.util.Scanner;
import EstructuraDeVehiculos.vehiculo;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Keng
 */
public class listaDeSolicitudes {
    private node inicio;
    private int tamaño;
    private BinaryTreeClientes listaClientes;
    private listaDeVehiculos listaVehiculos;
    
    public listaDeSolicitudes(BinaryTreeClientes listaClientes, listaDeVehiculos listaVehiculos){
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
    
    public void crearSolicitud(persona _cliente){
        if ( this.listaClientes.existeCliente(_cliente) == false) {
          System.out.println("El usuario no existe en la lista de personas");
        }
        
        Scanner sc = new Scanner (System.in);
        solicitud  soli = new solicitud();
        System.out.println("Digite los dias de reserva");
        int diasReserva = Integer.parseInt(sc.nextLine());
        soli.setDias(diasReserva);
        
        System.out.println("Digite la cantidad de pasajeros");
        int pasajeros = Integer.parseInt(sc.nextLine());
        soli.setPasajeros(pasajeros);
        
        System.out.println("Desea una marca en especifico? \n1-Si \n2-No");
        if (Integer.parseInt(sc.nextLine()) == 1) {
            this.listaVehiculos.obtenerMarca();
            System.out.println("Digite la marca");
            soli.setPreferenciaMarca(sc.nextLine());
        }
        System.out.println("Desea una modelo en especifico? \n1-Si \n2-No");
        if (Integer.parseInt(sc.nextLine()) == 1) {
            this.listaVehiculos.obtenerModelo();
            System.out.println("Digite el modelo");
            soli.setPreferenciaModelo(sc.nextLine());
        }
        
        System.out.println("Desea una año en especifico? \n1-Si \n2-No");
        if (Integer.parseInt(sc.nextLine()) == 1) {
            this.listaVehiculos.obtenerAño();
            System.out.println("Digite el del año");
            soli.setPreferenciaAño(Integer.parseInt(sc.nextLine()));
        }
     
        
       /* System.out.println("Requiere un extra? \n1-Si \n2-No");
        if (Integer.parseInt(sc.nextLine()) == 1) {
            this.listaVehiculos.obtenerExtra();
            System.out.println("Digite el id de la extra");
            soli.setPreferenciaExtra(Integer.parseInt(sc.nextLine()));
        }*/
        
        if (diasReserva >= 30) {
            if (_cliente.getCategoria() == "Bronce") {
                _cliente.setCategoria("Plata");
            }
            else if (_cliente.getCategoria() == "Plata") {
                _cliente.setCategoria("Oro");
            }
            else if (_cliente.getCategoria() == "Oro") {
                _cliente.setCategoria("Zafiro");
            }
        }
        
        soli.setCliente(_cliente);
        soli.setEstado("Registrada");
        node nuevo = new node();
        nuevo.setValor(soli);
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
    
    public void listaSolicitudes(){
        if(esVacio() == true){
            System.out.println("La lista de solicitudes esta vacia");
        }else{
            node aux = inicio;
            int i = 0;
            while(aux != null){
                System.out.println(i + "- solicitud "+ aux.getValor().getEstado() +" de: " + aux.getValor().getCliente().getNombre() + " esta " + aux.getValor().getEstado() + " placa del carro: " + aux.getValor().getPlaca() + " monto: " + aux.getValor().getMonto() + " estado del carro " + aux.getValor().getEstado());
                        
 
                aux = aux.getNext();
                 
                i++;
            }
        }
    }
    
    public void asignarVehiculo(){
        if(esVacio() == true){
            System.out.println("La lista de solicitudes esta vacia");
        }else{
           node aux = inicio;
           vehiculo _vehiculo = null;
           double _monto = 0;
           while(aux != null ){
               _vehiculo = listaVehiculos.asignarVehiculo(aux.getValor().getCliente(), aux.getValor());
                   if (_vehiculo != null) {
                       aux.getValor().setEstado("Alquilado");
                       aux.getValor().setPlaca(_vehiculo.getPlaca());
                       
                       _vehiculo.setStatus("Alquilado");
                       _monto = (13*(_monto = aux.getValor().getDias()*_vehiculo.getPrecioXdia()))/100;
                       aux.getValor().setMonto(_monto);
                       if (_monto > 70000) {
                            if ( aux.getValor().getCliente().getCategoria() == "Bronce") {
                                aux.getValor().getCliente().setCategoria("Plata");
                            }
                            else if ( aux.getValor().getCliente().getCategoria() == "Plata") {
                                aux.getValor().getCliente().setCategoria("Oro");
                            }
                            else if ( aux.getValor().getCliente().getCategoria() == "Oro") {
                                aux.getValor().getCliente().setCategoria("Zafiro");
                            }
                       }
                   }
                   else{
                       System.out.println("La preferencia seleccionada no esta disponible");
                       aux.getValor().setEstado("Rechazado");
                   }
               aux = aux.getNext();
           }
        }
    }
    
    public void consulta(){
        if(esVacio() == true){
            System.out.println("La lista de solicitudes esta vacia");
        }else{
           Scanner sc = new Scanner (System.in);
           System.out.println("1) Numero de placa \n2) Cedula del jugador \n3) Estado de solicitud");
           int item = Integer.parseInt(sc.nextLine());
            if (item == 1) {
                System.out.println("Digite su numero de placa");
                String placa = sc.nextLine();
                node aux = inicio;
                while(aux != null){
                    if (aux.getValor().getPlaca() == placa) {
                        System.out.print("La solicitud " + " de: " + aux.getValor().getCliente().getNombre() + " placa del carro: " 
                                + aux.getValor().getPlaca() + " monto: " + aux.getValor().getMonto() + " estado del carro " + aux.getValor().getEstado());
                    }
                   aux = aux.getNext(); 
                }
            }
            else if (item == 2) {
                System.out.println("Digite la cedula del jugador");
                int cedula = Integer.parseInt(sc.nextLine());
                node aux = inicio;
                while(aux != null){
                    if (aux.getValor().getCliente().getCedula() == cedula) {
                        System.out.print("La solicitud " + " de: " + aux.getValor().getCliente().getNombre() + " placa del carro: " 
                                + aux.getValor().getPlaca() + " monto: " + aux.getValor().getMonto() + " estado del carro " + aux.getValor().getEstado());
                    }
                    aux = aux.getNext();
                }
            }
            else if (item == 3) {
                node aux = inicio;
                while(aux != null){
                    
                    if (aux.getValor().getEstado() == "Procesada") {
                        System.out.print("La solicitud " + " de: " + aux.getValor().getCliente().getNombre() + " placa del carro: " 
                                + aux.getValor().getPlaca() + " monto: " + aux.getValor().getMonto() + " estado del carro " + aux.getValor().getEstado());
                    }
                    aux = aux.getNext();
                }
            }
            else{
                System.out.println("Item no valido");
            }
        }
    }
    
    public boolean devolucionVehiculos(){
        Scanner sc = new Scanner (System.in);
        if(esVacio() == true){
            System.out.println("La lista de solicitudes esta vacia");
        }
        else{
            System.out.println("Digite el numero de cedula");
            int cedula = Integer.parseInt(sc.nextLine());
            System.out.println("Digite la placa");
            String placa = sc.nextLine();
            System.out.println("Digite la condicion del vehiculo");
            String condicion = sc.nextLine();
            node aux = inicio;
            while(aux != null){
                if (aux.getValor().getPlaca().trim() == placa.trim()) {
                    aux.getValor().setEstado("Finalizada");
                    listaVehiculos.modificarEstado(placa);
                    break;
                }
                aux = aux.getNext();
            }
        }
        return false;
    }
    
    public void reporte(){
        if(esVacio() == true){
            System.out.println("La lista de solicitudes esta vacia");
        }
        else{
            persona cliente1 = null;
            persona cliente2 = null;
            persona cliente3 = null;
            persona cliente4 = null;
            persona cliente5 = null;
            int contador = 0;
            int mayor1 = 0;
            node aux = inicio;
            while(aux != null){
                node aux2 = inicio;
                contador = 0;
                while(aux2 != null){
                    if (aux2.getValor().getEstado() == "Procesada") {
                        contador++;
                    }
                    aux2 = aux2.getNext();
                }
                if (mayor1 < contador) {
                    cliente5 = cliente4;
                    cliente4 = cliente3;
                    cliente3 = cliente2;
                    cliente2 = cliente1;
                    cliente1 = aux2.getValor().getCliente();
                }
                aux = aux.getNext();
            }
            if (cliente1 != null) {
                System.out.println("1- " + cliente1.getNombre() + " " + cliente1.getCedula());
            }
            if (cliente2 != null) {
                System.out.println("2- " + cliente2.getNombre() + " " + cliente2.getCedula());
            }
            if (cliente3 != null) {
                System.out.println("3- " + cliente3.getNombre() + " " + cliente3.getCedula());
            }
            if (cliente4 != null) {
                System.out.println("4- " + cliente4.getNombre() + " " + cliente4.getCedula());
            }
            if (cliente5 != null) {
                System.out.println("5- " + cliente5.getNombre() + " " + cliente5.getCedula());
            }
        }
    }
}
