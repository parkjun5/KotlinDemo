package kotlindemo.service

import kotlindemo.model.entity.Message


interface MessageService {
    fun findMessages(): List<Message>
    fun post(message: Message)
    fun delete()
    fun update(message: Message)
}
