package mobilize.mx.moviecatalog.repositories

import mobilize.mx.moviecatalog.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserDao extends CrudRepository<User, Long>{

    User save(User u);

    User findByEmail(String email)
}
