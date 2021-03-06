package org.stepik.android.domain.calendar.repository

import io.reactivex.Completable
import io.reactivex.Single
import org.stepik.android.domain.calendar.model.CalendarEventData
import org.stepik.android.domain.calendar.model.CalendarItem

interface CalendarRepository {
    fun saveCalendarEventData(calendarEventData: CalendarEventData, calendarItem: CalendarItem): Single<Long>
    fun getCalendarItems(): Single<List<CalendarItem>>
    fun removeCalendarEventDataByIds(vararg ids: Long): Completable
}