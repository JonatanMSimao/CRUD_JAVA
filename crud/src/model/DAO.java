package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** M�dulo de conex�o **/
	// Par�metros de Conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbcadastro?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// M�todo de Conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Crud Create **/
	public void inserirUsuario(JavaBeans usuario) {
		String create = "insert into usuarios (nome,email,fone) values (?,?,?)";
		try {
			// abrir a conex�o
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pstm = con.prepareStatement(create);
			// Substituir par�mentros (?) pelo conte�do das vari�veis JavaBeans
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getFone());
			// Executar a query
			pstm.executeUpdate();
			// Encerrar conex�o com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Crud Read **/
	public ArrayList<JavaBeans> listarUsuarios() {
		// criando objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> usuario = new ArrayList<>();
		String read = "select * from usuarios order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(read);
			ResultSet rs = pstm.executeQuery();
			// o la�o ser� executado enquanto houver usu�rios
			while (rs.next()) {
				// vari�veis que recebe os dados do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String fone = rs.getString(4);
				// armazenar tudo que chega do banco
				usuario.add(new JavaBeans(id, nome, email, fone));

			}
			con.close();
			return usuario;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** Crud Update **/
	// selecionar o usu�rio
	public void selecionarUsuario(JavaBeans usuario) {
		String read2 = "select * from usuarios where id = ? ";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(read2);
			pstm.setString(1, usuario.getId());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				// setar vari�veis JavaBeans
				usuario.setId(rs.getString(1));
				usuario.setNome(rs.getString(2));
				usuario.setEmail(rs.getString(3));
				usuario.setFone(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar usu�rio
	public void alterarUsuario(JavaBeans usuario) {
		String update = "update usuarios set nome=?,email=?,fone=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(update);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getFone());
			pstm.setString(4, usuario.getId());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Crud Delete **/

	public void excluirUsuario(JavaBeans usuario) {
		String delete = "delete from usuarios where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(delete);
			pstm.setString(1, usuario.getId());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
