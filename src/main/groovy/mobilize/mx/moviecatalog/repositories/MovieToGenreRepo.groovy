package mobilize.mx.moviecatalog.repositories

import mobilize.mx.moviecatalog.models.MovieToGenre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieToGenreRepo extends JpaRepository<MovieToGenre, Long> {

    List<MovieToGenre> findAll()

    MovieToGenre findById(long id)


}