/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.negocio;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.DAO.UsuarioDAO;
import mx.desarrollo.entidad.Usuario;

/**
 *
 * @author PC
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class UsuarioBean {
     private Usuario usuario = new Usuario();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public String login() {
        Usuario usuarioAutenticado = usuarioDAO.autenticar(usuario.getCorreo(), usuario.getContrasena());

        if (usuarioAutenticado != null) {
            // Guardar usuario en sesión
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioAutenticado);
            return "home.xhtml?faces-redirect=true"; // Redirige al home
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Credenciales incorrectas"));
            return null; // Permanece en la página de login
        }
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}

