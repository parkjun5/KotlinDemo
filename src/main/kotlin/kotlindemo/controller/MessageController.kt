package kotlindemo.controller

import kotlindemo.model.entity.Message
import kotlindemo.service.MessageService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
class MessageController(val service: MessageService) {

//    @GetMapping
//    fun listOfMessages(): List<Message> = listOf(
//        Message("1", "hello!"),
//        Message("2", "world"),
//    )

    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message) = service.post(message)


    @DeleteMapping
    fun delete() {
        service.delete()
    }

    @RequestMapping("/samplePage1")
    fun getSample1(model: Model?): String? {
        return "inspinia/samplePage1"
    }

    @PatchMapping
    fun update(@RequestBody message: Message) {
        message.id?.let{ service.update(message) }
    }

}