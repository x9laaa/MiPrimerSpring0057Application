package cl.awakelab.miprimerspring0057.service.serviceimpl;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.repository.IProfesorRepository;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
    public Profesor actualizarProfesor(int id, Profesor profesor) {
        Profesor profesorActualizar = objProfesorRepo.findById(id).orElse(null);
        profesorActualizar.setNombres(profesor.getNombres());
        profesorActualizar.setApellido2(profesor.getApellido2());
        profesorActualizar.setApellido1(profesor.getApellido1());
        return objProfesorRepo.save(profesorActualizar);
    }
    @Override
    public List<Profesor> listarProfesor() {
        List<Profesor> listaMostrar = new ArrayList<Profesor>();
        listaMostrar = objProfesorRepo.findAll();
        return listaMostrar;
    }

    @Override
    public Profesor listarProfesorID(int idProfesor) {
        return objProfesorRepo.findById(idProfesor).orElse(null);
    }

    @Override
    public void eliminarProfesor(int id) {
        objProfesorRepo.deleteById(id);
    }

    @Override
    public void eliminarProfesor2(Profesor profesor) {
        objProfesorRepo.delete(profesor);
    }
}
