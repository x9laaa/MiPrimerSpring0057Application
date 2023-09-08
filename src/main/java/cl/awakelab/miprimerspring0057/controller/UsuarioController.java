package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Usuario;
import cl.awakelab.miprimerspring0057.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuario();
        model.addAttribute("atributoListaUsuarios", listaUsuarios);
        return "templateListarUsarios";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearUsuario(){
        return "templateFormularioCrearUsuario";
    }
    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/eliminar/{id}")
    public String crearUsuario(@PathVariable int id){
        objUsuarioService.eliminarUsuario(id);
        return "redirect:/usuario";
    }


}
