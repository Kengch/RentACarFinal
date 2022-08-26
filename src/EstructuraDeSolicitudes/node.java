/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeSolicitudes;

/**
 *
 * @author Keng
 */
public class node {
    private solicitud valor;
    private node next;
    
    public node(){
        this.valor = null;
        this.next = null;
    }

    public solicitud getValor() {
        return valor;
    }

    public void setValor(solicitud valor) {
        this.valor = valor;
    }

    public node getNext() {
        return next;
    }

    public void setNext(node next) {
        this.next = next;
    }
}
