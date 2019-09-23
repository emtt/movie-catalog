package mobilize.mx.moviecatalog.models

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Genre {

    @Id// Tell persistence provider 'id' is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// use RDBMS unique id generator
    Long id

    String name
    String image

   /* @ManyToOne(fetch =FetchType.LAZY)
    //@JoinColumn(name="MOVIE_ID")//Optional
    Movie movie
*/

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
