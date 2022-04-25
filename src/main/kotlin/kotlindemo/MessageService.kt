package kotlindemo


interface MessageService {
    fun findMessages(): List<Message>
    fun post(message: Message)
}
