/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexao.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Veiculo;


/**
 *
 * @author Alisson
 */
public class VeiculoDAO {
    
       public void inserir(Veiculo veiculo) {
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT = 
                "insert into veiculo (categoria, placa, marca, modelo, cor, ano, cidade, uf, valor, alarme, id) " +
                "values (?,?,?,?,?,?,?,?,?,?,?)";
            pstm = Conexao.getCon().prepareStatement(SQL_INSERT);
            pstm.setString(1, veiculo.getCategoria());
            pstm.setString(2, veiculo.getPlaca());
            pstm.setString(3, veiculo.getMarca());
            pstm.setString(4, veiculo.getModelo());
            pstm.setString(5, veiculo.getCor());
            pstm.setInt(6, veiculo.getAno());
            pstm.setString(7, veiculo.getCidade());
            pstm.setString(8, veiculo.getUf());
            pstm.setFloat(9, veiculo.getValor());
            pstm.setBoolean(10, veiculo.isAlarme());
            pstm.setInt(11, createKey());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
        	e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "ERRO! A placa informada já foi registrada no Banco de Dados.");
        }
    }
       
       private int createKey() {
    	   final String query = "select * from Veiculo order by id desc";
           PreparedStatement stmt;
		try {
			stmt = Conexao.getCon().prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
	           
	           if (rs.next()) {
	        	   return rs.getInt("id") + 1;
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1; 
       }

    public void atualizar(Veiculo veiculo) {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE =
                "UPDATE Veiculo SET placa = ?, categoria = ?, marca = ?, modelo = ?, cor = ?, ano = ?, cidade = ?, uf = ?, valor = ?, alarme = ? WHERE id = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_UPDATE);
            pstm.setString(1, veiculo.getPlaca());
            pstm.setString(2, veiculo.getCategoria());
            pstm.setString(3, veiculo.getMarca());
            pstm.setString(4, veiculo.getModelo());
            pstm.setString(5, veiculo.getCor());
            pstm.setInt(6, veiculo.getAno());
            pstm.setString(7, veiculo.getCidade());
            pstm.setString(8, veiculo.getUf());
            pstm.setFloat(9, veiculo.getValor());
            pstm.setBoolean(10, veiculo.isAlarme());
            pstm.setInt(11, veiculo.getId());
            pstm.executeUpdate();
            System.out.println("atualização realizada com sucesso!");
        } catch (SQLException e) {
          //  JOptionPane.showMessageDialog(null, "ERRO! A placa informada já existe no Banco de Dados.");
        }
    }
    
    public void remover(Veiculo veiculo) {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "delete from Veiculo where id = ?";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.setInt(1, veiculo.getId());
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados!!!\n" + e.getMessage());
        }
        
    }
    
    public void removerTudo(Veiculo veiculo) {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "delete from Veiculo";
            pstm = Conexao.getCon().prepareStatement(SQL_DELETE);
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados!!!\n" + e.getMessage());
        }
        
    }

    public Veiculo getVeiculoPorPlaca(String placa) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            final String SQL_PESQUISA_POR_ID = 
                    "select * from Veiculo where placa = ?";
            stmt = Conexao.getCon().prepareStatement(SQL_PESQUISA_POR_ID);
            stmt.setString(1, placa);
            rs = stmt.executeQuery();
            return carregarResultadoSimples(rs);
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
        }
    }
       
    public List<Veiculo> findAll() throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String SQL_STATEMENT ="Select id, categoria, placa, marca, modelo, cor, ano, cidade, uf, valor, alarme" +
                " from veiculo order by categoria";
        try {
            stmt = Conexao.getCon().prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            throw new Exception(sqle);
        } catch(Exception e){
            throw new Exception(e);
        } finally{}
    }

    private List<Veiculo> carregarMultiplosResultados(ResultSet rs) throws SQLException{
        List<Veiculo> resultList = new ArrayList<Veiculo>();
        while (rs.next()) {
            Veiculo dto = new Veiculo();
            carregarVO( dto, rs);
            resultList.add(dto);
        }
        return resultList;
    }

    private Veiculo carregarResultadoSimples(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Veiculo dto = new Veiculo();
            carregarVO(dto, rs);
            return dto;
        } else {
            return null;
        }
    }

    private void carregarVO(Veiculo dto, ResultSet rs)throws SQLException{
        dto.setId(rs.getInt("id"));
        dto.setCategoria(rs.getString("categoria"));
        dto.setPlaca(rs.getString("placa"));
        dto.setMarca(rs.getString("marca"));
        dto.setModelo(rs.getString("modelo"));
        dto.setCor(rs.getString("cor"));
        dto.setAno(rs.getInt("ano"));
        dto.setCidade(rs.getString("cidade"));
        dto.setUf(rs.getString("uf"));
        dto.setValor(rs.getFloat("valor"));
        dto.setAlarme(rs.getBoolean("alarme"));
    }
}
