package org.stepik.android.presentation.course

import org.stepik.android.domain.course.model.CourseHeaderData

interface CourseView {
    sealed class State {
        object NetworkError : State()
        object EmptyCourse : State()
        object Loading : State()
        object Idle : State()

        class CourseLoaded(val courseHeaderData: CourseHeaderData) : State()
    }

    fun setState(state: State)

    fun showEnrollmentError()
}
