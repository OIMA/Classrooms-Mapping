/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "CATALOGO_AULAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoAulas.findAll", query = "SELECT c FROM CatalogoAulas c"),
    @NamedQuery(name = "CatalogoAulas.findByIdAula", query = "SELECT c FROM CatalogoAulas c WHERE c.idAula = :idAula"),
    @NamedQuery(name = "CatalogoAulas.findByEdificio", query = "SELECT c FROM CatalogoAulas c WHERE c.edificio = :edificio"),
    @NamedQuery(name = "CatalogoAulas.findByAula", query = "SELECT c FROM CatalogoAulas c WHERE c.aula = :aula"),
    @NamedQuery(name = "CatalogoAulas.findByTipoAula", query = "SELECT c FROM CatalogoAulas c WHERE c.tipoAula = :tipoAula"),
    @NamedQuery(name = "CatalogoAulas.findByCapacidadAula", query = "SELECT c FROM CatalogoAulas c WHERE c.capacidadAula = :capacidadAula"),
    @NamedQuery(name = "CatalogoAulas.findByStatus", query = "SELECT c FROM CatalogoAulas c WHERE c.status = :status")})
public class CatalogoAulas implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final int TEORICA = 0;
    public static final int PRACTICA = 1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AULA")
    private BigDecimal idAula;
    @Size(max = 30)
    @Column(name = "EDIFICIO")
    private String edificio;
    @Size(max = 30)
    @Column(name = "AULA")
    private String aula;
    @Column(name = "TIPO_AULA")
    private Short tipoAula;
    @Column(name = "CAPACIDAD_AULA")
    private Short capacidadAula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @OneToMany(mappedBy = "idAula")
    private List<HorarioAula> horarioAulaList;
    @JoinColumn(name = "ID_CARRERA", referencedColumnName = "ID_CARRERA")
    @ManyToOne(optional = false)
    private CatalogoCarreras idCarrera;

    public CatalogoAulas() {
    }

    public CatalogoAulas(BigDecimal idAula) {
        this.idAula = idAula;
    }

    public CatalogoAulas(BigDecimal idAula, short status) {
        this.idAula = idAula;
        this.status = status;
    }

    public BigDecimal getIdAula() {
        return idAula;
    }

    public void setIdAula(BigDecimal idAula) {
        this.idAula = idAula;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Short getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(Short tipoAula) {
        this.tipoAula = tipoAula;
    }

    public Short getCapacidadAula() {
        return capacidadAula;
    }

    public void setCapacidadAula(Short capacidadAula) {
        this.capacidadAula = capacidadAula;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<HorarioAula> getHorarioAulaList() {
        return horarioAulaList;
    }

    public void setHorarioAulaList(List<HorarioAula> horarioAulaList) {
        this.horarioAulaList = horarioAulaList;
    }

    public CatalogoCarreras getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(CatalogoCarreras idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoAulas)) {
            return false;
        }
        CatalogoAulas other = (CatalogoAulas) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoAulas[ idAula=" + idAula + " ]";
    }
}
