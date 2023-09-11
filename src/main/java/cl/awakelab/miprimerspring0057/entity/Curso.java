package cl.awakelab.miprimerspring0057.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String nombreCurso;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Curso_profesor",
            joinColumns = @JoinColumn(name = "FK_Curso", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "FK_Profesor", nullable = false))
    private List<Profesor> listaProfesores = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cursoAsignado")
    private List<Alumno> listaAlumnos;

}
