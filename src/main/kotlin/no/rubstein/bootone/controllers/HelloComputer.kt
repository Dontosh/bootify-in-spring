package no.rubstein.bootone.controllers

import no.rubstein.bootone.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class HelloComputer(
    @Autowired private val userService: UserService
) {

    @GetMapping("/")
    fun handleHello(): String {
        return "<h1>Welcome!</h1>" +
                "<form action=\"/user\" method=\"get\">" +
                "<input name=\"userId\" type= \"text\" placeholder=\"User ID\">" +
                "<button type=\"submit\">GET</button>" +
                "</form>" +
                "<form action=\"/user\" method=\"post\">" +
                "<input name=\"body\" type= \"text\" placeholder=\"Name\">" +
                "<button type=\"submit\">POST</button>" +
                "</form>"
    }

    @GetMapping("/user")
    fun getUser(userId: String?): String {
        return when (userService.validateUserId(userId)) {
            true -> "Hello number $userId! <a href=\"/\">Back</a>"
            false -> "You did not type anything! <a href=\"/\">Back</a>"
        }
    }

    @PostMapping("/user")
    fun postUser(@RequestBody body: String?): String {
        if (body != null) {
            return when (userService.validateUserBody(body)) {
                true -> "Hello ${body.substring(body.indexOf("=") + 1)}! <a href=\"/\">Back</a>"
                false -> "You did not type anything! <a href=\"/\">Back</a>"
            }
        }
        return "Body is null"
    }
}