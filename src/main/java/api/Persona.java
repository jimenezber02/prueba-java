/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import java.time.LocalDate;

/**
 *
 * @author Bernabé Jiménez
 */
public class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fecha;
    private String cedula;
    private int edad;
    private String romano;

    public Persona(String nombre, String apellido, LocalDate fecha, String ced) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.cedula = ced;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRomano(String romano) {
        this.romano = romano;
    }

    public int getEdad() {
        return edad;
    }

    public String getRomano() {
        return romano;
    }

    @Override
    public String toString() {
        return "{" + "nombre:" + nombre+" "+apellido + ", edad:" + edad + ", romano:" + romano + '}';
    }

    
}
