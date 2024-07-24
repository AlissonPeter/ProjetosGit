/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import CfgTable.VeiculoColumnModel;
import CfgTable.VeiculoTableModel;
import Dao.VeiculoDAO;
import Model.Veiculo;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Alisson
 */
public class DlgCadastroVeiculo extends javax.swing.JDialog {

    Veiculo v = new Veiculo();
    VeiculoDAO dao = new VeiculoDAO();
    private List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
     
    /**
     * Creates new form DlgCadastrar
     */
    public DlgCadastroVeiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FormatValues.formatPlaca(this.tfPlaca);
        FormatValues.formatMoney(this.cfValor);
        FormatValues.formatAno(this.cfAno);
        listaVeiculos = carregarDadosVeiculo();
        this.setListaVeiculos(listaVeiculos);
        tbVeiculos.setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = tbVeiculos.getFontMetrics(tbVeiculos.getFont());
        tbVeiculos.setColumnModel(new VeiculoColumnModel(fm));
    }
    
    private List<Veiculo> carregarDadosVeiculo() {
        try {
            listaVeiculos = dao.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaVeiculos;
    }
    
    private void atualizarTabela() {
        try {
        	this.setListaVeiculos(dao.findAll());
        } catch (Exception ex) {
        }
    }
    
    private void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.tbVeiculos.setModel(new VeiculoTableModel(listaVeiculos));
    }

    private VeiculoTableModel getVeiculoTableModel() {
        return (VeiculoTableModel) tbVeiculos.getModel();
    }

    public Veiculo getVeiculoSelecionado() {
        return ((VeiculoTableModel) tbVeiculos.getModel()).getValoresVeiculo(tbVeiculos.getSelectedRow());
    }

    public Veiculo[] getVeiculosSelecionados() {
        Veiculo[] selecao = new Veiculo[tbVeiculos.getSelectedRowCount()];
        int[] indices = tbVeiculos.getSelectedRows();
        int j = 0;
        for (int i : indices) {
            selecao[j++] = ((VeiculoTableModel) tbVeiculos.getModel()).getValoresVeiculo(i);
        }
        return selecao;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        tfModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btAdicionar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        rbMoto = new javax.swing.JRadioButton();
        rbCarro = new javax.swing.JRadioButton();
        rbCaminhao = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfCor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbUf = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        tfMarca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        tfId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cfValor = new javax.swing.JFormattedTextField();
        cfAno = new javax.swing.JFormattedTextField();
        tfPlaca = new javax.swing.JFormattedTextField();
        btFechar = new javax.swing.JButton();
        btExcluirTudo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Veículos");

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVeiculos);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Categoria:");

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        tfModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Marca:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Modelo:");

        btAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/add_att.gif"))); // NOI18N
        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/edited_ov.gif"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setEnabled(false);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/bt_icone_limpar.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbMoto);
        rbMoto.setText("Moto");

        buttonGroup1.add(rbCarro);
        rbCarro.setText("Carro");

        buttonGroup1.add(rbCaminhao);
        rbCaminhao.setText("Caminhão");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Placa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ano:");

        tfCor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Cor:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Cidade:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("UF:");

        cbUf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUf.setSelectedIndex(-1);
        cbUf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUfActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Valor:");

        tfCidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/delete_obj.gif"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tfMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Possui Alarme?");

        buttonGroup2.add(rbSim);
        rbSim.setText("Sim");

        buttonGroup2.add(rbNao);
        rbNao.setText("Não");

        tfId.setEditable(false);
        tfId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("ID:");

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Dados do Veículo");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        cfValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cfAno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbMoto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCarro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbCaminhao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btPesquisar)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tfCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfMarca))
                                        .addGap(19, 19, 19))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cfValor)
                                .addGap(437, 437, 437)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btPesquisar)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rbMoto)
                    .addComponent(rbCarro)
                    .addComponent(rbCaminhao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(cfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cbUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rbSim)
                    .addComponent(rbNao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btExcluirTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/delete_obj.gif"))); // NOI18N
        btExcluirTudo.setText("Excluir Tudo");
        btExcluirTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirTudoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btExcluirTudo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluirTudo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-704)/2, (screenSize.height-560)/2, 704, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void cbUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUfActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
      if ("___-____".equals(tfPlaca.getText()) || "   -    ".equals(tfPlaca.getText()) || "".equals(tfMarca.getText()) || "".equals(tfModelo.getText()) || 
              "".equals(tfCor.getText()) || "    ".equals(cfAno.getText()) || "".equals(tfCidade.getText())){
          JOptionPane.showMessageDialog(this, "ERRO! Os campos não podem ficar em branco.");
      } else if(categoria() == false){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione uma das categorias.");
      } else if(alarme() == false){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione uma das opções do alarme.");
      } else if(cbUf.getSelectedIndex() == -1){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione o Estado.");
      } else {
        if(categoria() == true){
            if(rbMoto.isSelected()){
                v.setCategoria("Moto");
            } else if (rbCarro.isSelected()){
                v.setCategoria("Carro");
            } else if (rbCaminhao.isSelected()){
                v.setCategoria("Caminhão");
            }
        } 
        v.setPlaca(tfPlaca.getText());
        v.setMarca(tfMarca.getText());
        v.setModelo(tfModelo.getText());
        v.setCor(tfCor.getText());
        v.setAno(Integer.parseInt(cfAno.getText()));
        v.setCidade(tfCidade.getText());
        v.setUf((String)cbUf.getSelectedItem());
        v.setValor(Float.parseFloat(cfValor.getText()));
        
        if(alarme() == true){
        if (rbSim.isSelected()){
        v.setAlarme(true);
        } else if (rbNao.isSelected()){
            v.setAlarme(false);
        }
        }
        dao.inserir(v);
        limparCampos();
        atualizarTabela();
      }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        if ("___-____".equals(tfPlaca.getText()) || "   -    ".equals(tfPlaca.getText()) || "".equals(tfMarca.getText()) || "".equals(tfModelo.getText()) ||
                "".equals(tfCor.getText()) || "    ".equals(cfAno.getText()) || "".equals(tfCidade.getText())){
          JOptionPane.showMessageDialog(this, "ERRO! Os campos não podem ficar em branco.");
      } else if(categoria() == false){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione uma das categorias.");
      } else if(alarme() == false){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione uma das opções do alarme.");
      } else if(cbUf.getSelectedIndex() == -1){
          JOptionPane.showMessageDialog(this, "ERRO! Selecione o Estado.");
      } else {
        if(categoria() == true){
            if(rbMoto.isSelected()){
                v.setCategoria("Moto");
            } else if (rbCarro.isSelected()){
                v.setCategoria("Carro");
            } else if (rbCaminhao.isSelected()){
                v.setCategoria("Caminhão");
            }
        } 
        v.setId(Integer.parseInt(tfId.getText()));
        v.setPlaca(tfPlaca.getText());
        v.setMarca(tfMarca.getText());
        v.setModelo(tfModelo.getText());
        v.setCor(tfCor.getText());
        v.setAno(Integer.parseInt(cfAno.getText()));
        v.setCidade(tfCidade.getText());
        v.setUf((String)cbUf.getSelectedItem());
        v.setValor(Float.parseFloat(cfValor.getText()));
        
        if(alarme() == true){
        if (rbSim.isSelected()){
        v.setAlarme(true);
        } else if (rbNao.isSelected()){
            v.setAlarme(false);
        }
        }
        dao.atualizar(v);
        limparCampos();
        atualizarTabela();
        tratarBotoes1();
      }
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if ("".equals(tfId.getText())){
            JOptionPane.showMessageDialog(this, "ERRO! Informe a placa para a exclusão.");
        } else {
        v.setId(Integer.parseInt(tfId.getText()));
        dao.remover(v);
        limparCampos();
        atualizarTabela();
        tratarBotoes1();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
        tratarBotoes1();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
 //       if("___-____".equals(tfPlaca.getText()) || "   -    ".equals(tfPlaca.getText())){
 //           JOptionPane.showMessageDialog(this, "ERRO! Informe a placa do veículo para a pesquisa.");
 //       } else { 
           try {
 //           if(dao.getVeiculoPorPlaca(tfPlaca.getText()) == null){
  //       JOptionPane.showMessageDialog(this, "ERRO! Este veículo não foi registrado.");
  //      } else {
             String placa = tfPlaca.getText();
             
             Veiculo veiculo = dao.getVeiculoPorPlaca(placa);
             if (veiculo != null) {
            	 if ("Moto".equals(veiculo.getCategoria())){
            		 rbMoto.setSelected(true);
            	 } else if ("Carro".equals(veiculo.getCategoria())){
            		 rbCarro.setSelected(true);
            	 } else if ("Caminhão".equals(veiculo.getCategoria())){
            		 rbCaminhao.setSelected(true);
            	 }
            	 tfId.setText(Integer.toString(veiculo.getId()));
            	 cfAno.setText(Integer.toString(veiculo.getAno()));
            	 tfCidade.setText(veiculo.getCidade());
            	 tfCor.setText(veiculo.getCor());
            	 tfMarca.setText(veiculo.getMarca());
            	 tfModelo.setText(veiculo.getModelo());
            	 cfValor.setText(Float.toString(veiculo.getValor()));
            	 cbUf.setSelectedItem(veiculo.getUf());
            	 if (veiculo.isAlarme() == true){
            		 rbSim.setSelected(true);
            	 } else if (veiculo.isAlarme() == false){
            		 rbNao.setSelected(true);
            	 }
            	 tratarBotoes2();
             }
           } catch (Exception ex) {
        }
      
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirTudoActionPerformed
       // dao.removerTudo(v);
        limparCampos();
        atualizarTabela();
        tratarBotoes1();
    }//GEN-LAST:event_btExcluirTudoActionPerformed

    private void tbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculosMouseClicked
        if (evt.getClickCount() == 1) {
            this.setObject(this.getVeiculoSelecionado());
        }
    }//GEN-LAST:event_tbVeiculosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
           
        } catch (InstantiationException ex) {
            
        } catch (IllegalAccessException ex) {
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DlgCadastroVeiculo dialog = new DlgCadastroVeiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
// Este método boleano vai verificar se o RadioButton esta selecionado, se estiver vai retornar verdadeiro.
    private boolean categoria(){
        if(rbMoto.isSelected() || rbCarro.isSelected() || rbCaminhao.isSelected()){
           return true;
        }
        else{
            return false;
        }
    }
    private boolean alarme(){
        if(rbSim.isSelected() || rbNao.isSelected()){
           return true;
        }
        else{
            return false;
        }
    }
    
    public void limparCampos(){
        tfId.setText(null);
        tfPlaca.setText(null);
        cfAno.setText(null);
        tfCidade.setText(null);
        tfCor.setText(null);
        tfMarca.setText(null);
        tfModelo.setText(null);
        cfValor.setText(null);
        cbUf.setSelectedIndex(-1);
    }
    
    public void tratarBotoes1(){
        btAdicionar.setEnabled(true);
        btAtualizar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    
    public void tratarBotoes2(){
        btAdicionar.setEnabled(false);
        btAtualizar.setEnabled(true);
        btExcluir.setEnabled(true);
    }
    
    private void setObject(Veiculo selecionado) {
        cfAno.setText(Integer.toString(selecionado.getAno()));
        tfCidade.setText(selecionado.getCidade());
        tfCor.setText(selecionado.getCor());
        tfId.setText(Integer.toString(selecionado.getId()));
        tfMarca.setText(selecionado.getMarca());
        tfModelo.setText(selecionado.getModelo());
        tfPlaca.setText(selecionado.getPlaca());
        cfValor.setText(Float.toString(selecionado.getValor()));
        cbUf.setSelectedItem(selecionado.getUf());
        if("Moto".equals(selecionado.getCategoria())){
            rbMoto.setSelected(true);
        } else if("Carro".equals(selecionado.getCategoria())){
            rbCarro.setSelected(true);
        } else if ("Caminhão".equals(selecionado.getCategoria())){
            rbCaminhao.setSelected(true);
        }
        if(selecionado.isAlarme() == true){
            rbSim.setSelected(true);
        } else if (selecionado.isAlarme() == false){
            rbNao.setSelected(true);
        }
        tratarBotoes2();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btExcluirTudo;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbUf;
    private javax.swing.JFormattedTextField cfAno;
    private javax.swing.JFormattedTextField cfValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCaminhao;
    private javax.swing.JRadioButton rbCarro;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCor;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfModelo;
    private javax.swing.JFormattedTextField tfPlaca;
    // End of variables declaration//GEN-END:variables
    
}
