package com.shza.cleanarch2.data

import com.shza.cleanarch2.domain.entity.GameSettings
import com.shza.cleanarch2.domain.entity.Level
import com.shza.cleanarch2.domain.entity.Question
import com.shza.cleanarch2.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl: GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1
    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())

    }

    override fun getGameSettings(level: Level): GameSettings {
        return when(level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    5,
                    50,
                    6
                )
            }

            Level.EASY -> {
                GameSettings(
                    20,
                    10,
                    70,
                    40
                )
            }

            Level.NORMAL -> {
                GameSettings(
                    50,
                    10,
                    80,
                    30
                )
            }

            Level.HARD -> {
                GameSettings(
                    80,
                    20,
                    90,
                    20
                )
            }
        }
    }
}