package cl.awakelab.miprimerspring0057.service.serviceimpl;
import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.repository.ICursoRepository;
import cl.awakelab.miprimerspring0057.repository.IProfesorRepository;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService{

    @Autowired
    ICursoRepository objCursoRepo;

    @Autowired
    IProfesorRepository objProfesorRepo;

    @Override
    public Curso crearCurso(Curso nuevoCurso) {
        return objCursoRepo.save(nuevoCurso);
    }

    @Override
    public Curso actualizarCurso(int id, Curso curso) {
        Curso cursoActulizar = objCursoRepo.findById(id).orElse(null);
        cursoActulizar.setNombreCurso(curso.getNombreCurso());
        return objCursoRepo.save(cursoActulizar);
    }

    @Override
    public List<Curso> listarCurso() {
        return objCursoRepo.findAll();
    }
    public List<Alumno> listarAlumnosCurso(int id){
        Curso listaCurso = objCursoRepo.findById(id).orElse(null);
        return listaCurso.getListaAlumnos();
    }

    @Override
    public Curso listarCursoID(int idCurso) {
        return objCursoRepo.findById(idCurso).orElse(null);
    }

    @Override
    public void eliminarCurso(int id) {
        objCursoRepo.deleteById(id);
    }
    @Override
    public void eliminarCurso2(Curso curso) {
        objCursoRepo.delete(curso);
    }

    @Override
    public void asignarProfesor(int idCurso, int idProfesor) {
        Curso curso = objCursoRepo.findById(idCurso).orElse(null);
        curso.getListaProfesores().add(objProfesorRepo.findById(idProfesor).orElse(null));
        objCursoRepo.save(curso);
    }
}
