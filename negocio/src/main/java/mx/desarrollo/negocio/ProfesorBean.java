package mx.desarrollo.negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import mx.desarrollo.entidad.Profesor;

@ManagedBean
@SessionScoped
public class ProfesorBean implements Serializable {

    private static final long serialVersionUID = 1L; // Para evitar advertencias de Serializable

    private Profesor profesor;
    private boolean mostrarFormulario;

    public ProfesorBean() {
        this.profesor = new Profesor();  // Se inicializa para evitar NullPointerException
        this.mostrarFormulario = false; // Se inicializa en falso
    }

    // Getters y Setters
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean isMostrarFormulario() {
        return mostrarFormulario;
    }

    public void setMostrarFormulario(boolean mostrarFormulario) {
        this.mostrarFormulario = mostrarFormulario;
    }

    // Método para mostrar el formulario
    public void activarFormulario() {
    System.out.println("Mostrando formulario...");
    this.mostrarFormulario = true;
}

    // Método para ocultar el formulario
    public void ocultarFormulario() {
        System.out.println("Ocultando formulario...");
        this.mostrarFormulario = false;
    }

    // Método para guardar un profesor
    public void guardarProfesor() {
        if (profesor != null) {
            System.out.println("Guardando Profesor: " + profesor.getNombre());
        } else {
            System.out.println("ERROR: Profesor es null");
        }
        
        // Resetear el objeto después de guardar
        this.profesor = new Profesor();
        this.mostrarFormulario = false;
    }
}
