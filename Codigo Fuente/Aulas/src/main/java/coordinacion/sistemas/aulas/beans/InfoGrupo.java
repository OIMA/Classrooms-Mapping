/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.beans;

/**
 *
 * @author OIMA
 */
public class InfoGrupo {
    private String clave, materia, profesor, aulas, porciento,forzado, totalHoras, horasAcomodadas, horasPorAcomodar, color;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getAulas() {
        return aulas;
    }

    public void setAulas(String aulas) {
        this.aulas = aulas;
    }

    public String getPorciento() {
        return porciento;
    }

    public void setPorciento(String porciento) {
        this.porciento = porciento;
    }

    public String getForzado() {
        return forzado;
    }

    public void setForzado(String forzado) {
        this.forzado = forzado;
    }

    public String getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(String totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getHorasAcomodadas() {
        return horasAcomodadas;
    }

    public void setHorasAcomodadas(String horasAcomodadas) {
        this.horasAcomodadas = horasAcomodadas;
    }

    public String getHorasPorAcomodar() {
        return horasPorAcomodar;
    }

    public void setHorasPorAcomodar(String horasPorAcomodar) {
        this.horasPorAcomodar = horasPorAcomodar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
