package DTO;

import DAO.IDAO;
import entities.Professor;
import util.ConnectorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAODataBase implements IDAO<Professor> {

    Connection con = ConnectorDataBase.getConnection();

    @Override
    public List<Professor> getAll() {
        try{
            List<Professor> profes = new ArrayList<>();
            String sql = "SELECT * FROM db_school.professores";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 profes.add(new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade")));
            }
            return profes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public Professor getById(int id) {
        try{
            String sql = "SELECT * FROM db_school.professores WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Professor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
        return null;
    }

    @Override
    public void save(Professor obj) {
        try{
            String sql = "INSERT INTO db_school.professores values(default, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setInt(2, obj.getIdade());
            ps.setDouble(3, obj.getSalario());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE from db_school.professores WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }
}
