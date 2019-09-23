package mobilize.mx.moviecatalog.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
@RestController
class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleAllExceptions(Exception ex, WebRequest request) {
        /*ResponseException responseException = new ResponseException()
        responseException.timestamp = new Date()
        responseException.message = ex.getMessage()
        responseException.details = request.getDescription(false)*/

        def response = [:]
        response.put("Date", new Date())
        response.put("message", ex.getMessage())
        response.put("details", request.getDescription(false))

        ResponseEntity responseEntity =  ResponseEntity.badRequest()
                .header("Custom-Header", "foo")
                .body(response)
        return responseEntity

    }
}