/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinacion.sistemas.aulas.beans;

/**
 *
 * @author OIMA
 */
public class InformacionAula {
    public String idAula;
    public String nombreEdificio;
    public String nombreAula;
    public String tipoAula;

    public String getIdAula() {
        return idAula;
    }

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public String getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(String tipoAula) {
        this.tipoAula = tipoAula;
    }
    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }
    
}
