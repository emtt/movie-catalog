package mobilize.mx.moviecatalog.services.impl

import mobilize.mx.moviecatalog.models.User
import mobilize.mx.moviecatalog.repositories.UserDao
import mobilize.mx.moviecatalog.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    User save(User user) {
        return userDao.save(user)
    }

    @Override
    User findByEmail(String email) {
        return userDao.findByEmail(email)
    }
}
