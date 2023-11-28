package domain

import data.repository.QuestsRepositoryImpl

class QuestsManager() {

    fun getRandomQuest(): Quest{
        return QuestsRepositoryImpl.getRandomQuest()
    }

}