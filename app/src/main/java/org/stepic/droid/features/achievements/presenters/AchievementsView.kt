package org.stepic.droid.features.achievements.presenters

import org.stepic.droid.model.achievements.AchievementFlatItem

interface AchievementsView {
    fun showAchievements(achievements: List<AchievementFlatItem>)
    fun onLoadingError()
    fun onLoading()

    sealed class State {
        object Idle: State()
        object Loading: State()
        class AchievementsLoaded(val achievements: List<AchievementFlatItem>): State()
        object Error: State()
    }
}