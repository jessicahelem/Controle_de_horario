//import android.widget.Spinner;
//
//import com.example.controledehorarios.models.Curso;
//import com.example.controledehorarios.models.Professor;
//import com.example.controledehorarios.models.Turma;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Teste {
//
//    public List<Curso> cursos = new ArrayList<>();
//    public List<Turma>turmas = new ArrayList<>();
//    public List<Disciplina>disciplinas  = new ArrayList<>();
//    public List<Professor>professores  = new ArrayList<>();
//    public Spinner spinnerTurma;
//
//
//    public Teste(List<Curso> cursos, List<Turma> turmas, List<Disciplina> disciplinas, List<Professor> professores) {
//       getCursos();
//       getDisciplinas();
//       getProfessor();
//       getTurmas();
//
//    }
//
//    public List<Curso> getCursos() {
//
//
//        return this.cursos;
//    }
//
//    public void setCursos(List<Curso> cursos) {
//        this.cursos = cursos;
//    }
//
//    public List<Turma> getTurmas() {
//
//        Turma Vperiodo = new Turma(1,professores.get(1),disciplinas.get(1),60,cursos.get(1),"5º sala 8", "10/07/2019", "23/07/2019");
//        turmas.add(Vperiodo);
//        return turmas;
//    }
//
//    public void setTurmas(List<Turma> turmas) {
//        this.turmas = turmas;
//    }
//
//    public List<Disciplina> getDisciplinas() {
//        return disciplinas;
//    }
//
//    public void setDisciplinas(List<Disciplina> disciplinas) {
//        this.disciplinas = disciplinas;
//    }
//
//    public List<Professor> getProfessor() {
//        Professor prof1 = new Professor("1","helcio","000-0000");
//        professores.add(prof1);
//        return professores;
//    }
//
//    public void setProfessor(List<Professor> professores) {
//        this.professores = professores;
//    }
//
//
//    public Spinner getSpinnerTurma() {
//        return spinnerTurma;
//    }
//
//    public void setSpinnerTurma(Spinner spinnerTurma) {
//        this.spinnerTurma = spinnerTurma;
//    }
//}
