/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "unidad_aprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadAprendizaje.findAll", query = "SELECT u FROM UnidadAprendizaje u")
    , @NamedQuery(name = "UnidadAprendizaje.findByClaveUnidadAprendizaje", query = "SELECT u FROM UnidadAprendizaje u WHERE u.claveUnidadAprendizaje = :claveUnidadAprendizaje")
    , @NamedQuery(name = "UnidadAprendizaje.findByNombreUnidad", query = "SELECT u FROM UnidadAprendizaje u WHERE u.nombreUnidad = :nombreUnidad")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorasclase", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horasclase = :horasclase")
    , @NamedQuery(name = "UnidadAprendizaje.findByHorastaller", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horastaller = :horastaller")
    , @NamedQuery(name = "UnidadAprendizaje.findByHoraslaboratorio", query = "SELECT u FROM UnidadAprendizaje u WHERE u.horaslaboratorio = :horaslaboratorio")})
public class UnidadAprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "claveUnidadAprendizaje")
    private Integer claveUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "NombreUnidad")
    private String nombreUnidad;
    @Basic(optional = false)
    @Column(name = "Horasclase")
    private int horasclase;
    @Basic(optional = false)
    @Column(name = "Horastaller")
    private int horastaller;
    @Basic(optional = false)
    @Column(name = "Horaslaboratorio")
    private int horaslaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claveUnidadAprendizaje")
    private List<ProfesorUnidad> profesorUnidadList;

    public UnidadAprendizaje() {
    }

    public UnidadAprendizaje(Integer claveUnidadAprendizaje) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
    }

    public UnidadAprendizaje(Integer claveUnidadAprendizaje, String nombreUnidad, int horasclase, int horastaller, int horaslaboratorio) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
        this.nombreUnidad = nombreUnidad;
        this.horasclase = horasclase;
        this.horastaller = horastaller;
        this.horaslaboratorio = horaslaboratorio;
    }

    public Integer getClaveUnidadAprendizaje() {
        return claveUnidadAprendizaje;
    }

    public void setClaveUnidadAprendizaje(Integer claveUnidadAprendizaje) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public int getHorasclase() {
        return horasclase;
    }

    public void setHorasclase(int horasclase) {
        this.horasclase = horasclase;
    }

    public int getHorastaller() {
        return horastaller;
    }

    public void setHorastaller(int horastaller) {
        this.horastaller = horastaller;
    }

    public int getHoraslaboratorio() {
        return horaslaboratorio;
    }

    public void setHoraslaboratorio(int horaslaboratorio) {
        this.horaslaboratorio = horaslaboratorio;
    }

    @XmlTransient
    public List<ProfesorUnidad> getProfesorUnidadList() {
        return profesorUnidadList;
    }

    public void setProfesorUnidadList(List<ProfesorUnidad> profesorUnidadList) {
        this.profesorUnidadList = profesorUnidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveUnidadAprendizaje != null ? claveUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadAprendizaje)) {
            return false;
        }
        UnidadAprendizaje other = (UnidadAprendizaje) object;
        if ((this.claveUnidadAprendizaje == null && other.claveUnidadAprendizaje != null) || (this.claveUnidadAprendizaje != null && !this.claveUnidadAprendizaje.equals(other.claveUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.desarrollo.entidad.UnidadAprendizaje[ claveUnidadAprendizaje=" + claveUnidadAprendizaje + " ]";
    }
    
}
