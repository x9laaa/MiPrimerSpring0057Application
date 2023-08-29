package cl.awekelab.miprimerspring0057.repository;
import cl.awekelab.miprimerspring0057.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}

