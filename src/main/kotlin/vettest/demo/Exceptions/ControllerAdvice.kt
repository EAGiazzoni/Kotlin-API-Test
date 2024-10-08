package vettest.demo.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import vettest.demo.Response.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            httpCode = 400,
            message = "Objeto não localizado",
            internalCode = 1,
            errors = null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }
}