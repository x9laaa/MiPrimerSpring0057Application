package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    ICursoService objCursoService;

    @GetMapping
    public String listarCursos(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCursos);
        return "templateListarCursos";
    }
    @GetMapping("/crear")
    public String mostrarFormularioCrearCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "templateCrearCurso";
    }
    @PostMapping("/crear")
    public String crearCurso(@ModelAttribute Curso curso) {
        objCursoService.crearCurso(curso);
        return "redirect:/cursos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
        return "redirect:/cursos";
    }

}
