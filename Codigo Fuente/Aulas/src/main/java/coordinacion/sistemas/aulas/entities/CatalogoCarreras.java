/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "CATALOGO_CARRERAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoCarreras.findAll", query = "SELECT c FROM CatalogoCarreras c"),
    @NamedQuery(name = "CatalogoCarreras.findByIdCarrera", query = "SELECT c FROM CatalogoCarreras c WHERE c.idCarrera = :idCarrera"),
    @NamedQuery(name = "CatalogoCarreras.findByNombreCarrera", query = "SELECT c FROM CatalogoCarreras c WHERE c.nombreCarrera = :nombreCarrera"),
    @NamedQuery(name = "CatalogoCarreras.findByStatus", query = "SELECT c FROM CatalogoCarreras c WHERE c.status = :status")})
public class CatalogoCarreras implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_CARRERA")
    private BigDecimal idCarrera;
    @NotNull
    @Size(max = 50)
    @Column(name = "NOMBRE_CARRERA")
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private CatalogoUsuarios idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
    private List<CatalogoEspecialidades> catalogoEspecialidadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrera")
    private List<CatalogoAulas> catalogoAulasList;

    public CatalogoCarreras() {
    }

    public CatalogoCarreras(BigDecimal idCarrera) {
        this.idCarrera = idCarrera;
    }

    public CatalogoCarreras(BigDecimal idCarrera, short status) {
        this.idCarrera = idCarrera;
        this.status = status;
    }

    public BigDecimal getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(BigDecimal idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public CatalogoUsuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(CatalogoUsuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<CatalogoEspecialidades> getCatalogoEspecialidadesList() {
        return catalogoEspecialidadesList;
    }

    public void setCatalogoEspecialidadesList(List<CatalogoEspecialidades> catalogoEspecialidadesList) {
        this.catalogoEspecialidadesList = catalogoEspecialidadesList;
    }

    @XmlTransient
    public List<CatalogoAulas> getCatalogoAulasList() {
        return catalogoAulasList;
    }

    public void setCatalogoAulasList(List<CatalogoAulas> catalogoAulasList) {
        this.catalogoAulasList = catalogoAulasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrera != null ? idCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoCarreras)) {
            return false;
        }
        CatalogoCarreras other = (CatalogoCarreras) object;
        if ((this.idCarrera == null && other.idCarrera != null) || (this.idCarrera != null && !this.idCarrera.equals(other.idCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoCarreras[ idCarrera=" + idCarrera + " ]";
    }
    
}
