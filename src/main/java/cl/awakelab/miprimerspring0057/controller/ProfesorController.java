package cl.awakelab.miprimerspring0057.controller;
import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    IProfesorService objProfesorService;

    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor> listaProfes = objProfesorService.listarProfesor();
        model.addAttribute("atributoListarProfes", listaProfes);
        return "templateListarProfesores";
    }
    @GetMapping("/crear")
    public String CrearProfesorFormulario() {
        return "templateCrearProfesor";
    }
    @PostMapping("/crear")
    public String crearProfesor(@ModelAttribute Profesor profesor) {
        objProfesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objProfesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }
    @GetMapping("/editar/{id}")
    public String formularioEditarProfesor(@PathVariable int id, Model model){
        Profesor profesor=objProfesorService.listarProfesorID(id);
        model.addAttribute("atributoProfesor", profesor);

        return "templateEditarProfesor";
    }
    @PostMapping("/editar")
    public String editarProfesor(@ModelAttribute Profesor profesor){
        objProfesorService.actualizarProfesor(profesor.getId(), profesor);
        return "redirect:/profesor";
    }

}
