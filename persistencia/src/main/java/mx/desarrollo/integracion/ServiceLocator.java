/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.DAO.AlumnoDAO;
import mx.desarrollo.DAO.ProfesoresDAO;
import mx.desarrollo.DAO.UnidadAprendizajeDAO;
import mx.desarrollo.DAO.UsuarioDAO;

/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static AlumnoDAO alumnoDAO;
    private static UsuarioDAO usuarioDAO;
    private static ProfesoresDAO profesoresDAO;
    private static UnidadAprendizajeDAO unidadAprendizajeDAO;
    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
     public static UnidadAprendizajeDAO  getInstanceUnidadAPrendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadAprendizajeDAO ();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
        }
    
        public static ProfesoresDAO getInstanceProfesoresDAO(){
        if(profesoresDAO == null){
            profesoresDAO = new ProfesoresDAO();
            return profesoresDAO;
        } else{
            return profesoresDAO;
        }
    }
    
    public static AlumnoDAO getInstanceAlumnoDAO(){
        if(alumnoDAO == null){
            alumnoDAO = new AlumnoDAO();
            return alumnoDAO;
        } else{
            return alumnoDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
}
