package co.edu.java.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.java.modelo.Equipo;
import co.edu.java.modelo.Pais;
import co.edu.java.utils.Conexion;

public class EquipoDao {

	private Conexion conexion;
	
	private static final String insertarSQL = "INSERT INTO team (id,name,country) Values (?,?,(SELECT name FROM country where id=?);";
	private static final String actualizarSQL = "UPDATE team SET nombre=?, country=? WHERE id=?;";
	private static final String eliminarSQL = "DELETE FROM team WHERE id = ?;";
	private static final String seleccionarID = "SELECT * from team WHERE id=?;";
	private static final String seleccionarSQL = "SELECT * from team;";


	public EquipoDao() {
		this.conexion= Conexion.getConexion();
	}
	
	public void insert(Equipo equipo) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(insertarSQL);
			ps.setString(1, equipo.getId());
			ps.setString(2, equipo.getNombre());
			ps.setString(3, equipo.getPais());
			conexion.execute();
		} catch(SQLException e) {
			
		}
	}
	
	public void update(Equipo equipo) throws SQLException {
		try {
			PreparedStatement ps = conexion.setPreparedStatement(actualizarSQL);
			ps.setString(1, equipo.getNombre());
			ps.setString(2, equipo.getPais());
			ps.setString(3, equipo.getId());
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
	
	public List<Equipo> selectAll(){
		List<Equipo> equipos =  new ArrayList<>();
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarSQL);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("name");
				String pais = rs.getString("country");
				equipos.add(new Equipo(id,nombre,pais));
			}
		} catch(SQLException e) {
			
		}
		return equipos;
	}
	
	public Equipo select(String id){
		Equipo equipo = null ;
		try {
			PreparedStatement ps = conexion.setPreparedStatement(seleccionarID);
			ps.setString(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				String nombre = rs.getString("name");
				String pais = rs.getString("country");
				equipo= new Equipo(id,nombre,pais);
			}
		} catch(SQLException e) {
			
		}
		return equipo;
	}
	
	
}
