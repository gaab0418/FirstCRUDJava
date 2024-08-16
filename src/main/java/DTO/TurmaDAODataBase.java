package DTO;

import DAO.IDAO;
import entities.Aluno;
import entities.Professor;
import entities.Turma;
import util.ConnectorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAODataBase implements IDAO<Turma> {

    Connection con = ConnectorDataBase.getConnection();

    @Override
    public List<Turma> getAll() {
        try{
            List<Turma> turmasList = new ArrayList<>();
            String sql = "SELECT * FROM db_school.turma";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 turmasList.add(new Turma(
                         rs.getInt("id"),
                         rs.getString("nome"),
                         rs.getInt("professor_id"),
                         rs.getInt("alunos_IDs") // problema aqui
                 ));
            }
            return turmasList;
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public Turma getById(int id) {
        try{
            String sql = "SELECT * FROM db_school.turma WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Turma(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("professor_id"),
                        rs.getInt("alunos_IDs")); //problema aqui
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
        return null;
    }

    @Override
    public void save(Turma obj) {
        try{
            String sql = "INSERT INTO db_school.turma values(default, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getTurmaNome());
            ps.setInt(2, obj.getProfessor().getId());
            StringBuilder builder = new StringBuilder();
            for (Aluno aluno : obj.getAlunos()){
                builder.append("'");
                builder.append(aluno.getId());
                builder.append("',");
            }
            builder.delete(builder.length() -1, builder.length());
            ps.setString(3, builder.toString()); // alunos id aqui
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

    @Override
    public void delete(int id) {
        try{
            String sql = "DELETE from db_school.turma WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e);
        }
    }

}
