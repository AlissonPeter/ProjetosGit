/*
 * CartaoColumnModel.java
 *
 * Created on 29 de Novembro de 2006, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package CfgTable;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alisson
 */
public class VeiculoColumnModel extends DefaultTableColumnModel{
    private TableColumn criaColuna(int columnIndex, int largura,
            FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo) {
            largura = larguraTitulo;
        }
        TableColumn col = new TableColumn(columnIndex);
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }
    /** Creates a new instance of TarefasColumnModel
     @param fm 
     */
    public VeiculoColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 10 * letra, fm, true, "ID"));
        addColumn(criaColuna(1, 41 * letra, fm, true, "Categoria"));
        addColumn(criaColuna(2, 38 * letra, fm, true, "Placa"));
        addColumn(criaColuna(3, 78 * letra, fm, true, "Marca"));
        addColumn(criaColuna(4, 80 * letra, fm, true, "Modelo"));
        addColumn(criaColuna(5, 30 * letra, fm, true, "Cor"));   
        addColumn(criaColuna(6, 23 * digito, fm, true, "Ano"));
        addColumn(criaColuna(7, 78 * letra, fm, true, "Cidade"));  
        addColumn(criaColuna(8, 10 * letra, fm, true, "UF"));  
        addColumn(criaColuna(9, 80 * digito, fm, true, "Valor"));
        addColumn(criaColuna(10, 28 * letra, fm, true, "Alarme"));
    } 
}
