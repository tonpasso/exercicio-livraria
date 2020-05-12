package dao;

import java.util.List;

import entidade.Livro;

public interface LivroDAO {
	
	public void inserir(Livro livro);
	
	public void alterar(Livro livro);
	
	public void remover(Livro livro);
	
	public Livro pesquisar(String codigo);
	
	public List<Livro> listarTodos();

}
