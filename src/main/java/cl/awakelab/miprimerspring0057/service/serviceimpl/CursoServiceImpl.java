package cl.awakelab.miprimerspring0057.service.serviceimpl;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.repository.ICursoRepository;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("cursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    ICursoRepository objCursoRepo;
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
}
