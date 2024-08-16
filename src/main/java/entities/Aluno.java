package entities;

public class Aluno extends Pessoa {

    private Double nota;
    private int id;

    public Aluno(){}
    public Aluno(String nome, int idade) {
        super(nome, idade);
    }
    public Aluno(String nome, int idade, Double nota) {
        super(nome, idade);
        this.nota = nota;
    }
    public Aluno(int id, String nome, int idade) {
        super(nome, idade);
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" + "nome="+ this.getNome() + ",idade=" + this.getIdade() + ",nota=" + this.nota + '}';
    }



    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public int getId(){
        return id;
    }

}
