package entities;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String turmaNome;
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;


    public Turma(String turmaNome, Professor professor) {
        this.turmaNome = turmaNome;
        this.professor = professor;
    }
    public Turma(){}

    public Turma(int id, String nome, int professorId, int alunosIDs) {

    }

    public void addAluno(Aluno x) {
        this.alunos.add(x);
    }

    @Override
    public String toString() {
        return "Nome: " + this.turmaNome + " Professor: " + this.professor + ", Alunos da turma ("+ this.alunos.size()+"):\n" + this.alunos;
    }


    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

//    public String getAlunosID(){
//        StringBuilder builder = new StringBuilder();
//        for (Aluno aluno : alunos){
//            builder.append(aluno.getId());
//        }
//        return builder.toString();
//    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
