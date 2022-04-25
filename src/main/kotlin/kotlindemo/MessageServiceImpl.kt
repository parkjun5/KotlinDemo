package kotlindemo

import org.springframework.stereotype.Service

@Service
class MessageServiceImpl (val db: MessageRepository): MessageService{
    override fun findMessages(): List<Message> = db.findMessages()

    override fun post(message: Message) {
        db.save(message)
    }
}