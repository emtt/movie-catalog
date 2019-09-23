package mobilize.mx.moviecatalog.services

import mobilize.mx.moviecatalog.models.Genre
import mobilize.mx.moviecatalog.models.Movie
import mobilize.mx.moviecatalog.models.MovieToGenre
import mobilize.mx.moviecatalog.repositories.GenreRepo
import mobilize.mx.moviecatalog.repositories.MovieToGenreRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException

@Service
class MovieToGenreService {

    @Autowired
    MovieToGenreRepo movieToGenreRepo

    @Autowired
    GenreRepo genreRepo

    MovieToGenre findById(long id) {
        movieToGenreRepo.findById(id).orElse(null)
    }

    MovieToGenre findByIdOrError(long id) {
        movieToGenreRepo.findById(id).orElseThrow({
            new EntityNotFoundException()
        })
    }


    MovieToGenre save(MovieToGenre movieToGenre) {
        movieToGenreRepo.save(movieToGenre)
    }

    MovieToGenre deleteById(long id) {
        def movieTogenre = findByIdOrError(id)
        movieToGenreRepo.delete(movieTogenre)
        movieTogenre
    }


    MovieToGenre findByIdMovieOrError(long id) {
        movieToGenreRepo.a.orElseThrow({
            new EntityNotFoundException()
        })
    }


    @Query("Select g from genre g where g.name = ?1")
    Genre getGenreName(String name) {}
}
