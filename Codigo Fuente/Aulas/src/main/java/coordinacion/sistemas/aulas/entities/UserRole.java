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
@Table(name = "USER_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByIdUserRole", query = "SELECT u FROM UserRole u WHERE u.idUserRole = :idUserRole"),
    @NamedQuery(name = "UserRole.findByAuthority", query = "SELECT u FROM UserRole u WHERE u.authority = :authority")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GenericGenerator(name = "sequence", strategy = "increment")
    @Id
    @GeneratedValue(generator = "sequence")
    @Basic(optional = false)
    @Column(name = "ID_USER_ROLE")
    private BigDecimal idUserRole;
    @NotNull
    @Size(max = 45)
    @Column(name = "AUTHORITY")
    private String authority;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private CatalogoUsuarios userId;

    public UserRole() {
    }

    public UserRole(BigDecimal idUserRole) {
        this.idUserRole = idUserRole;
    }

    public BigDecimal getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(BigDecimal idUserRole) {
        this.idUserRole = idUserRole;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public CatalogoUsuarios getUserId() {
        return userId;
    }

    public void setUserId(CatalogoUsuarios userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserRole != null ? idUserRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.idUserRole == null && other.idUserRole != null) || (this.idUserRole != null && !this.idUserRole.equals(other.idUserRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coordinacion.sistemas.aulas.entities.UserRole[ idUserRole=" + idUserRole + " ]";
    }
    
}
