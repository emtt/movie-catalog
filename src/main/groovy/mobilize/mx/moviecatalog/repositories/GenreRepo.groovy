package mobilize.mx.moviecatalog.repositories

import mobilize.mx.moviecatalog.models.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface GenreRepo extends JpaRepository<Genre, Long>{

    @Query("Select g from Genre g  where g.name = ?1")//The fuckin' error was the name of Table it is in Upper grrrrrr!
    Genre getByName(String name)

}
