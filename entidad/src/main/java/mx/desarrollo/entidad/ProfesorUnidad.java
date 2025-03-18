/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "profesor_unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesorUnidad.findAll", query = "SELECT p FROM ProfesorUnidad p")
    , @NamedQuery(name = "ProfesorUnidad.findByNumProfesorunidad", query = "SELECT p FROM ProfesorUnidad p WHERE p.numProfesorunidad = :numProfesorunidad")
    , @NamedQuery(name = "ProfesorUnidad.findByNombreUnidad", query = "SELECT p FROM ProfesorUnidad p WHERE p.nombreUnidad = :nombreUnidad")
    , @NamedQuery(name = "ProfesorUnidad.findByHorasclase", query = "SELECT p FROM ProfesorUnidad p WHERE p.horasclase = :horasclase")
    , @NamedQuery(name = "ProfesorUnidad.findByHorastaller", query = "SELECT p FROM ProfesorUnidad p WHERE p.horastaller = :horastaller")
    , @NamedQuery(name = "ProfesorUnidad.findByHoraslaboratorio", query = "SELECT p FROM ProfesorUnidad p WHERE p.horaslaboratorio = :horaslaboratorio")})
public class ProfesorUnidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numProfesorunidad")
    private Integer numProfesorunidad;
    @Basic(optional = false)
    @Column(name = "NombreUnidad")
    private String nombreUnidad;
    @Basic(optional = false)
    @Column(name = "horasclase")
    private int horasclase;
    @Basic(optional = false)
    @Column(name = "horastaller")
    private int horastaller;
    @Basic(optional = false)
    @Column(name = "horaslaboratorio")
    private int horaslaboratorio;
    @JoinColumn(name = "idProfesor", referencedColumnName = "idProfesor")
    @ManyToOne(optional = false)
    private Profesor idProfesor;
    @JoinColumn(name = "claveUnidadAprendizaje", referencedColumnName = "claveUnidadAprendizaje")
    @ManyToOne(optional = false)
    private UnidadAprendizaje claveUnidadAprendizaje;

    public ProfesorUnidad() {
    }

    public ProfesorUnidad(Integer numProfesorunidad) {
        this.numProfesorunidad = numProfesorunidad;
    }

    public ProfesorUnidad(Integer numProfesorunidad, String nombreUnidad, int horasclase, int horastaller, int horaslaboratorio) {
        this.numProfesorunidad = numProfesorunidad;
        this.nombreUnidad = nombreUnidad;
        this.horasclase = horasclase;
        this.horastaller = horastaller;
        this.horaslaboratorio = horaslaboratorio;
    }

    public Integer getNumProfesorunidad() {
        return numProfesorunidad;
    }

    public void setNumProfesorunidad(Integer numProfesorunidad) {
        this.numProfesorunidad = numProfesorunidad;
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

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public UnidadAprendizaje getClaveUnidadAprendizaje() {
        return claveUnidadAprendizaje;
    }

    public void setClaveUnidadAprendizaje(UnidadAprendizaje claveUnidadAprendizaje) {
        this.claveUnidadAprendizaje = claveUnidadAprendizaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numProfesorunidad != null ? numProfesorunidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorUnidad)) {
            return false;
        }
        ProfesorUnidad other = (ProfesorUnidad) object;
        if ((this.numProfesorunidad == null && other.numProfesorunidad != null) || (this.numProfesorunidad != null && !this.numProfesorunidad.equals(other.numProfesorunidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.desarrollo.entidad.ProfesorUnidad[ numProfesorunidad=" + numProfesorunidad + " ]";
    }
    
}
