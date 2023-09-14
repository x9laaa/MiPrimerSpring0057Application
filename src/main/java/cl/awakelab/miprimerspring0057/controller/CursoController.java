package cl.awakelab.miprimerspring0057.controller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.entity.Profesor;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import cl.awakelab.miprimerspring0057.service.IProfesorService;
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

    @Autowired
    IProfesorService objProfesorService;


    @Autowired
    IAlumnoService objAlumnoService;

    @GetMapping
    public String listarCursos(Model model){
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCursos);
        return "templateListarCursos";
    }
    @GetMapping("/crear")
    public String mostrarFormularioCrearCurso() {
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

    @GetMapping("/asignarProfe")
    public String mostrarFormularioAsignarProfesor(Model model){
        List<Profesor> listaProfes = objProfesorService.listarProfesor();
        model.addAttribute("atributoListaProfes", listaProfes);
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCursos);
        return "templateAsignarProfe";
    }
    @PostMapping("/asignarProfe")
    public String asiganarProfesor(@RequestParam int idCurso,@RequestParam int idProfesor) {
        System.out.println("id Curso: "+idCurso);
        System.out.println("id Profe: "+idProfesor);
        objCursoService.asignarProfesor(idCurso, idProfesor);
        return "redirect:/cursos";
    }

    @GetMapping("/asignarAlumno")
    public String mostrarFormularioAsignarAlumno(Model model){
        List<Alumno> listaAlumnos = objAlumnoService.listarAlumnos();
        model.addAttribute("atributoListaAlumnos", listaAlumnos);
        List<Curso> listaCursos = objCursoService.listarCurso();
        model.addAttribute("atributoListarCursos", listaCursos);
        return "templateAsignarAlumno";
    }

    @PostMapping("/asignarAlumno")
    public String asiganarAlumno(@RequestParam int idCurso,@RequestParam int idAlumno) {
        objCursoService.asignarAlumno(idCurso,idAlumno);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCurso(@PathVariable int id, Model model){

        Curso curso = objCursoService.listarCursoID(id);
        model.addAttribute("attributeCurso",curso);
        return "templateEditarCurso";
    }

    @PostMapping("/editar")
    public String editarCurso(@ModelAttribute Curso curso){
        objCursoService.actualizarCurso(curso.getId(), curso);
        return "redirect:/cursos";
    }



}
