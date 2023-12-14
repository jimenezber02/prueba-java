/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import jakarta.enterprise.context.ApplicationScoped;

/**
 *
 * @author Bernabé Jiménez
 */
@ApplicationScoped
public class FirstService {
 
    public String convertRomano(int numero){
        String [] unidades = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] decenas = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] centenas = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String [] miles = {"","M","MM","MMM",};
        
        int index_miles;
        int index_cent;
        int index_dec;
        int index_uni;
        
        index_miles = numero / 1000;
        numero = numero % 1000;
        
        index_cent = numero / 100;
        numero = numero % 100;
        
        index_dec = numero / 10;
        numero = numero % 10;
        
        index_uni = numero;
        
        String resp = miles[index_miles]
            .concat(centenas[index_cent])
            .concat(decenas[index_dec])
            .concat(unidades[index_uni]);
        
        return resp;
    }
}
