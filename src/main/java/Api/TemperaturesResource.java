package Api;

import java.util.List;
import java.util.NoSuchElementException;

import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/temperatures")
@Transactional
public class TemperaturesResource {

    @Inject
    private TemperaturesRepository repository;
    /*
    @GET
    public List<Temperatures> index(@QueryParam("temperatureMax") Integer temperatureMax) {
        if (temperatureMax == null) {
            return repository.listAll(Sort.by("pubDate", Sort.Direction.Descending));
        } else {
            return repository.list("temperatureMax >= ?1", temperatureMax);
        }
    }
*/
    @GET
    public List<Temperatures> otherIndex(@QueryParam("title") String query) {
        if (query == null) {
            return repository.listAll(Sort.by("pubDate", Sort.Direction.Descending));
        } else {
            String filter = "%" + query + "%";
            Sort crit = Sort.by("pubDate", Sort.Direction.Ascending);
            return repository.list("title ILIKE ?1 or city ILIKE ?2", crit, filter, filter);
        }
    }

    @POST
    public Temperatures insert(Temperatures inserTemperature) {
        repository.persist(inserTemperature);
        return inserTemperature;
    }

    @GET
    @Path("{id}")
    public Temperatures retrieve(@PathParam("id") Long id) {
        var temperature = repository.findById(id);

        if (temperature != null) {
            return temperature;
        }
        throw new NoSuchElementException("No hay temperaturas con el id " + id + ".");
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        repository.deleteById(id);
    }

    @PUT
    @Path("{id}")
    public Temperatures update(@PathParam("id") Long id, Temperatures temperatures) {
        var updateTemperature = repository.findById(id);

        if (updateTemperature != null) {
            updateTemperature.setTitle(temperatures.getTitle());
            updateTemperature.setCity(temperatures.getCity());
            updateTemperature.setTemperatureMax(temperatures.getTemperatureMax());
            updateTemperature.setTemperatureMin(temperatures.getTemperatureMin());
            updateTemperature.setPubDate(temperatures.getPubDate());
            
            repository.persist(updateTemperature);

            return updateTemperature;
        }
        throw new NoSuchElementException("No hay temperaturas con el id " + id + ".");
    }
}
