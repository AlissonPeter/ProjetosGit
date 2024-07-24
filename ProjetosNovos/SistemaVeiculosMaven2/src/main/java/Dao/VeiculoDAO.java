/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Veiculo;


/**
 *
 * @author Alisson
 */
public class VeiculoDAO {
    
	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cadveiculos");
	final  EntityManager entityManager = entityManagerFactory.createEntityManager();
	   
       public void inserir(Veiculo veiculo) {

    	   try {
    		   entityManager.getTransaction().begin();
    		   entityManager.persist(veiculo);
    		   entityManager.getTransaction().commit();
    	   } catch (Exception e) {
    		e.printStackTrace();   
    	   }
			// TODO: handle exception
		}
       
    public void atualizar(Veiculo veiculo) {
    	 try {
  		   entityManager.getTransaction().begin();
  		   entityManager.merge(veiculo);
  		   entityManager.getTransaction().commit();
  	   } catch (Exception e) {
  		e.printStackTrace();   
  	   }
    }
    
    public void remover(Veiculo veiculo) {
    	try {
   		   entityManager.getTransaction().begin();
   		   entityManager.remove(veiculo);
   		   entityManager.getTransaction().commit();
   	   } catch (Exception e) {
   		e.printStackTrace();   
   	   }
    }
    
    public void removerTudo() {
        try {
        	entityManager.getTransaction().begin();
            final String SQL_DELETE = "DELETE FROM Veiculo";
            entityManager.createNativeQuery(SQL_DELETE, Veiculo.class).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Veiculo getVeiculoPorPlaca(String placa) throws Exception {
        try {
        	List<Veiculo> v = entityManager.createNativeQuery("SELECT * FROM veiculo WHERE placa = :placa", Veiculo.class)
        			.setParameter("placa", placa).getResultList();    
     		return v.size() == 0 ? null : v.get(0);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
       
    public List<Veiculo> findAll(){
    	List<Veiculo> vList = (List<Veiculo>) entityManager.createNativeQuery("Select * FROM veiculo", Veiculo.class).getResultList();    
 		return vList;
		
    }

}
