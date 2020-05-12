package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Livro;
import util.JpaUtil;

public class LivroDAOImpl implements LivroDAO {
	
	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	
	public void inserir(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();	
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(livro);
		tx.commit();
		
		ent.close();
	
	}
	
	/**
	 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
	 */
	
	public void  alterar(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(livro);
		tx.commit();
		
		ent.close();
	}
	
	public void remover(Livro livro) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(livro);
		tx.commit();
		
		ent.close();
	}
	
	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o codigo
	 */
	
	public Livro pesquisar(String codigo) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Livro livro = ent.find(Livro.class, codigo);
		
		return livro;
	}
	
	/**
	 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
	 * assim from Usuario, que isso é o objeto usuario e não a tabela
	 */
	
	public List<Livro> listarTodos(){
		
		EntityManager ent = JpaUtil.getEntityManager();
		Query query = ent.createQuery("from Livro l");
		
		List<Livro> livros = query.getResultList();
		
		return livros;
		
	}
	
	
	


}
