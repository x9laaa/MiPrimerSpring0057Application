package cl.awakelab.miprimerspring0057.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, length = 75)
    private String nombreUsuario;

    @Column(nullable = false, length = 30)
    private String contrasena;

    @Column(nullable = false, length = 30)
    private String rol;
}
