package mobilize.mx.moviecatalog.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MovieToGenre {

    @Id// Tell persistence provider 'id' is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// use RDBMS unique id generator
    Long id

    Long id_genre
    Long id_movie

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Movie)) return false

        Genre genre = (Genre) o

        if (id != genre.id) return false

        return true
    }

    int hashCode() {
        return (id != null ? id.hashCode() : 0)
    }
}
