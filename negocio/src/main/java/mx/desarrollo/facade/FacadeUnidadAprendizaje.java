/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;
import java.util.List;
import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entidad.UnidadAprendizaje;

/**
 *
 * @author PC
 */
public class FacadeUnidadAprendizaje {
    
    private DelegateUnidadAprendizaje delegateUnidadAprendizaje;
    
    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }
    public UnidadAprendizaje registrarUnidadAprendizaje(Integer claveUnidadAprendizaje, String nombreUnidad, int horasclase, int horastaller, int horaslaboratorio) {
        return delegateUnidadAprendizaje.altaUnidadAprendizaje( claveUnidadAprendizaje, nombreUnidad, horasclase, horastaller, horaslaboratorio);
    }
    
    public void guardarProfesor(UnidadAprendizaje unidadAprendizaje) {
        delegateUnidadAprendizaje.guardarUnidadAprendizaje(unidadAprendizaje);
    }
    
    public List<UnidadAprendizaje> mostrarUnidadAprendizaje() {
        return delegateUnidadAprendizaje.mostrarUnidadAprendizaje();
    }
    
    public void eliminarProfesor(int claveUnidadAprendizaje) {
        delegateUnidadAprendizaje.eliminarUnidadAprendizaje(claveUnidadAprendizaje);
    }
}
