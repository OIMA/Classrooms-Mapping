/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coordinacion.sistemas.aulas.model;

/**
 *
 * @author OIMA
 */
public class Errores {
    public static int ID_NO_ECONTRADO = 0;
    
    public String obtenerError(int noError){
        String error;
        switch (noError) {
            case 0:
                error = "Error al buscar el id";
                break;
            default:
                error = "Error desconocido";
        }
        return error;
    }
}
