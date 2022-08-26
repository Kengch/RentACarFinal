/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeReservas;

/**
 *
 * @author Keng
 */
public class node {
    private reserva valor;
    private node next;
    
    public node(){
        this.valor = null;
        this.next = null;
    }

    public reserva getValor() {
        return valor;
    }

    public void setValor(reserva valor) {
        this.valor = valor;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }

    
}
