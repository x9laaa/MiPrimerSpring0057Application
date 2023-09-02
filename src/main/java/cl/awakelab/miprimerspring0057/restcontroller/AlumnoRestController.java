package cl.awakelab.miprimerspring0057.restcontroller;

import cl.awakelab.miprimerspring0057.entity.Alumno;
import cl.awakelab.miprimerspring0057.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {
    @Autowired
    IAlumnoService objAlumnoService;
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno Alumno){
        return objAlumnoService.crearAlumno(Alumno);
    }
    @GetMapping
    public List<Alumno> listarAlumno(){
        return objAlumnoService.listarAlumnos();
    }
    @GetMapping("/{idAlumno}")
    public Alumno listarAlumnosID(@PathVariable int idAlumno){
        return objAlumnoService.listarAlumnosID(idAlumno);
    }
    @PutMapping
    public Alumno actualizarAlumno(@PathVariable int id,@RequestBody Alumno alumno){
        return objAlumnoService.actualizarAlumno(id,alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable int id){
        objAlumnoService.eliminarAlumno(id);
    }

    @DeleteMapping
    public void eliminarAlumno2(@RequestBody Alumno alumno){
        objAlumnoService.eliminarAlumno2(alumno);
    }

}
