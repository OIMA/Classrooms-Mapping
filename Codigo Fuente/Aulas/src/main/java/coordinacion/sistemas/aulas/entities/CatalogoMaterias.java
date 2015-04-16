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
@Table(name = "CATALOGO_MATERIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoMaterias.findAll", query = "SELECT c FROM CatalogoMaterias c"),
    @NamedQuery(name = "CatalogoMaterias.findByIdMateria", query = "SELECT c FROM CatalogoMaterias c WHERE c.idMateria = :idMateria"),
    @NamedQuery(name = "CatalogoMaterias.findByNombreMateria", query = "SELECT c FROM CatalogoMaterias c WHERE c.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "CatalogoMaterias.findByHorasPracticas", query = "SELECT c FROM CatalogoMaterias c WHERE c.horasPracticas = :horasPracticas"),
    @NamedQuery(name = "CatalogoMaterias.findByHorasTeoricas", query = "SELECT c FROM CatalogoMaterias c WHERE c.horasTeoricas = :horasTeoricas"),
    @NamedQuery(name = "CatalogoMaterias.findByBloque", query = "SELECT c FROM CatalogoMaterias c WHERE c.bloque = :bloque"),
    @NamedQuery(name = "CatalogoMaterias.findByStatus", query = "SELECT c FROM CatalogoMaterias c WHERE c.status = :status")})
public class CatalogoMaterias implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_MATERIA")
    private BigDecimal idMateria;
    @NotNull
    @Size(max = 100)
    @Column(name = "NOMBRE_MATERIA")
    private String nombreMateria;
    @NotNull
    @Column(name = "HORAS_PRACTICAS")
    private Short horasPracticas;
    @NotNull
    @Column(name = "HORAS_TEORICAS")
    private Short horasTeoricas;
    @NotNull
    @Column(name = "BLOQUE")
    private Short bloque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "ID_ESPECIALIDAD", referencedColumnName = "ID_ESPECIALIDAD")
    @ManyToOne(optional = false)
    private CatalogoEspecialidades idEspecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMateria")
    private List<CatalogoGrupos> catalogoGruposList;

    public CatalogoMaterias() {
    }

    public CatalogoMaterias(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public CatalogoMaterias(BigDecimal idMateria, short status) {
        this.idMateria = idMateria;
        this.status = status;
    }

    public BigDecimal getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(BigDecimal idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Short getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(Short horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    public Short getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(Short horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public Short getBloque() {
        return bloque;
    }

    public void setBloque(Short bloque) {
        this.bloque = bloque;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public CatalogoEspecialidades getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(CatalogoEspecialidades idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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
        hash += (idMateria != null ? idMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoMaterias)) {
            return false;
        }
        CatalogoMaterias other = (CatalogoMaterias) object;
        if ((this.idMateria == null && other.idMateria != null) || (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoMaterias[ idMateria=" + idMateria + " ]";
    }
    
}
