package com.shza.cleanarch2.domain.use_case

import com.shza.cleanarch2.domain.entity.Question
import com.shza.cleanarch2.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository,
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}