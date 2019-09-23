package mobilize.mx.moviecatalog.services

import mobilize.mx.moviecatalog.models.Genre
import mobilize.mx.moviecatalog.repositories.GenreRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Service

import javax.persistence.EntityNotFoundException

@Service
class GenreService {
    @Autowired
    GenreRepo genreRepo


    List<Genre> listAll(){
        genreRepo.findAll(Sort.by('name')).asList()
    }

    Genre findById(Long id) {
        genreRepo.findById(id).orElse(null)
    }

    Genre findByIdOrError(long id){
        genreRepo.findById(id).orElseThrow({
            new EntityNotFoundException()
        })
    }

    Genre save(Genre g){
        genreRepo.save(g)
    }

    Genre deleteById(long id){
        def genre = findById(id)
        genreRepo.delete(genre)
        genre
    }

    Genre getByName(String name){
        genreRepo.getByName(name)

    }

    //Genre getGenreName(String name){}
/*
    Genre update(Genre g, long id) {
        Genre persisted = findByIdOrError(id)
        persisted.with {
            name = g.name
            image = g.image
        }
        *//*
        def toBeRemoved = []
        // find values to update & delete
        persisted.abilities.each {
            def a = hero.abilities.find { it2 -> it2.id == it.id }
            if (a == null) toBeRemoved.add(it)
            else it.name = a.name
        }
        persisted.abilities.removeAll(toBeRemoved)
        // assign persisted entity as the hero
        hero.abilities.each {
            if (it.id == null) {
                it.hero = persisted
                persisted.abilities.add(it)
            }
        }
        *//*
        genreRepo.save(persisted)
        //heroRepository.save(persisted)
    }*/

}
