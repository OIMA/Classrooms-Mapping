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
@Table(name = "CATALOGO_PROFESORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoProfesores.findAll", query = "SELECT c FROM CatalogoProfesores c"),
    @NamedQuery(name = "CatalogoProfesores.findByIdProfesor", query = "SELECT c FROM CatalogoProfesores c WHERE c.idProfesor = :idProfesor"),
    @NamedQuery(name = "CatalogoProfesores.findByNombreProfesor", query = "SELECT c FROM CatalogoProfesores c WHERE c.nombreProfesor = :nombreProfesor"),
    @NamedQuery(name = "CatalogoProfesores.findByApPatProfesor", query = "SELECT c FROM CatalogoProfesores c WHERE c.apPatProfesor = :apPatProfesor"),
    @NamedQuery(name = "CatalogoProfesores.findByApMatProfesor", query = "SELECT c FROM CatalogoProfesores c WHERE c.apMatProfesor = :apMatProfesor"),
    @NamedQuery(name = "CatalogoProfesores.findByStatus", query = "SELECT c FROM CatalogoProfesores c WHERE c.status = :status")})
public class CatalogoProfesores implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_PROFESOR")
    private BigDecimal idProfesor;
    @NotNull
    @Size(max = 50)
    @Column(name = "NOMBRE_PROFESOR")
    private String nombreProfesor;
    @NotNull
    @Size(max = 50)
    @Column(name = "AP_PAT_PROFESOR")
    private String apPatProfesor;
    @NotNull
    @Size(max = 50)
    @Column(name = "AP_MAT_PROFESOR")
    private String apMatProfesor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesor")
    private List<CatalogoGrupos> catalogoGruposList;

    public CatalogoProfesores() {
    }

    public CatalogoProfesores(BigDecimal idProfesor) {
        this.idProfesor = idProfesor;
    }

    public CatalogoProfesores(BigDecimal idProfesor, short status) {
        this.idProfesor = idProfesor;
        this.status = status;
    }

    public BigDecimal getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(BigDecimal idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApPatProfesor() {
        return apPatProfesor;
    }

    public void setApPatProfesor(String apPatProfesor) {
        this.apPatProfesor = apPatProfesor;
    }

    public String getApMatProfesor() {
        return apMatProfesor;
    }

    public void setApMatProfesor(String apMatProfesor) {
        this.apMatProfesor = apMatProfesor;
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
        hash += (idProfesor != null ? idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoProfesores)) {
            return false;
        }
        CatalogoProfesores other = (CatalogoProfesores) object;
        if ((this.idProfesor == null && other.idProfesor != null) || (this.idProfesor != null && !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoProfesores[ idProfesor=" + idProfesor + " ]";
    }
    
}
