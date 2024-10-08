package vettest.demo.Response

data class ErrorResponse (
    var httpCode: Int,
    var message: String,
    var internalCode: Int,
    var errors: List<FieldErrorResponse>?
)