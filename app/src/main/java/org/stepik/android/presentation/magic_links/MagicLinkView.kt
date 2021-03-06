package org.stepik.android.presentation.magic_links

interface MagicLinkView {
    sealed class State {
        object Idle : State()
        object Loading : State()
        class Success(val url: String) : State()
    }

    fun setState(state: State)
}