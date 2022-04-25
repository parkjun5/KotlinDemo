package kotlindemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinDemoApplication

fun main(args: Array<String>) {
    runApplication<KotlinDemoApplication>(*args)
}

@RestController
class MessageResource(val service: MessageService) {
//    @GetMapping
//    fun index(): List<Message> = listOf(
//        Message("1", "hello!"),
//        Message("2", "world"),
//    )

    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message) {
        service.post(message)
    }

}

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)