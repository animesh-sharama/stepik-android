package org.stepic.droid.storage.migration

import android.database.sqlite.SQLiteDatabase
import org.stepik.android.cache.lesson.structure.DbStructureLesson

object MigrationFrom54To55 : Migration {
    override fun migrate(db: SQLiteDatabase) {
        db.execSQL("ALTER TABLE ${DbStructureLesson.TABLE_NAME} ADD COLUMN ${DbStructureLesson.Columns.COURSES} TEXT")
    }
}