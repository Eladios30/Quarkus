package Api;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Temperatures {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String city;

    private int temperatureMax;

    private int temperatureMin;

    @CreationTimestamp
    private LocalDate pubDate;

    @UpdateTimestamp
    private LocalDate actDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(int temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public int getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(int temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public LocalDate getActDate() {
        return actDate;
    }

    public void setActDate(LocalDate actDate) {
        this.actDate = actDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + temperatureMax;
        result = prime * result + temperatureMin;
        result = prime * result + ((pubDate == null) ? 0 : pubDate.hashCode());
        result = prime * result + ((actDate == null) ? 0 : actDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Temperatures other = (Temperatures) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (temperatureMax != other.temperatureMax)
            return false;
        if (temperatureMin != other.temperatureMin)
            return false;
        if (pubDate == null) {
            if (other.pubDate != null)
                return false;
        } else if (!pubDate.equals(other.pubDate))
            return false;
        if (actDate == null) {
            if (other.actDate != null)
                return false;
        } else if (!actDate.equals(other.actDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Temperatures [title=" + title + ", city=" + city + ", temperatureMax=" + temperatureMax
                + ", temperatureMin=" + temperatureMin + ", pubDate=" + pubDate + ", actDate=" + actDate + "]";
    }
    
}
