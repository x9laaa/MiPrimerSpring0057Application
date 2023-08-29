package cl.awekelab.miprimerspring0057.service.serviceimpl;

import cl.awekelab.miprimerspring0057.entity.Alumno;
import cl.awekelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {
   @Autowired

    @Override
    public Alumno crearAlumno(Alumno nuevoAlumno) {
        return null;
    }

    @Override
    public Alumno actualizarAlumno(int id) {
        return null;
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return null;
    }

    @Override
    public Alumno listarAlumnosID(int idAlumno) {
        return null;
    }

    @Override
    public void eliminarAlumno(int id) {

    }
}
