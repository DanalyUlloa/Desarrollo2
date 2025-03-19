/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.facade.FacadeUnidadAprendizaje;

/**
 *
 * @author PC
 */
@Named("unidadBean")
@ViewScoped
public class UnidadBean implements Serializable{
    private static final long serialVersionUID = 1L; // Para evitar advertencias de Serializable

    private UnidadAprendizaje unidadAprendizaje = new UnidadAprendizaje();
    private boolean mostrarFormulario;
    private DelegateUnidadAprendizaje delegateUnidad;
    private List<UnidadAprendizaje> listaUnidades; 

    public UnidadBean() {
        delegateUnidad = new DelegateUnidadAprendizaje();  // Instancia la fachada
        unidadAprendizaje = new UnidadAprendizaje();  // Crea una nueva unidad vacía
        listaUnidades =delegateUnidad.mostrarUnidadAprendizaje();
    }

    // Getters y Setters
    public UnidadAprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }

    public boolean isMostrarFormulario() {
        return mostrarFormulario;
    }

    public void setMostrarFormulario(boolean mostrarFormulario) {
        this.mostrarFormulario = mostrarFormulario;
    }

    // Método para mostrar el formulario
    public void mostrarFormulario() {
        System.out.println("Mostrando formulario...");
        this.mostrarFormulario = true;
    }

    // Método para ocultar el formulario
    public void ocultarFormulario() {
        System.out.println("Ocultando formulario...");
        this.mostrarFormulario = false;
    }
    
    public List<UnidadAprendizaje> getListaUnidades() {
        return listaUnidades;
    }

    // Método para guardar un profesor
    public void guardarUnidad() {
        
     if (unidadAprendizaje.getClaveUnidadAprendizaje() != 0 && !unidadAprendizaje.getNombreUnidad().isEmpty()) {
            // Llamar al delegado para guardar la unidad
            delegateUnidad.guardarUnidadAprendizaje(unidadAprendizaje);
            // Limpiar el formulario después de guardar
            unidadAprendizaje = new UnidadAprendizaje();  // Reinicia el objeto para limpiar los campos
        }
       
    }
}
