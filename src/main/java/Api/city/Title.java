package Api.city;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@FilterDef(name = "titulos.like", parameters = @ParamDef(name = "titulos", type = String.class))
@Filter(name = "titulos.like", condition = "LOWER(titulos) LIKE LOWER(:titulos)")
public class Title {

    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("titulitos")
    @JsonAlias({"titulos", "titulitos"})
    private String titulos;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime createAt;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(id, title.id) && Objects.equals(titulos, title.titulos) && Objects.equals(createAt, title.createAt) && Objects.equals(updateAt, title.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulos, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", titulos='" + titulos + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

}
