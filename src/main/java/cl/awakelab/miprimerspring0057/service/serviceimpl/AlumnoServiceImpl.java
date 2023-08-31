package cl.awakelab.miprimerspring0057.service.serviceimpl;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepository objAlumnoRepo;

    @Override
    public Alumno crearAlumno(Alumno crearAlumno) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno = objAlumnoRepo.save(crearAlumno);
        return nuevoAlumno;
    }

    @Override
    public Alumno actualizarAlumno(int id) {
        return null;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return objAlumnoRepo.findAll();
    }

    @Override
    public Alumno listarAlumnosID(int idAlumno) {
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {

    }
}
