package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    IAlumnoService objAlumnoService;
    @Autowired
    ICursoService objCursoService;
    @GetMapping
    public String listarAlumnos(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumnos();
        model.addAttribute("atributoListarAlumnos", listaAlumnos);
        return "templateListarAlumnos";
    }
    @GetMapping( "/crear")
    public String mostrarFormularioCrearAlumno(Model model){
        List<Curso> listaCurso=objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCurso);
        return "templateCrearAlumno";
    }

    @PostMapping("/crear")
    public String crearAlumno(@ModelAttribute Alumno alumno){
        objAlumnoService.crearAlumno(alumno);
        return "redirect:/alumno";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
        return "redirect:/alumno";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCliente(@PathVariable int id, Model model){
        List<Curso> listaCurso=objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCurso);
        Alumno alumno = objAlumnoService.listarAlumnosID(id);
        model.addAttribute("attributeAlumno",alumno);
        return "templateEditarAlumno";
    }

    @PostMapping("/editar")
    public String editarCliente(@ModelAttribute Alumno alumno){
        objAlumnoService.actualizarAlumno(alumno.getId(), alumno);
        return "redirect:/alumno";
    }
}
