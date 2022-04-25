package kotlindemo.service.impl

import kotlindemo.model.entity.Message
import kotlindemo.repository.MessageRepository
import kotlindemo.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl (val messageRepository: MessageRepository): MessageService {
    override fun findMessages(): List<Message> = messageRepository.findMessages()

    override fun post(message: Message) {
        messageRepository.save(message)
    }

    override fun delete() {
        messageRepository.deleteAll()
    }

    override fun update(message: Message) {
        if(message.id == null) {
            return
        }
        val foundMessage : Message = messageRepository.findById(message.id).get()
        foundMessage.text = message.text
        messageRepository.save(foundMessage)
    }
}