package mobilize.mx.moviecatalog.models

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import javax.persistence.OneToMany

@Entity // Tell persistence provider 'Movies' is a persistence entity
class Movie {

    @Id// Tell persistence provider 'id' is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// use RDBMS unique id generator
    Long id

    String nombre
    String fecha
    String pais

    /*@OneToMany(mappedBy = "movie")
    List<Genre> genreList*/



    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Movie)) return false

        Movie movie = (Movie) o

        if (id != movie.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}
