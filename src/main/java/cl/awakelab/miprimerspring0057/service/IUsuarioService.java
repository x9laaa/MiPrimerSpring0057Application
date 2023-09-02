package cl.awakelab.miprimerspring0057.service;
import cl.awakelab.miprimerspring0057.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public Usuario crearUsuario(Usuario nuevoUsuario);
    public Usuario actualizarUsuario(int id, Usuario usuario);
    public List<Usuario> listarUsuario();
    public Usuario listarUsuarioID(int idUsuario);
    public void eliminarUsuario(int id);
    public void eliminarUsuario2(Usuario usuario);
}
