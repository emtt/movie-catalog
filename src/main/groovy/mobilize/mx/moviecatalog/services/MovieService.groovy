package mobilize.mx.moviecatalog.services

import mobilize.mx.moviecatalog.models.Movie
import mobilize.mx.moviecatalog.repositories.MovieRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException

/*
Every class with @Service annotation will be a Spring Bean, usually Services will be injected into other Services or
 Controllers. In the codes above every Service is injected with Repository.
  You can do this by adding @Autowired to a class property. Spring will search its registered Beans and inject
  the appropriate one. By using this kind of design, you don’t need to worry about instantiation,
   you just have to believe that it will be there when you need it and concentrate on writing your own code.
 */

@Service
class MovieService {
    @Autowired
    MovieRepo movierepo

    List findAll() {
        movierepo.findAll(Sort.by('nombre')).asList()
    }

    Movie findById(long id) {
        movierepo.findById(id).orElse(null)
    }

    Movie findByIdOrError(long id) {
        heroRepository.findById(id).orElseThrow({
            new EntityNotFoundException()
        })
    }

    Movie save(Movie movie) {
        // assign hero to every abilities
        //movie.abilities?.each { it.hero = hero }
        movierepo.save(movie)
    }

    Movie deleteById(long id) {
        def movies = findByIdOrError(id)
        movierepo.delete(movies)
        movies
    }
}
