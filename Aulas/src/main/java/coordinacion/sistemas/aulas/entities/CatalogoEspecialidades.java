/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author OIMA
 */
@Entity
@Table(name = "CATALOGO_ESPECIALIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoEspecialidades.findAll", query = "SELECT c FROM CatalogoEspecialidades c"),
    @NamedQuery(name = "CatalogoEspecialidades.findByIdEspecialidad", query = "SELECT c FROM CatalogoEspecialidades c WHERE c.idEspecialidad = :idEspecialidad"),
    @NamedQuery(name = "CatalogoEspecialidades.findByNombreEspecialidad", query = "SELECT c FROM CatalogoEspecialidades c WHERE c.nombreEspecialidad = :nombreEspecialidad"),
    @NamedQuery(name = "CatalogoEspecialidades.findByStatus", query = "SELECT c FROM CatalogoEspecialidades c WHERE c.status = :status")})
public class CatalogoEspecialidades implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator="sequence")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESPECIALIDAD")
    private BigDecimal idEspecialidad;
    @Size(max = 150)
    @Column(name = "NOMBRE_ESPECIALIDAD")
    private String nombreEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "ID_CARRERA", referencedColumnName = "ID_CARRERA")
    @ManyToOne(optional = false)
    private CatalogoCarreras idCarrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialidad")
    private List<CatalogoMaterias> catalogoMateriasList;

    public CatalogoEspecialidades() {
    }

    public CatalogoEspecialidades(BigDecimal idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public CatalogoEspecialidades(BigDecimal idEspecialidad, short status) {
        this.idEspecialidad = idEspecialidad;
        this.status = status;
    }

    public BigDecimal getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(BigDecimal idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public CatalogoCarreras getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(CatalogoCarreras idCarrera) {
        this.idCarrera = idCarrera;
    }

    @XmlTransient
    public List<CatalogoMaterias> getCatalogoMateriasList() {
        return catalogoMateriasList;
    }

    public void setCatalogoMateriasList(List<CatalogoMaterias> catalogoMateriasList) {
        this.catalogoMateriasList = catalogoMateriasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidad != null ? idEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoEspecialidades)) {
            return false;
        }
        CatalogoEspecialidades other = (CatalogoEspecialidades) object;
        if ((this.idEspecialidad == null && other.idEspecialidad != null) || (this.idEspecialidad != null && !this.idEspecialidad.equals(other.idEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoEspecialidades[ idEspecialidad=" + idEspecialidad + " ]";
    }
    
}
