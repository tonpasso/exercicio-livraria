package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import dao.LivroDAO;
import dao.LivroDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Livro;
import entidade.Usuario;
import util.JpaUtil;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	private String txtUsuario;
	private String txtSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario; // Objeto para cadastro
	private String msgCadastroUsuario;
	
	private UsuarioDAO usuarioDAO;
	
	private List<Livro> listaLivros;
	private Livro livro; // Objeto para cadastro
	private String msgCadastroLivro;
	
	private LivroDAO livroDAO;

	/**
	 * Construtor para inicializar a lista de usuarios e livros
	 */
	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
		
		this.listaLivros = new ArrayList<Livro>();
		this.livro = new Livro();
		this.livroDAO = new LivroDAOImpl();
	}

		

	/**
	 * Metodo responsavel por validar o usuario no login
	 */
	public String entrar() {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getCpf().equals(this.txtUsuario) && usuarioPesquisa.getSenha().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if (achou) {
			return "listaLivro.xhtml";
		} else {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario inexistente ou senha incorreta!!!"));
			return "login.xhtml";
		}

	}

	/**
	 * Metodo responsavel por criar um novo usuario na lista
	 */
	public void criarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setCpf(this.usuario.getCpf());
		novo.setEmail(this.usuario.getEmail());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listarTodos();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getCpf().equals(this.usuario.getCpf())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!!!"));
		}else {
//			this.listaUsuarios.add(novo);
			this.usuarioDAO.inserir(novo);
			
			this.usuario = new Usuario();	
			
			System.out.println("Criado com sucesso");
		}
	}
	
	/**
	 * Metodo responsavel por criar um novo livro na lista
	 */
	
	public void criarLivro() {

		Livro novo = new Livro();
		
		novo.setCodigo(this.livro.getCodigo());
		novo.setTitulo(this.livro.getTitulo());
		novo.setAutor(this.livro.getAutor());
		novo.setCategoria(this.livro.getCategoria());
		
		boolean achou = false;
		
		this.listaLivros = this.livroDAO.listarTodos();
		
		for (Livro livroPesquisa : listaLivros) {
			if(livroPesquisa.getCodigo().equals(this.livro.getCodigo())) {
				achou = true;
			}
			
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Livro já cadastrado!!!"));
		} else {
			this.listaLivros.add(novo);
			this.livroDAO.inserir(novo);
			
			this.livro = new Livro();
			
			System.out.println("Livro cadastrado!");
		}
	
			
	}
	
	
	/**
	 * Metodo responsavel por criar lista de livros
	 */
	
	public String listarLivros() {
		listaLivros = new LivroDAOImpl().listarTodos();
		return "selecaoLivro.xhtml";
	}
	
	/**
	 * Metodo responsavel por sair da lista de livros
	 */
	
	public String sairListaLivros() {
		return "listaLivro.xhtml";
	}
	
	
	/**
	 * Metodo responsavel por sair da tela de pesquisa de livros
	 */
	public String sairPesquisaLivros() {
		return "login.xhtml";
	}
	
	/**
	 * Metodo responsavel por editar livros
	 */
	
	
	
	

	public String getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getMsgCadastroLivro() {
		return msgCadastroLivro;
	}

	public void setMsgCadastroLivro(String msgCadastroLivro) {
		this.msgCadastroLivro = msgCadastroLivro;
	}

}