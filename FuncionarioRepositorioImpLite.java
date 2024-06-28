package Repositorio;

import Interfaces.FuncionarioRepositorio;
import Modelo.Funcionario;
import Utlidades.Conexion;
import Utlidades.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorioImpLite implements FuncionarioRepositorio {

    @Override
    public boolean create(Funcionario funcionario) {
        Constantes.SQL = "INSERT INTO funcionario(nombre, edad, cargo) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conexionl();
             PreparedStatement ps = con.prepareStatement(Constantes.SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                Constantes.MENSAJE = "Registro Guardado Exitosamente";
                return true;
            } else {
                Constantes.MENSAJE = "No se pudo guardar el registro";
                return false;
            }

        } catch (SQLException e) {
            Constantes.MENSAJE = "Error al intentar guardar el registro: " + e.getMessage();
            return false;
        }
    }

    @Override
    public Funcionario read(int id) {
        Constantes.SQL = "SELECT * FROM funcionario WHERE id=?";
        try (Connection con = Conexion.conexionl();
             PreparedStatement ps = con.prepareStatement(Constantes.SQL)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setId(rs.getInt("id"));
                    funcionario.setNombre(rs.getString("nombre"));
                    funcionario.setEdad(rs.getInt("edad"));
                    funcionario.setCargo(rs.getString("cargo"));
                    Constantes.MENSAJE = "Consulta realizada exitosamente";
                    return funcionario;
                } else {
                    Constantes.MENSAJE = "No se encontró el funcionario con id " + id;
                    return null;
                }
            }

        } catch (SQLException e) {
            Constantes.MENSAJE = "Error al intentar leer el registro: " + e.getMessage();
            return null;
        }
    }

    @Override
    public List<Funcionario> readAll() {
        Constantes.SQL = "SELECT * FROM funcionario ORDER BY nombre";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection con = Conexion.conexionl();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(Constantes.SQL)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setEdad(rs.getInt("edad"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }

            if (funcionarios.isEmpty()) {
                Constantes.MENSAJE = "No se encontraron funcionarios";
            } else {
                Constantes.MENSAJE = "Consulta realizada exitosamente";
            }

        } catch (SQLException e) {
            Constantes.MENSAJE = "Error al intentar leer los registros: " + e.getMessage();
        }

        return funcionarios;
    }

    @Override
    public boolean update(Funcionario funcionario) {
        Constantes.SQL = "UPDATE funcionario SET nombre=?, edad=?, cargo=? WHERE id=?";
        try (Connection con = Conexion.conexionl();
             PreparedStatement ps = con.prepareStatement(Constantes.SQL)) {

            ps.setString(1, funcionario.getNombre());
            ps.setInt(2, funcionario.getEdad());
            ps.setString(3, funcionario.getCargo());
            ps.setInt(4, funcionario.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                Constantes.MENSAJE = "Registro Actualizado Exitosamente";
                return true;
            } else {
                Constantes.MENSAJE = "No se encontró el funcionario con id " + funcionario.getId();
                return false;
            }

        } catch (SQLException e) {
            Constantes.MENSAJE = "Error al intentar actualizar el registro: " + e.getMessage();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Constantes.SQL = "DELETE FROM funcionario WHERE id=?";
        try (Connection con = Conexion.conexionl();
             PreparedStatement ps = con.prepareStatement(Constantes.SQL)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                Constantes.MENSAJE = "Registro eliminado Exitosamente";
                return true;
            } else {
                Constantes.MENSAJE = "No se encontró el funcionario con id " + id;
                return false;
            }

        } catch (SQLException e) {
            Constantes.MENSAJE = "Error al intentar eliminar el registro: " + e.getMessage();
            return false;
        }
    }
}
