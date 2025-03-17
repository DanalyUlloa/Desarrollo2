/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.facade.FacadeAlumno;
import mx.desarrollo.facade.FacadeUsuario;
import mx.desarrollo.facade.FacadeProfesores;

/**
 *
 * @author EduardoCardona <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeProfesores facadeProfesores;
    private static FacadeAlumno facadeAlumno;
    private static FacadeUsuario facadeUsuario;
    
    public static FacadeProfesores getInstanceFacadeProfesores() {
        if (facadeProfesores == null) {
            facadeProfesores = new FacadeProfesores();
            return facadeProfesores;
        } else {
            return facadeProfesores;
        }
    }
    
    public static FacadeAlumno getInstanceFacadeAlumno() {
        if (facadeAlumno == null) {
            facadeAlumno = new FacadeAlumno();
            return facadeAlumno;
        } else {
            return facadeAlumno;
        }
    }
    
    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
}
