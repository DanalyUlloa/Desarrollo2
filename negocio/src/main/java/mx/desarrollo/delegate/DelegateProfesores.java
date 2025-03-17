/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;
import java.util.List;
import mx.desarrollo.entidad.Profesores;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author danal
 */
public class DelegateProfesores {
    
    public Profesores altaProfesor(String nombre, String apellidoPaterno, String apellidoMaterno, String rfc) {
        validarNombre(nombre);
        validarApellidoPaterno(apellidoPaterno);
        validarApellidoMaterno(apellidoMaterno);
        validarRfc(rfc);

        Profesores profesor = new Profesores();
        profesor.setNombre(nombre);
        profesor.setApellidoPaterno(apellidoPaterno);
        profesor.setRfc(rfc);

        return profesor;
    }
    
    public void guardarProfesor(Profesores profesor) {
        ServiceLocator.getInstanceProfesoresDAO().save(profesor);
    }
    
    public List<Profesores> mostrarProfesores() {
        return ServiceLocator.getInstanceProfesoresDAO().findAll();
    }
    
    public void eliminarProfesor(int idProfesor) {
        ServiceLocator.getInstanceProfesoresDAO().eliminarProfesorId(idProfesor);
    }
    
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
    
    private void validarApellidoPaterno(String apellidoPaterno) {
        if (apellidoPaterno == null || apellidoPaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
    }
    
    private void validarApellidoMaterno (String apellidoMaterno) {
        if (apellidoMaterno == null || apellidoMaterno.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
    }
    
    private void validarRfc(String rfc) {
        if (rfc == null || rfc.length() != 13) {
            throw new IllegalArgumentException("El RFC debe tener exactamente 13 caracteres.");
        }

        if (!rfc.matches("[A-ZÑ&]{4}[0-9]{6}[A-Z0-9]{3}")) {
            throw new IllegalArgumentException("El formato del RFC no es válido.");
        }
    }
}
