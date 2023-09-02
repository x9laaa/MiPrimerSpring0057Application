package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.entity.Curso;
import cl.awakelab.miprimerspring0057.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoRestController {
    @Autowired
    ICursoService objCursoService;

    @PostMapping
    public Curso crearCurso(@RequestBody Curso nuevoCurso){
        return objCursoService.crearCurso(nuevoCurso);
    }
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso){
        return objCursoService.actualizarCurso(id,curso);
    }

    @GetMapping
    public List<Curso> listarCurso(){
        return objCursoService.listarCurso();
    }
    @GetMapping("/{idCurso}")
    public Curso listarCursoID(@PathVariable int idCurso){
        return objCursoService.listarCursoID(idCurso);
    }
    @GetMapping("/lista/{id}")
    public List<Alumno> listarAlumnosCurso(@PathVariable int id){
        return objCursoService.listarAlumnosCurso(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable int id){
        objCursoService.eliminarCurso(id);
    }
    @DeleteMapping
    public void eliminarCurso2(@RequestBody Curso curso){
        objCursoService.eliminarCurso2(curso);
    }



}
