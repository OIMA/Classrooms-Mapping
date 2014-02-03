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
@Table(name = "CATALOGO_PLANES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoPlanes.findAll", query = "SELECT c FROM CatalogoPlanes c"),
    @NamedQuery(name = "CatalogoPlanes.findByIdPlan", query = "SELECT c FROM CatalogoPlanes c WHERE c.idPlan = :idPlan"),
    @NamedQuery(name = "CatalogoPlanes.findByNombrePlan", query = "SELECT c FROM CatalogoPlanes c WHERE c.nombrePlan = :nombrePlan"),
    @NamedQuery(name = "CatalogoPlanes.findByStatus", query = "SELECT c FROM CatalogoPlanes c WHERE c.status = :status")})
public class CatalogoPlanes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator="sequence")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAN")
    private BigDecimal idPlan;
    @Size(max = 20)
    @Column(name = "NOMBRE_PLAN")
    private String nombrePlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlan")
    private List<CatalogoGrupos> catalogoGruposList;

    public CatalogoPlanes() {
    }

    public CatalogoPlanes(BigDecimal idPlan) {
        this.idPlan = idPlan;
    }

    public CatalogoPlanes(BigDecimal idPlan, short status) {
        this.idPlan = idPlan;
        this.status = status;
    }

    public BigDecimal getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(BigDecimal idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<CatalogoGrupos> getCatalogoGruposList() {
        return catalogoGruposList;
    }

    public void setCatalogoGruposList(List<CatalogoGrupos> catalogoGruposList) {
        this.catalogoGruposList = catalogoGruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoPlanes)) {
            return false;
        }
        CatalogoPlanes other = (CatalogoPlanes) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoPlanes[ idPlan=" + idPlan + " ]";
    }
    
}
