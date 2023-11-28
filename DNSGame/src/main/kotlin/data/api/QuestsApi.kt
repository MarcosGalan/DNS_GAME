package data.api

import domain.Quest

interface QuestsApi {

    fun getRandomQuest():Quest

}