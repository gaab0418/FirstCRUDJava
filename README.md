
# Primeiro CRUD em Java + MySql

Meu primeiro projeto feito no SENAI no técnico de DS com um CRUD em um banco Mysql, lançado no meu github apenas para marcar o inicio e ver a evolução com novos projetos, este projeto é de 27/04/2024.

Neste banco de dados, possuem tabelas de PROFESSORES, TURMAS e ALUNOS, se tratando de dados simples.


## Uso/Exemplos

```java
import DTO.AlunoDAODataBase;
import DTO.ProfessorDAODataBase;
import DTO.TurmaDAODataBase;
import entities.Aluno;
import entities.Professor;
import entities.Turma;


ProfessorDAODataBase dbProf = new ProfessorDAODataBase();
dbProf.save(new Professor("nome professor", 53, 3435.3));

AlunoDAODataBase dbAlun = new AlunoDAODataBase();
dbAlun.save(new Aluno("Aluno", 16));
dbAlun.save(new Aluno("Aluno2", 46));
dbAlun.save(new Aluno("Aluno3", 36));
dbAlun.save(new Aluno("Aluno4", 26));

Turma turma = new Turma("Turma A", dbProf.getById(1) );
for(int i = 0; i < dbAlun.getAll().size(); i++){
    turma.addAluno(dbAlun.getAll().get(i));
}

TurmaDAODataBase dbTurma = new TurmaDAODataBase();
dbTurma.save(turma);
```


## Melhorias

Simplesmente o código inteiro possui muita verbosidade, poderia ser enxugado muitas funções para transofrmar em algo mais simples, também o modelo do banco que havia sido feito, não possui nem Foreign Keys, então seria mais facil começar novamente do zero.
