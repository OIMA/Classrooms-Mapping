/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import coordinacion.sistemas.aulas.entities.HorarioAula;

/**
 *
 * @author OIMA
 */
public class MatrizConNombres {

    private HorarioAula matriz[][];
    private String[] nombreFilas;
    private String[] nombreColumnas;

    public MatrizConNombres(String[] nombreFilas, String[] nombreColumnas, HorarioAula[][] matriz) {
        this.nombreFilas = nombreFilas;
        this.nombreColumnas = nombreColumnas;
        this.matriz = matriz;
    }

    public int index(String cadena, char columnaOFila) {
        if (columnaOFila == 'c') {
            for (int i = 0; i < nombreColumnas.length; i++) {
                if (nombreColumnas[i].equals(cadena)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < nombreFilas.length; i++) {
                if (nombreFilas[i].equals(cadena)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public HorarioAula getValueAt(String fila, String columna) {
        return matriz[index(fila, 'f')][index(columna, 'c')];
    }
    
    public HorarioAula setValueAt(String fila, String columna) {
        return matriz[index(fila, 'f')][index(columna, 'c')];
    }

    public HorarioAula setValueAt(int fila, int columna) {
        return matriz[fila][columna];
    }
    
    public HorarioAula getValueAt(int fila, int columna) {
        return matriz[fila][columna];
    }
}
