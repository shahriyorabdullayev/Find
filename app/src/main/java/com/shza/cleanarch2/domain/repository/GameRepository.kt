package com.shza.cleanarch2.domain.repository

import com.shza.cleanarch2.domain.entity.GameSettings
import com.shza.cleanarch2.domain.entity.Level
import com.shza.cleanarch2.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}