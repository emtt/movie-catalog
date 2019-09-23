package mobilize.mx.moviecatalog.controllers

import mobilize.mx.moviecatalog.models.User
import mobilize.mx.moviecatalog.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod

@RestController
@RequestMapping("/secure")
class SecureController {

    @Autowired
    UserService userService

    @RequestMapping("/user/users")
     String loginSuccess() {
        return "Login Successful!"
    }

    @RequestMapping(value = "/user/email", method = RequestMethod.POST)
     User findByEmail(@RequestBody String email) {
        return userService.findByEmail(email)
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
     User updateUser(@RequestBody User user) {
        return userService.save(user)
    }

}
