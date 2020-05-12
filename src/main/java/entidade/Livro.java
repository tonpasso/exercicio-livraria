package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro {
	
	@Id
	@Column(name = "CODIGO", nullable = false)
	private String codigo;
	
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "AUTOR", nullable = false)
	private String autor;
	
	@Column(name = "CATEGORIA", nullable = false)
	private String categoria;
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
