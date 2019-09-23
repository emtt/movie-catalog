package mobilize.mx.moviecatalog.controllers

import com.oracle.tools.packager.Log
import mobilize.mx.moviecatalog.models.Genre
import mobilize.mx.moviecatalog.services.GenreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.Query
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.transaction.Transactional

@RestController
@RequestMapping('genre')
@Transactional
class GenreController {

    @Autowired
    GenreService genreService

    /**
     * By GET ('genre/')return
     * @return List<Genre>
     */
    @GetMapping('')
    List findAll() {
        genreService.listAll()
    }

    @GetMapping('{id}')
    Genre findById(@PathVariable Long id) {
        genreService.findById(id)
    }

    /*@PostMapping('')
    Genre save(@RequestBody Genre g){
        genreService.save(g)
    }*/

    @PostMapping(path = '', consumes = "application/x-www-form-urlencoded")
    Genre saveGenre(Genre g) {
        genreService.save(g)
    }

    @GetMapping("show/{name}")
    Genre getByName(@PathVariable String name) {
        Log.debug("Param Name: "+ name)
        genreService.getByName(name)
    }


}
