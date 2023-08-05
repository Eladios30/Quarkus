package Api.city;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TitleMapperImp implements TitleMapper {

    @Override
    public Title fromCreate(CreateTitleDto dto) {
        var t = new Title();
        t.setTitulos(dto.title());
        return t;
    }

    @Override
    public void update(UpdateTitleDto dto, Title title) {
        title.setTitulos(dto.title());
    }
}
