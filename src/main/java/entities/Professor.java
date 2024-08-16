package entities;

public class Professor extends Pessoa{

    private Double salario;
    private int id;

    public Professor (){}
    public Professor(String nome, int idade, Double salario) {
        super(nome, idade);
        this.salario = salario;
    }
    public Professor(Double salario) {
        this.salario = salario;
    }

    public Professor(int id, String nome, int idade) {
        super(nome, idade);
        this.id = id;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "{"+"nome="+ this.getNome() + ",salario=" + salario + '}';
    }

    public int getId(){
        return id;
    }
}
