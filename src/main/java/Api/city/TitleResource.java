package Api.city;

import Api.PaginatedResponse;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.NoSuchElementException;

@Path("/titles")
@Transactional
public class TitleResource {

    @Inject
    private TitleRepository title;

    @GET
    public PaginatedResponse<Title> list(@QueryParam("page")
                                         @DefaultValue("1") int page,
                                         @QueryParam("q") String q) {
        var query = title.findPage(page);

        if (q != null) {
            var found = "%" + q + "%";
            query.filter("titulos.like", Parameters.with("titulos", found));
        }
        return new PaginatedResponse<>(query);
    }

    @POST
    public Response create(Title titles){
        title.persist(titles);
        return Response.created(URI.create("/titles/" + titles.getId())).entity(titles).build();
    }

    @GET
    @Path("{id}")
    public Title get (@PathParam("id") Long id){
        return title.findByIdOptional(id)
                    .orElseThrow(() -> new NoSuchElementException("Title " + id + " not found"));
    }

    @PUT
    @Path("{id}")
    public Title update (@PathParam("id") Long id, Title title2){
        Title found = title.findByIdOptional(id)
                .orElseThrow(() -> new NoSuchElementException("Title " + id + " not found"));

        found.setTitulos(title2.getTitulos());

        title.persist(found);

        return found;
    }

    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") Long id){
        title.deleteById(id);
    }

}