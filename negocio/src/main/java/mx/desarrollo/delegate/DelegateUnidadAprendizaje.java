/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;
import java.util.List;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author PC
 */
public class DelegateUnidadAprendizaje {
    
     public UnidadAprendizaje altaUnidadAprendizaje(Integer claveUnidadAprendizaje, String nombreUnidad, int horasclase, int horastaller, int horaslaboratorio) {
        validarclaveUnidadAprendizaje(claveUnidadAprendizaje);
        validarnombreUnidad(nombreUnidad);
        validarhorasclase(horasclase);
        validarhorastaller(horastaller);
        validarhoraslaboratorio(horaslaboratorio);

        UnidadAprendizaje unidadAprendizaje = new UnidadAprendizaje();
        unidadAprendizaje.setClaveUnidadAprendizaje(claveUnidadAprendizaje);
        unidadAprendizaje.setNombreUnidad(nombreUnidad);
        unidadAprendizaje.setHorasclase(horasclase);
        unidadAprendizaje.setHorastaller(horasclase);
        unidadAprendizaje.setHoraslaboratorio(horasclase);

        return unidadAprendizaje;
    }
     
     public void guardarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadAprendizaje);
    }
    
    public List<UnidadAprendizaje> mostrarUnidadAprendizaje() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }
    
    public void eliminarUnidadAprendizaje(int claveUnidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().eliminarUnidad(claveUnidadAprendizaje);
    }
    
    private void validarclaveUnidadAprendizaje(Integer claveUnidadAprendizaje) {
        if (claveUnidadAprendizaje == null) {
        throw new IllegalArgumentException("La clave de la unidad de aprendizaje no puede ser nula.");
    }
    }
    
    private void validarnombreUnidad(String nombreUnidad) {
        if (nombreUnidad == null || nombreUnidad.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
    
    private void validarhorasclase(int horasclase) {
    if (horasclase <= 0) {
        throw new IllegalArgumentException("Solo valores positivos.");
        }
    }
    
    private void validarhorastaller(int horastaller) {
    if (horastaller <= 0) {
        throw new IllegalArgumentException("Solo valores positivos.");
        }
    }
    
    private void validarhoraslaboratorio(int horaslaboratorio) {
    if (horaslaboratorio <= 0) {
        throw new IllegalArgumentException("Solo valores positivos.");
        }
    }
    
}
