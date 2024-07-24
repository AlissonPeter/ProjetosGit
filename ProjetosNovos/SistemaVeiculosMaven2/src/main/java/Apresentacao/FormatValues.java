

package Apresentacao;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Alisson
 */
public class FormatValues {

   
    public static void formatMoney(JFormattedTextField jftf) {
        MaskFormatter money = null;
        
        try {
            money = new MaskFormatter("*********");
            money.setValidCharacters("0123456789.");
            money.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void formatAno(JFormattedTextField jftf) {
        MaskFormatter ano = null;
        
        try {
            ano = new MaskFormatter("****");
            ano.setValidCharacters("0123456789");
            ano.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void formatPlaca(JFormattedTextField jftf) {
        MaskFormatter placa = null;
        
        try {
            placa = new MaskFormatter("***-****");
            placa.setPlaceholder("________");
            placa.setValidCharacters("0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_");
            placa.install(jftf);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
