package cl.awakelab.miprimerspring0057.controller;
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
    IProfesorService objprofesorService;

    @GetMapping
    public String listarProfesor(Model model){
        List<Profesor> listaProfes = objprofesorService.listarProfesor();
        model.addAttribute("atributoListarProfes", listaProfes);
        return "templateListarProfesores";
    }
    @GetMapping("/crear")
    public String CrearProfesorFormulario() {
        return "templateCrearProfesor";
    }
    @PostMapping("/crear")
    public String crearProfesor(@ModelAttribute Profesor profesor) {
        objprofesorService.crearProfesor(profesor);
        return "redirect:/profesor";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable int id){
        objprofesorService.eliminarProfesor(id);
        return "redirect:/profesor";
    }

}
