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
@Table(name = "CATALOGO_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoUsuarios.findAll", query = "SELECT c FROM CatalogoUsuarios c"),
    @NamedQuery(name = "CatalogoUsuarios.findByIdUsuario", query = "SELECT c FROM CatalogoUsuarios c WHERE c.idUsuario = :idUsuario"),
    @NamedQuery(name = "CatalogoUsuarios.findByNombre", query = "SELECT c FROM CatalogoUsuarios c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CatalogoUsuarios.findByApPat", query = "SELECT c FROM CatalogoUsuarios c WHERE c.apPat = :apPat"),
    @NamedQuery(name = "CatalogoUsuarios.findByApMat", query = "SELECT c FROM CatalogoUsuarios c WHERE c.apMat = :apMat"),
    @NamedQuery(name = "CatalogoUsuarios.findByNombreUsuario", query = "SELECT c FROM CatalogoUsuarios c WHERE c.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "CatalogoUsuarios.findByPasswordUsuario", query = "SELECT c FROM CatalogoUsuarios c WHERE c.passwordUsuario = :passwordUsuario"),
    @NamedQuery(name = "CatalogoUsuarios.findByTipo", query = "SELECT c FROM CatalogoUsuarios c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "CatalogoUsuarios.findByStatus", query = "SELECT c FROM CatalogoUsuarios c WHERE c.status = :status")})
public class CatalogoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "AP_PAT")
    private String apPat;
    @Size(max = 45)
    @Column(name = "AP_MAT")
    private String apMat;
    @Size(max = 200)
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;
    @Size(max = 200)
    @Column(name = "PASSWORD_USUARIO")
    private String passwordUsuario;
    @Column(name = "TIPO")
    private Short tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<CatalogoCarreras> catalogoCarrerasList;

    public CatalogoUsuarios() {
    }

    public CatalogoUsuarios(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CatalogoUsuarios(BigDecimal idUsuario, short status) {
        this.idUsuario = idUsuario;
        this.status = status;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<CatalogoCarreras> getCatalogoCarrerasList() {
        return catalogoCarrerasList;
    }

    public void setCatalogoCarrerasList(List<CatalogoCarreras> catalogoCarrerasList) {
        this.catalogoCarrerasList = catalogoCarrerasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoUsuarios)) {
            return false;
        }
        CatalogoUsuarios other = (CatalogoUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoUsuarios[ idUsuario=" + idUsuario + " ]";
    }
}
