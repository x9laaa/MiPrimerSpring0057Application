package cl.awakelab.miprimerspring0057.service;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import java.util.List;

public interface IProfesorService {
    public Profesor crearProfesor(Profesor nuevoProfesor);
    public Profesor actualizarProfesor(int id);
    public List<Profesor> listarProfesor();
    public Profesor listarProfesorID(int idProfesor);
    public void eliminarProfesor(int id);
}
