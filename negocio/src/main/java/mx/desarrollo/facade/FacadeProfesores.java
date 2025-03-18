/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.DelegateProfesores;
import mx.desarrollo.entidad.Profesor;
/**
 *
 * @author danal
 */
public class FacadeProfesores {
    
    private DelegateProfesores delegateProfesores;
    
    public FacadeProfesores() {
        this.delegateProfesores = new DelegateProfesores();
    }
    public Profesor registrarProfesor(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc) {
        return delegateProfesores.altaProfesor(nombre, apellidoPaterno, apellidoMaterno, rfc);
    }
    
    public void guardarProfesor(Profesor profesor) {
        delegateProfesores.guardarProfesor(profesor);
    }
    
    public List<Profesor> mostrarProfesores() {
        return delegateProfesores.mostrarProfesores();
    }
    
    public void eliminarProfesor(int idProfesor) {
        delegateProfesores.eliminarProfesor(idProfesor);
    }
}
