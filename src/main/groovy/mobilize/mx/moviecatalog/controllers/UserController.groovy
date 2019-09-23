package mobilize.mx.moviecatalog.controllers

import antlr.Token
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import mobilize.mx.moviecatalog.models.User
import mobilize.mx.moviecatalog.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.servlet.ServletException

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserService userService

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    User registerUser(@RequestBody User user) {
        return userService.save(user)
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ResponseEntity login(@RequestBody User login) throws ServletException {
        //String login(@RequestBody User login) throws ServletException {

        String jwtToken = ""
        /*if (login == null) {
            def response = [:]
            response.put("Date", new Date())
            response.put("message", ex.getMessage())
            response.put("details", request.getDescription(false))
            ResponseEntity responseEntity = ResponseEntity.badRequest()
                    .header("Custom-Header", "foo")
                    .body(response)
            return responseEntity
        }
*/

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail()
        String password = login.getPassword()

        User user = userService.findByEmail(email)

        if (user == null) {
            throw new ServletException("User email not found.")
        }

        String pwd = user.getPassword()

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.")
        }


        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact()

        //Beauty...
        def map = [:]
        map.put("Token", jwtToken)
        map.put("user", user)

        return new ResponseEntity<String>(map, HttpStatus.OK)
    }
}
