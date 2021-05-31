package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import util.Conexion;

public class CandidatoDao {
	private Conexion conexion;

	private static final String INSERTAR = "INSERT INTO CANDIDATO (DOCUMENTO, NOMBRE, APELLIDO, ELECCION, NUMERO) VALUES (?, ?, ?, ?, ?);";
	private static final String ELIMINAR = "DELETE FROM CANDIDATO WHERE ID = ?;";
	private static final String ACTUALIZAR = "UPDATE CANDIDATO SET DOCUMENTO = ?, NOMBRE = ? APELLIDO ID = ? ELECCION ID = ? NUMERO ID = ? WHERE ID = ?;";
	private static final String LISTAR = "SELECT C.*, E.NOMBRE FROM CANDIDATO C INNER JOIN ELECCION E ON C.ELECCION = E.ID;";
	private static final String GET_BY_ID = "SELECT * FROM CANDIDATO C WHERE C.ID = ?;";
	
	public CandidatoDao() {
		this.conexion = Conexion.getConexion();
	}
	
	public void registrar(Candidato candidato) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(INSERTAR);
			ps.setString(1, candidato.getDocumento());
			ps.setString(2, candidato.getNombre());
			ps.setString(3, candidato.getApellido());
			ps.setInt(4, candidato.getEleccion());
			ps.setInt(5, candidato.getNumero());
			conexion.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Candidato registrado");
		}
	}

	public void eliminar(int id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(ELIMINAR);
			ps.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Candidato eliminado satisfactoriamente");
		}
	}
	
	public void actualizar(Candidato candidato) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(ACTUALIZAR);
			ps.setString(1, candidato.getDocumento());
			ps.setString(2, candidato.getNombre());
			ps.setString(3, candidato.getApellido());
			ps.setInt(4, candidato.getEleccion());
			ps.setInt(5, candidato.getNumero());
			ps.setInt(6, candidato.getId());
			conexion.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Candidato actualizado correctamente");
		}
	}
	
	public List<Candidato> listar() {
		List<Candidato> candidatos = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();
			candidatos = new ArrayList<Candidato>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String documento = rs.getString("documento");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				Candidato candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
				candidatos.add(candidato);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Operación exitosa");
		}
		return candidatos;
	}
	
	public Candidato porId (int id) {
		Candidato candidato = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(GET_BY_ID);
			ps.setInt(1, id);
			
			ResultSet rs = conexion.query();
			while (rs.next()) {
				int idBD = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String documento = rs.getString("documento");
				int eleccion = rs.getInt("eleccion");
				int numero = rs.getInt("numero");
				candidato = new Candidato(idBD, documento, nombre, apellido, eleccion, numero);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Registro encontrado");
		}
		return candidato;
	}
}
