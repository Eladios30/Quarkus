package Api.city;

public interface TitleMapper {

    Title fromCreate(CreateTitleDto dto);

    void update(UpdateTitleDto dto, Title title);

}
