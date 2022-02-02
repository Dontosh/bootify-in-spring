package no.rubstein.bootone.service

import org.springframework.stereotype.Service

@Service
class UserService {

    fun validateUserId(userId: String?): Boolean {
        userId?.let {
            val num = it.toIntOrNull()
            if (num != null) {
                return true
            }
            if (it.isEmpty()) return false
            return false
        }
        return false
    }

    fun validateUserBody(body: String?): Boolean {
        body?.let {
            if (it.trim() != "body=") return true
        }
        return false
    }
}