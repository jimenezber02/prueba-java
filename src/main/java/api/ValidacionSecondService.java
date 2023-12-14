/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import java.time.LocalDate;

/**
 *
 * @author Bernabé Jiménez
 */
@ApplicationScoped
public class ValidacionSecondService {
    @Inject
    SecondService ss;
    
    public void validarNombre(String nombre) {
        if (!ss.validaNombre(nombre)) {
            throw new BadRequestException("Error en el nombre");
        }
    }
    
    public void validarEdad(LocalDate fecha) {
        if (!ss.validaEdad(fecha)) {
            throw new BadRequestException("Error en la edad");
        }
    }

    public void validarCedula(String cedula) {
        if (!ss.validaCedula(cedula)) {
            throw new BadRequestException("Error en la cedula");
        }
    }
}
