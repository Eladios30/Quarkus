package Api;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TemperaturesRepository implements PanacheRepository<Temperatures> {
    
}
