package cl.awakelab.miprimerspring0057.service;
import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Profesor;

import java.util.List;

public interface ICursoService {
    public Curso crearCurso(Curso nuevoCurso);
    public Curso actualizarCurso(int id, Curso curso);
    public List<Curso> listarCurso();
    public List<Alumno> listarAlumnosCurso(int id);
    public Curso listarCursoID(int idCurso);
    public void eliminarCurso(int id);
    public void eliminarCurso2(Curso curso);
    public void asignarProfesor(int idCurso, int idProfesor);

    public void asignarAlumno(int idCurso, int idAlumno);

}
