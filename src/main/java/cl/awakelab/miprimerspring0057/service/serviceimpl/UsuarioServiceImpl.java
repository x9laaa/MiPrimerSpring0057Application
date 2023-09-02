package cl.awakelab.miprimerspring0057.service.serviceimpl;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.repository.IUsuarioRepository;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Override
    public Usuario crearUsuario(Usuario nuevoUsuario) {
        return objUsuarioRepo.save(nuevoUsuario);
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario usuarioActulizar = objUsuarioRepo.findById(id).orElse(null);
        usuarioActulizar.setNombreUsuario(usuario.getNombreUsuario());
        usuarioActulizar.setContrasena(usuario.getContrasena());
        usuarioActulizar.setRol(usuario.getRol());
        return objUsuarioRepo.save(usuarioActulizar);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return objUsuarioRepo.findAll();
    }
    @Override
    public Usuario listarUsuarioID(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElse(null);
    }

    @Override
    public void eliminarUsuario(int id) {
        objUsuarioRepo.deleteById(id);
    }
    @Override
    public void eliminarUsuario2(Usuario usuario) {
        objUsuarioRepo.delete(usuario);
    }
}
