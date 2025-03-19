/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.entidad.Profesor;
/**
 *
 * @author danal
 */
public class FacadeProfesor {
    
    private  DelegateProfesor delegateProfesor;
    
    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    public Profesor registrarProfesores(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc) {
        return delegateProfesor.altaProfesor(nombre, apellidoPaterno, apellidoMaterno, rfc);
    }
    
    public void guardarProfesores(Profesor profesor) {
        delegateProfesor.guardarProfesor(profesor);
    }
    
    public List<Profesor> mostrarProfesores() {
        return delegateProfesor.mostrarProfesores();
    }
    
    public void eliminarProfesores(int idProfesor) {
        delegateProfesor.eliminarProfesor(idProfesor);
    }
}
