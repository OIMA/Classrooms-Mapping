/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auxiliar;

/**
 *
 * @author OIMA
 */
public class ManejoStrings {

    public ManejoStrings() {
    }
    
    public boolean sonIguales(String s1, String s2){
        if (toOneShape(s1).equals(toOneShape(s2))) {
            return true;
        }
        return false;
    }
    
    public String toOneShape(String s){
        s = s.trim();
        s = s.toUpperCase();
        s = s.replace('Á', 'A');
        s = s.replace('É', 'E');
        s = s.replace('Í', 'I');
        s = s.replace('Ó', 'O');
        s = s.replace('Ú', 'U');
//        s = s.replace(' ', Charact);
        
        System.out.println(s);
        return s;
    }
}
