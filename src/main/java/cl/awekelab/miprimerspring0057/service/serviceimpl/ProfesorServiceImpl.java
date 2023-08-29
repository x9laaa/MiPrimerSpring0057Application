package cl.awekelab.miprimerspring0057.service.serviceimpl;

import cl.awekelab.miprimerspring0057.entity.Profesor;
import cl.awekelab.miprimerspring0057.repository.IProfesorRepository;
import cl.awekelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    IProfesorRepository objProfesorRepo;
    @Override
    public Profesor crearProfesor(Profesor profesorCreado) {
        Profesor nuevoProfesor= new Profesor();
        nuevoProfesor = objProfesorRepo.save(profesorCreado);
        return nuevoProfesor;
    }

    @Override
    public Profesor actualizarProfesor(int id) {
        return null;
    }

    @Override
    public List<Profesor> listarProfesor() {
        return null;
    }

    @Override
    public Profesor listarProfesorID(int idProfesor) {
        return null;
    }

    @Override
    public void eliminarProfesor(int id) {

    }
}
