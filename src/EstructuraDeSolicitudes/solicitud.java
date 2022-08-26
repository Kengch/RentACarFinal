/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeSolicitudes;

import EstructuraDeClientes.persona;

/**
 *
 * @author Keng
 */
public class solicitud {
    private int dias;
    private int pasajeros;
    private String preferenciaMarca;
    private String preferenciaModelo;
    private int preferenciaAño;
    private String preferenciaExtra;
    private String estado;
    private persona cliente;
    private String placa;
    private double monto;
    
    public solicitud(){
        this.dias = 0;
        this.pasajeros = 0;
        this.preferenciaModelo = "";
        this.preferenciaMarca = "";
        this.preferenciaAño = 0;
        this.preferenciaExtra = "";
        this.estado = "";
        this.cliente = null;
        this.placa = "";
        this.monto = 0;
        //bronce 0, plata 1, oro 2, zafiro 3
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getPreferenciaMarca() {
        return preferenciaMarca;
    }

    public void setPreferenciaMarca(String preferenciaMarca) {
        this.preferenciaMarca = preferenciaMarca;
    }

    public String getPreferenciaModelo() {
        return preferenciaModelo;
    }

    public void setPreferenciaModelo(String preferenciaModelo) {
        this.preferenciaModelo = preferenciaModelo;
    }

    public int getPreferenciaAño() {
        return preferenciaAño;
    }

    public void setPreferenciaAño(int preferenciaAño) {
        this.preferenciaAño = preferenciaAño;
    }

    public String getPreferenciaExtra() {
        return preferenciaExtra;
    }

    public void setPreferenciaExtra(String preferenciaExtra) {
        this.preferenciaExtra = preferenciaExtra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public persona getCliente() {
        return cliente;
    }

    public void setCliente(persona cliente) {
        this.cliente = cliente;
    }

}
