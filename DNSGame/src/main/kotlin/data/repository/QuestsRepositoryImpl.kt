package data.repository

import data.api.QuestsApiImpl
import domain.Quest
import domain.QuestsRepository

object QuestsRepositoryImpl: QuestsRepository {

    override fun getRandomQuest(): Quest {
        return QuestsApiImpl.getRandomQuest()
    }

}