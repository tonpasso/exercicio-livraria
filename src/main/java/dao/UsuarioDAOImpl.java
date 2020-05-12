package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementa��o ela recebe no construtor o entityManager,
 *  a conex�o com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class UsuarioDAOImpl implements UsuarioDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transi��o, inicia e 
	 * executar a a��o de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Usuario usuario) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(usuario);
		
		tx.commit();
		ent.close();

	}

/**
 * Metodo alterar, recebe o usuario, criar uma transi��o, inicia e executa a a��o de merger
 */
	public void alterar(Usuario usuario) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(usuario);
		
		tx.commit();
		ent.close();

	}


	public void remover(Usuario usuario) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(usuario);
		
		tx.commit();
		ent.close();
		
	}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Usuario pesquisar(String cpf) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Usuario usuario = ent.find(Usuario.class, cpf);
		
		return usuario;
		
	}

/**
 * O metodo listar todos, faz um select * from, por�m com o JPA, vc faz a consulta pelo objeto direto
 * assim from Usuario, que isso � o objeto usuario e n�o a tabela
 */
	public List<Usuario> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Usuario u");
		
		List<Usuario> usuarios = query.getResultList();
	
		return usuarios;
		
	}
	
	
	
}
