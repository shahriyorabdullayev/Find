package com.shza.cleanarch2.domain.use_case

import com.shza.cleanarch2.domain.entity.GameSettings
import com.shza.cleanarch2.domain.entity.Level
import com.shza.cleanarch2.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}