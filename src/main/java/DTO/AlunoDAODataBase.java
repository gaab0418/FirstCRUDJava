package DTO;

import DAO.IDAO;
import entities.Aluno;
import util.ConnectorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAODataBase implements IDAO<Aluno> {

    Connection con = ConnectorDataBase.getConnection();

    @Override
    public List<Aluno> getAll() {
        try{
            List<Aluno> alunos = new ArrayList<>();
            String sql = "SELECT * FROM db_school.alunos";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 alunos.add(new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade")));
            }
            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public Aluno getById(int id) {
        try{
            String sql = "SELECT * FROM db_school.alunos WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Aluno(
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
    public void save(Aluno obj) {
        try{
            String sql = "INSERT INTO db_school.alunos values(default, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setInt(2, obj.getIdade());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE from db_school.alunos WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }



}
