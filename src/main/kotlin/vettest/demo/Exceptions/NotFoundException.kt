package vettest.demo.Exceptions

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}