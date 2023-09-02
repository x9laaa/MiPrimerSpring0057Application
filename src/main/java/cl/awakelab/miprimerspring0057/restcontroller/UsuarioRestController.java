package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario);
    }
    @PutMapping
    public Usuario actualizarUsuario(int id, Usuario usuario){
        return objUsuarioService.actualizarUsuario(id,usuario);
    }
    @GetMapping
    public List<Usuario> listarUsuario(){
        return objUsuarioService.listarUsuario();
    }
    @GetMapping("/{idUsuario}")
    public Usuario listarUsuarioID(@PathVariable int idUsuario){
        return objUsuarioService.listarUsuarioID(idUsuario);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
    }
    @DeleteMapping
    public void eliminarUsuario2(@RequestBody Usuario usuario){
        objUsuarioService.eliminarUsuario2(usuario);
    }
}
