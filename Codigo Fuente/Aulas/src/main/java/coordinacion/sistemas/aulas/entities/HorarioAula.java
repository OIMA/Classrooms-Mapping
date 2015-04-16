/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author OIMA
 */
@Entity
@Table(name = "HORARIO_AULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorarioAula.findAll", query = "SELECT h FROM HorarioAula h"),
    @NamedQuery(name = "HorarioAula.findByIdHorario", query = "SELECT h FROM HorarioAula h WHERE h.idHorario = :idHorario"),
    @NamedQuery(name = "HorarioAula.findByDia", query = "SELECT h FROM HorarioAula h WHERE h.dia = :dia"),
    @NamedQuery(name = "HorarioAula.findByHorario", query = "SELECT h FROM HorarioAula h WHERE h.horario = :horario"),
    @NamedQuery(name = "HorarioAula.findByTipoHorario", query = "SELECT h FROM HorarioAula h WHERE h.tipoHorario = :tipoHorario"),
    @NamedQuery(name = "HorarioAula.findByStatus", query = "SELECT h FROM HorarioAula h WHERE h.status = :status")})
public class HorarioAula implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_HORARIO")
    private BigDecimal idHorario;
    @NotNull
    @Size(max = 10)
    @Column(name = "DIA")
    private String dia;
    @NotNull
    @Size(max = 13)
    @Column(name = "HORARIO")
    private String horario;
    @NotNull
    @Size(max = 1)
    @Column(name = "TIPO_HORARIO")
    private String tipoHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID_GRUPO")
    @ManyToOne
    private CatalogoGrupos idGrupo;
    @JoinColumn(name = "ID_AULA", referencedColumnName = "ID_AULA")
    @ManyToOne
    private CatalogoAulas idAula;

    public HorarioAula() {
    }

    public HorarioAula(BigDecimal idHorario) {
        this.idHorario = idHorario;
    }

    public HorarioAula(BigDecimal idHorario, short status) {
        this.idHorario = idHorario;
        this.status = status;
    }

    public BigDecimal getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(BigDecimal idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoHorario() {
        return tipoHorario;
    }

    public void setTipoHorario(String tipoHorario) {
        this.tipoHorario = tipoHorario;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public CatalogoGrupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(CatalogoGrupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    public CatalogoAulas getIdAula() {
        return idAula;
    }

    public void setIdAula(CatalogoAulas idAula) {
        this.idAula = idAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioAula)) {
            return false;
        }
        HorarioAula other = (HorarioAula) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.HorarioAula[ idHorario=" + idHorario + " ]";
    }
    
}
