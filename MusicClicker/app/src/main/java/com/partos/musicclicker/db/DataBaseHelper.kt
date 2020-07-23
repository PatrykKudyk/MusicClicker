package com.partos.musicclicker.db


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.partos.musicclicker.models.Settings

object TableInfo : BaseColumns {
    const val DATABASE_NAME = "MusicClicker"
    const val TABLE_NAME_SETTINGS = "settings"
    const val TABLE_COLUMN_SETTINGS_MUSIC = "music"
    const val TABLE_COLUMN_SETTINGS_SOUNDS = "sounds"

}

object BasicCommand {
    const val SQL_CREATE_TABLE_SETTINGS =
        "CREATE TABLE ${TableInfo.TABLE_NAME_SETTINGS} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TableInfo.TABLE_COLUMN_SETTINGS_MUSIC} INTEGER NOT NULL," +
                "${TableInfo.TABLE_COLUMN_SETTINGS_SOUNDS} INTEGER NOT NULL)"

    const val SQL_DELETE_TABLE_SETTINGS = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME_SETTINGS}"
}

class DataBaseHelper(context: Context) :
    SQLiteOpenHelper(context, TableInfo.DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE_SETTINGS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(BasicCommand.SQL_DELETE_TABLE_SETTINGS)
        onCreate(db)
    }


    fun getSettings(): ArrayList<Settings> {
        var settingsList = ArrayList<Settings>()
        val db = readableDatabase
        val selectQuery = "Select * from ${TableInfo.TABLE_NAME_SETTINGS}"
        val result = db.rawQuery(selectQuery, null)
        if (result.moveToFirst()) {
            do {
                var mySettings = Settings(
                    result.getInt(result.getColumnIndex(BaseColumns._ID)).toLong(),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_SETTINGS_MUSIC)),
                    result.getInt(result.getColumnIndex(TableInfo.TABLE_COLUMN_SETTINGS_SOUNDS))
                )
                settingsList.add(mySettings)
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return settingsList
    }

    fun addSettings(music: Int, sounds: Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_SETTINGS_MUSIC, music)
        values.put(TableInfo.TABLE_COLUMN_SETTINGS_SOUNDS, sounds)
        db.insert(TableInfo.TABLE_NAME_SETTINGS, null, values)
        db.close()
    }

    fun updateSettings(settings: Settings) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(TableInfo.TABLE_COLUMN_SETTINGS_MUSIC, settings.music)
        values.put(TableInfo.TABLE_COLUMN_SETTINGS_SOUNDS, settings.sounds)
        db.update(
            TableInfo.TABLE_NAME_SETTINGS, values, BaseColumns._ID + "=?",
            arrayOf(settings.id.toString())
        )
        db.close()
    }

    fun deleteSettings(settingsId: Long): Boolean {
        val db = this.writableDatabase
        val success =
            db.delete(
                TableInfo.TABLE_NAME_SETTINGS,
                BaseColumns._ID + "=?",
                arrayOf(settingsId.toString())
            )
                .toLong()
        db.close()
        return Integer.parseInt("$success") != -1
    }
}