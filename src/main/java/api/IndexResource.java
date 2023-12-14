/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author Bernabé Jiménez
 */
@Path("/api")
public class IndexResource {
    @Inject
    FirstService fs;
    
    @Inject
    SecondService ss;
    @Inject
    ValidacionSecondService vs;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/romano/{numero}")
    public Response numero(@PathParam("numero") int numero) {
        String romano = fs.convertRomano(numero);
        String resp = "{numero} = "+numero+", respuesta = "+romano;
        return Response.status(200)
            .entity(resp)
            .build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Persona p){
        try {
            vs.validarNombre(p.getNombre());
            vs.validarEdad(p.getFecha());
            vs.validarCedula(p.getCedula());
            
            int edad_actual = ss.edadActual(p.getFecha());
            String romano = fs.convertRomano(edad_actual);

            p.setEdad(edad_actual);
            p.setRomano(romano);
            
            return Response.status(200).entity(p.toString()).build();
        } catch (Exception e) {
            return Response.status(404).entity("Error "+e).build();
        }
    }
}
