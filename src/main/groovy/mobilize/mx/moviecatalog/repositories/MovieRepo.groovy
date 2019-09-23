package mobilize.mx.moviecatalog.repositories

import mobilize.mx.moviecatalog.models.Movie
import org.springframework.data.repository.PagingAndSortingRepository

// we only need CRUD for Ability because it won't have its own endpoints
interface MovieRepo extends PagingAndSortingRepository<Movie, Long>{
}