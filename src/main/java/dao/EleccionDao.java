package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.Eleccion;
import util.Conexion;

public class EleccionDao {
	private Conexion conexion;

	private static final String INSERTAR = "INSERT INTO ELECCION (NOMBRE, FECHAINICIO, FECHAFIN, CARGO) VALUES (?, ?, ?, ?);";
	private static final String LISTAR = "SELECT * FROM ELECCION;";
	
	public EleccionDao() {
		this.conexion = Conexion.getConexion();
	}
	
	public void registrar(Eleccion eleccion) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(INSERTAR);
			ps.setString(1, eleccion.getNombre());
			ps.setDate(2, eleccion.getFechainicio());
			ps.setDate(3, eleccion.getFechafin());
			ps.setString(4, eleccion.getCargo());
			conexion.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Elección registrada");
		}
	}
	
	public List<Eleccion> listar() {
		List<Eleccion> elecciones = null;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(LISTAR);
			ResultSet rs = conexion.query();
			elecciones = new ArrayList<Eleccion>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Date fechainicio = Date.valueOf(rs.getString("fechainicio"));
				Date fechafin = Date.valueOf(rs.getString("fechafin"));
				String cargo = rs.getString("cargo");
				Eleccion eleccion = new Eleccion(id, nombre, fechainicio, fechafin, cargo);
				elecciones.add(eleccion);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Operación exitosa");
		}
		return elecciones;
	}
}
