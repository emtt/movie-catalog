package mobilize.mx.moviecatalog.services

import mobilize.mx.moviecatalog.models.User

interface UserService {
    User save(User user)

    User findByEmail(String email)
}
