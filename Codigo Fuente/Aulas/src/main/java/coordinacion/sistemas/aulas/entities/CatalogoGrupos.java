/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "CATALOGO_GRUPOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoGrupos.findAll", query = "SELECT c FROM CatalogoGrupos c"),
    @NamedQuery(name = "CatalogoGrupos.findByIdGrupo", query = "SELECT c FROM CatalogoGrupos c WHERE c.idGrupo = :idGrupo"),
    @NamedQuery(name = "CatalogoGrupos.findByClaveGrupo", query = "SELECT c FROM CatalogoGrupos c WHERE c.claveGrupo = :claveGrupo"),
    @NamedQuery(name = "CatalogoGrupos.findByHorasPracticasRestantes", query = "SELECT c FROM CatalogoGrupos c WHERE c.horasPracticasRestantes = :horasPracticasRestantes"),
    @NamedQuery(name = "CatalogoGrupos.findByHorasTeoricasRestantes", query = "SELECT c FROM CatalogoGrupos c WHERE c.horasTeoricasRestantes = :horasTeoricasRestantes"),
    @NamedQuery(name = "CatalogoGrupos.findByForzarGrupo", query = "SELECT c FROM CatalogoGrupos c WHERE c.forzarGrupo = :forzarGrupo"),
    @NamedQuery(name = "CatalogoGrupos.findByCapacidadGrupo", query = "SELECT c FROM CatalogoGrupos c WHERE c.capacidadGrupo = :capacidadGrupo"),
    @NamedQuery(name = "CatalogoGrupos.findByStatus", query = "SELECT c FROM CatalogoGrupos c WHERE c.status = :status")})
public class CatalogoGrupos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_GRUPO")
    private BigDecimal idGrupo;
    @NotNull
    @Column(name = "CLAVE_GRUPO")
    private BigInteger claveGrupo;
    @NotNull
    @Column(name = "HORAS_PRACTICAS_RESTANTES")
    private Short horasPracticasRestantes;
    @NotNull
    @Column(name = "HORAS_TEORICAS_RESTANTES")
    private Short horasTeoricasRestantes;
    @NotNull
    @Size(max = 5)
    @Column(name = "FORZAR_GRUPO")
    private String forzarGrupo;
    @NotNull
    @Column(name = "CAPACIDAD_GRUPO")
    private Short capacidadGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @OneToMany(mappedBy = "idGrupo")
    private List<HorarioAula> horarioAulaList;
    @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PROFESOR")
    @ManyToOne(optional = false)
    private CatalogoProfesores idProfesor;
    @JoinColumn(name = "ID_PLAN", referencedColumnName = "ID_PLAN")
    @ManyToOne(optional = false)
    private CatalogoPlanes idPlan;
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID_MATERIA")
    @ManyToOne(optional = false)
    private CatalogoMaterias idMateria;
    @JoinColumn(name = "ID_CICLO_ESCOLAR", referencedColumnName = "ID_CICLO_ESCOLAR")
    @ManyToOne(optional = false)
    private CatalogoCicloEscolar idCicloEscolar;

    public CatalogoGrupos() {
    }

    public CatalogoGrupos(BigDecimal idGrupo) {
        this.idGrupo = idGrupo;
    }

    public CatalogoGrupos(BigDecimal idGrupo, short status) {
        this.idGrupo = idGrupo;
        this.status = status;
    }

    public BigDecimal getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(BigDecimal idGrupo) {
        this.idGrupo = idGrupo;
    }

    public BigInteger getClaveGrupo() {
        return claveGrupo;
    }

    public void setClaveGrupo(BigInteger claveGrupo) {
        this.claveGrupo = claveGrupo;
    }

    public Short getHorasPracticasRestantes() {
        return horasPracticasRestantes;
    }

    public void setHorasPracticasRestantes(Short horasPracticasRestantes) {
        this.horasPracticasRestantes = horasPracticasRestantes;
    }

    public Short getHorasTeoricasRestantes() {
        return horasTeoricasRestantes;
    }

    public void setHorasTeoricasRestantes(Short horasTeoricasRestantes) {
        this.horasTeoricasRestantes = horasTeoricasRestantes;
    }

    public String getForzarGrupo() {
        return forzarGrupo;
    }

    public void setForzarGrupo(String forzarGrupo) {
        this.forzarGrupo = forzarGrupo;
    }

    public Short getCapacidadGrupo() {
        return capacidadGrupo;
    }

    public void setCapacidadGrupo(Short capacidadGrupo) {
        this.capacidadGrupo = capacidadGrupo;
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

    public CatalogoProfesores getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(CatalogoProfesores idProfesor) {
        this.idProfesor = idProfesor;
    }

    public CatalogoPlanes getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(CatalogoPlanes idPlan) {
        this.idPlan = idPlan;
    }

    public CatalogoMaterias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(CatalogoMaterias idMateria) {
        this.idMateria = idMateria;
    }

    public CatalogoCicloEscolar getIdCicloEscolar() {
        return idCicloEscolar;
    }

    public void setIdCicloEscolar(CatalogoCicloEscolar idCicloEscolar) {
        this.idCicloEscolar = idCicloEscolar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoGrupos)) {
            return false;
        }
        CatalogoGrupos other = (CatalogoGrupos) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.CatalogoGrupos[ idGrupo=" + idGrupo + " ]";
    }
    
}
