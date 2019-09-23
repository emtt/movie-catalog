package mobilize.mx.moviecatalog.controllers

import mobilize.mx.moviecatalog.models.Movie
import mobilize.mx.moviecatalog.services.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.transaction.Transactional

@RestController
@RequestMapping('movie')
@Transactional
class MovieController {

    @Autowired
    MovieService movieservice

    @GetMapping('')
    List findAll(){
        movieservice.findAll()
    }

    @GetMapping('{id}')
    Movie findOne(@PathVariable long id){
        movieservice.findById(id)
    }
/*
    @PostMapping('')
    Movies save(@RequestBody Movies m){
        movieservice.save(m)

    }
*/
    @PostMapping(path = '', consumes = "application/x-www-form-urlencoded")
    Movie saveMovie(Movie m) {
        movieservice.save(m)

    }



}
