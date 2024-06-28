package Repositorio;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import Utlidades.Conexion;
import Utlidades.Constantes;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioRepositorioImpPost implements FuncionarioRepositorio {
    
    @Override
    public boolean create(Funcionario funcionario) {
        Constantes.SQL = "INSERT INTO funcionarios(nombre,edad,cargo)"
                + "VALUES(?,?,?)";
        Connection con = Conexion.conexionp();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());
            Constantes.MENSAJE = "Registro Guardado Exitosamente";
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return false;
        }
    }
    
    @Override
    public Funcionario read(int id) {
        Constantes.SQL = "SELECT * FROM funcionarios WHERE id=?";
        Connection con = Conexion.conexionp();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Funcionario funcionario = null;
            Constantes.MENSAJE = "Registro no encontrado";
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setEdad(rs.getInt("edad"));
                funcionario.setCargo(rs.getString("cargo"));
                Constantes.MENSAJE="La consulta se ha realizado exitosamente!!!"; 
            }
            return funcionario;
            
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return null;
        }
    }
    
    @Override
    public List<Funcionario> readAll() {
        Constantes.SQL="SELECT * FROM funcionarios ORDER BY nombre";
        Connection con = Conexion.conexionp();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Constantes.SQL);
             Funcionario funcionario = null;
            Constantes.MENSAJE = "Registro no encontrado";
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setEdad(rs.getInt("edad"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
               
            }
            
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
        }
        return funcionarios;
    
        
    }
    
    @Override
    public boolean update(Funcionario funcionario) {
        Constantes.SQL = "UPDATE funcionarios SET nombre=?,edad=?,cargo=? WHERE id=?";
        Connection con = Conexion.conexionp();
        try {
            PreparedStatement ps=con.prepareStatement(Constantes.SQL);
            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());
            ps.setInt(4, funcionario.getId());
            Constantes.MENSAJE="Registro Actualizado Existosamente";
            return ps.executeUpdate()>0;
            
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return false;
        }
    }
    
    @Override
    public boolean delete(int id) {
        Constantes.SQL="DELETE FROM funcionarios WHERE id=?";
        Connection con = Conexion.conexionp();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setInt(1, id);
            Constantes.MENSAJE="Registro eliminado Exitosamente!!";
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
            return false;
        }
    }
    
}
