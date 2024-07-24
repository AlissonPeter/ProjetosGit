/*
 * VeiculoTableModel.java
 *
 * Created on 21 de Outubro de 2006, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package CfgTable;

/**
 *
 * @author java
 */
import java.util.*;
import java.text.*;
import javax.swing.table.*;
import Model.Veiculo;

/**
 *
 * @author Alisson
 *
 *  Esta classe permite a exibi��o dos dados de uma List<Veiculo>
 *      em um JTable.
 */
public class VeiculoTableModel extends AbstractTableModel {
    private List<Veiculo> veiculos;
    
    private boolean ordenarPorNome = true;
    /** Creates a new instance of TarefasTableModel */
    public VeiculoTableModel(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo umVeiculo = veiculos.get(rowIndex);
        switch(columnIndex) {
            case 0: return umVeiculo.getId();
            case 1: return umVeiculo.getCategoria();
            case 2: return umVeiculo.getPlaca();
            case 3: return umVeiculo.getMarca();   
            case 4: return umVeiculo.getModelo();
            case 5: return umVeiculo.getCor();
            case 6: return umVeiculo.getAno();
            case 7: return umVeiculo.getCidade();
            case 8: return umVeiculo.getUf();
            case 9: return umVeiculo.getValor();
            case 10:
                if (umVeiculo.isAlarme() == true){
                return "Sim";                
                } else if (umVeiculo.isAlarme() == false){
                    return "Não";
                }
        }
        return null;
    }
    
    @Override
    public int getRowCount() {
        return veiculos.size();
    }
    
    @Override
    public int getColumnCount() {
        return 10;
    }
    
    public Veiculo getValoresVeiculo(int rowIndex) {
        
        return veiculos.get(rowIndex);
    }
    
    
    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }
    
    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }
    
    
}
