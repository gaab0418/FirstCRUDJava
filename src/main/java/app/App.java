package app;

import DTO.AlunoDAODataBase;
import DTO.ProfessorDAODataBase;
import DTO.TurmaDAODataBase;
import entities.Aluno;
import entities.Professor;
import entities.Turma;

public class App {
    public static void main(String[] args) {


        Professor prof = new Professor("nome professor", 53, 3435.3);
        ProfessorDAODataBase dbProf = new ProfessorDAODataBase();
        dbProf.save(prof);
        AlunoDAODataBase dbAlun = new AlunoDAODataBase();
        dbAlun.save(new Aluno("Aluno", 16));
        dbAlun.save(new Aluno("Aluno2", 46));
        dbAlun.save(new Aluno("Aluno3", 36));
        dbAlun.save(new Aluno("Aluno4", 26));
        TurmaDAODataBase dbTurma = new TurmaDAODataBase();

        Turma turma = new Turma("Turma A", prof );
        for(int i = 0; i < dbAlun.getAll().size(); i++){
            turma.addAluno(dbAlun.getAll().get(i));
        }
        dbTurma.save(turma);

    }
}