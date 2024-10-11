package vettest.demo.Enums

enum class Errors (val code: String, val message: String) {
    AnEr404(code = "AnEr404", message = "Animal [%s] not exists"),
    ClEr404(code = "ClEr404", message = "Client [%s] not exists")
}
