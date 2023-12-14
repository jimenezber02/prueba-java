/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bernabé Jiménez
 */
@ApplicationScoped
public class SecondService {
    
    public boolean validaNombre(String nombre) {
        // Expresión regular para permitir letras del alfabeto, espacios en blanco y letras con tilde
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚ\\s]*$";
        return nombre != null && nombre.matches(regex);
    }
    
    public Persona getPersona(Persona p){
        return p;
    }
    
    public int edadActual(LocalDate fecha_nacimiento){
        LocalDate fecha_actual = LocalDate.now();
      
        //En esta variable se obtiene el tiempo trancurrido
        Period p = Period.between(fecha_nacimiento,fecha_actual);
        
        return p.getYears();
    }
    
    public boolean validaEdad(LocalDate fecha){
        int edad = edadActual(fecha);
        
        return edad>=18 && edad<51;
    }
    
    public boolean validaCedula(String cedula) {
        // Expresión regular para la cedula con formato 00-0000-00000
        String regex = "\\d{2}-\\d{4}-\\d{5}";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher
        Matcher matcher = pattern.matcher(cedula);

        // Verificar si la cadena coincide con el formato esperado
        return matcher.matches();
    }
}
