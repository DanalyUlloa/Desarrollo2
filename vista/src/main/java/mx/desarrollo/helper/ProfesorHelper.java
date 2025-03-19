/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author danal
 */
public class ProfesorHelper implements Serializable {
    
    public Profesor registrarProfesor(int idProfesor, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().registrarProfesores(nombre, apellidoPaterno, apellidoMaterno, rfc);
    }
    
    public void guardarProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesores().guardarProfesores(profesor);
    }
    
    public List<Profesor> getProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesores().mostrarProfesores();
    }
    
    public void eliminarProfesor(int idProfesor){
        ServiceFacadeLocator.getInstanceFacadeProfesores().eliminarProfesores(idProfesor);
    }
}