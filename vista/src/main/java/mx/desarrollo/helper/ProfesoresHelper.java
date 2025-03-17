/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.List;
import mx.desarrollo.entidad.Profesores;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author danal
 */
public class ProfesoresHelper implements Serializable {
    
    public Profesores registrarProfesor(int idProfesor, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().registrarProfesor(nombre, apellidoPaterno, apellidoMaterno, rfc);
    }
    
    public void guardarProfesor(Profesores profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesores().guardarProfesor(profesor);
    }
    
    public List<Profesores> getProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().mostrarProfesores();
    }
    
    public void eliminarProfesor(int idProfesor){
        ServiceFacadeLocator.getInstanceFacadeProfesores().eliminarProfesor(idProfesor);
    }
}