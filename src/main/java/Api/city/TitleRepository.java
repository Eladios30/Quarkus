package Api.city;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TitleRepository implements PanacheRepository<Title> {


    public PanacheQuery<Title> findPage(int page) {
        Page pag = new Page(page - 1, 5);

        var query = findAll(Sort.descending("createAt"));

        query.page(pag);

        return query;
    }
}
