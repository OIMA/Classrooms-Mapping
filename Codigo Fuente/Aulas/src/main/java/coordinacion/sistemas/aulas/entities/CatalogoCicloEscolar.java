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
@Table(name = "CATALOGO_CICLO_ESCOLAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoCicloEscolar.findAll", query = "SELECT c FROM CatalogoCicloEscolar c"),
    @NamedQuery(name = "CatalogoCicloEscolar.findByIdCicloEscolar", query = "SELECT c FROM CatalogoCicloEscolar c WHERE c.idCicloEscolar = :idCicloEscolar"),
    @NamedQuery(name = "CatalogoCicloEscolar.findByNombreCicloEscolar", query = "SELECT c FROM CatalogoCicloEscolar c WHERE c.nombreCicloEscolar = :nombreCicloEscolar"),
    @NamedQuery(name = "CatalogoCicloEscolar.findByFechaInicio", query = "SELECT c FROM CatalogoCicloEscolar c WHERE c.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "CatalogoCicloEscolar.findByFechaFin", query = "SELECT c FROM CatalogoCicloEscolar c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CatalogoCicloEscolar.findByStatus", query = "SELECT c FROM CatalogoCicloEscolar c WHERE c.status = :status")})
public class CatalogoCicloEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_CICLO_ESCOLAR")
    private BigDecimal idCicloEscolar;
    @NotNull
    @Size(max = 10)
    @Column(name = "NOMBRE_CICLO_ESCOLAR")
    private String nombreCicloEscolar;
    @NotNull
    @Size(max = 10)
    @Column(name = "FECHA_INICIO")
    private String fechaInicio;
    @NotNull
    @Size(max = 10)
    @Column(name = "FECHA_FIN")
    private String fechaFin;
    @Column(name = "STATUS")
    private Short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCicloEscolar")
    private List<CatalogoGrupos> catalogoGruposList;

    public CatalogoCicloEscolar() {
    }

    public CatalogoCicloEscolar(BigDecimal idCicloEscolar) {
        this.idCicloEscolar = idCicloEscolar;
    }

    public BigDecimal getIdCicloEscolar() {
        return idCicloEscolar;
    }

    public void setIdCicloEscolar(BigDecimal idCicloEscolar) {
        this.idCicloEscolar = idCicloEscolar;
    }

    public String getNombreCicloEscolar() {
        return nombreCicloEscolar;
    }

    public void setNombreCicloEscolar(String nombreCicloEscolar) {
        this.nombreCicloEscolar = nombreCicloEscolar;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
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
        hash += (idCicloEscolar != null ? idCicloEscolar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoCicloEscolar)) {
            return false;
        }
        CatalogoCicloEscolar other = (CatalogoCicloEscolar) object;
        if ((this.idCicloEscolar == null && other.idCicloEscolar != null) || (this.idCicloEscolar != null && !this.idCicloEscolar.equals(other.idCicloEscolar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoCicloEscolar[ idCicloEscolar=" + idCicloEscolar + " ]";
    }
    
}
