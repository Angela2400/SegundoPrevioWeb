package co.edu.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.java.utils.*;
import co.edu.java.modelo.Pais;
import co.edu.java.utils.Conexion;


public class PaisDao {

	private Conexion conexion;
	private static final String insertarSQL = "INSERT INTO country (id,nombre) Values (?,?);";
	private static final String eliminarSQL = "DELETE FROM country WHERE id = ?;";
	private static final String actualizarSQL = "UPDATE country SET nombre=?bWHERE id=?;";
	private static final String seleccionarID = "SELECT * from country WHERE id=?;";
	private static final String seleccionarSQL = "SELECT * from country;";
	
	public PaisDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Pais pais) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			ps.setString(1, pais.getId());
			ps.setString(1, pais.getNombre());
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public void delete(String id) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(eliminarSQL);
			ps.setString(1, id);
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public void update(Pais pais) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarSQL);
			ps.setString(1, pais.getNombre());
			ps.setString(2, pais.getId());
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public List<Pais> selectAll(){
		List<Pais> paises =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				paises.add(new Pais(id,nombre));
			}
		} catch(SQLException e) {
			
		}
		return paises;
	}
	
	public Pais select(String id){
		Pais usuario = null ;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarID);
			ps.setString(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				usuario= new Pais(id,nombre);
			}
		} catch(SQLException e) {
			
		}
		return usuario;
	}
}
	
