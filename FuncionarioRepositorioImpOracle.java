/*package Repositorio;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import Utlidades.Conexion;
import Utlidades.Constantes;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioRepositorioImpOracle implements FuncionarioRepositorio {
    
    @Override
    public boolean create(Funcionario funcionario) {
    Constantes.SQL = "INSERT INTO funcionario(NOMBRE, EDAD, CARGO) VALUES (?, ?, ?)";
    Connection con = Conexion.conexiono();
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
        Constantes.SQL = "SELECT * FROM funcionario WHERE ID=?";
        Connection con = Conexion.conexiono();
        try {
            PreparedStatement ps = con.prepareStatement(Constantes.SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Funcionario funcionario = null;
            Constantes.MENSAJE = "Registro no encontrado";
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("ID"));
                funcionario.setNombre(rs.getString("NOMBRE"));
                funcionario.setEdad(rs.getInt("EDAD"));
                funcionario.setCargo(rs.getString("CARGO"));
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
        Constantes.SQL="SELECT * FROM funcionario ORDER BY NOMBRE";
        Connection con = Conexion.conexiono();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Constantes.SQL);
             Funcionario funcionario = null;
            Constantes.MENSAJE = "Registro no encontrado";
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("ID"));
                funcionario.setNombre(rs.getString("NOMBRE"));
                funcionario.setEdad(rs.getInt("EDAD"));
                funcionario.setCargo(rs.getString("CARGO"));
                funcionarios.add(funcionario);
               
            }
            
        } catch (SQLException e) {
            Constantes.MENSAJE=e.getMessage();
        }
        return funcionarios;
    
        
    }
    
    @Override
    public boolean update(Funcionario funcionario) {
        Constantes.SQL = "UPDATE funcionario SET NOMBRE=?,EDAD=?,CARGO=? WHERE ID=?";
        Constantes.SQL="";
        Connection con = Conexion.conexiono();
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
        Constantes.SQL="DELETE FROM funcionario WHERE ID=?";
        Connection con = Conexion.conexiono();
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
*/