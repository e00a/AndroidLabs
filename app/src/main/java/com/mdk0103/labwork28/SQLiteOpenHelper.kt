package com.mdk0103.labwork28

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "usersdb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "userData"
        private const val ID_COL = "id"
        private const val LOGIN_COL = "login"
        private const val PASSWORD_COL = "password"
        private const val AGE_COL = "age"
    }
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LOGIN_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + AGE_COL + " INT)")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addNewUser(user: User?) {
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(LOGIN_COL, user?.login)
        values.put(PASSWORD_COL, user?.password)
        values.put(AGE_COL, user?.age)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readUsers(): ArrayList<User>? {
        val db = this.readableDatabase
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        val courseModelArrayList: ArrayList<User> = ArrayList()

        if (cursorCourses.moveToFirst()) {
            do {
                courseModelArrayList.add(
                    User(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getInt(3),
                    )
                )
            } while (cursorCourses.moveToNext())
        }
        cursorCourses.close()
        return courseModelArrayList
    }

    fun editUser(login : String?, password : String?, age : Int?) {
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(PASSWORD_COL, password)
            put(AGE_COL, age)
        }

        val selection = "${LOGIN_COL} LIKE ?"
        val selectionArgs = arrayOf(login)
        val count = db.update(
            TABLE_NAME,
            values,
            selection,
            selectionArgs)
        db.close()
    }

    fun deleteUser(login : String?) {
        val selection = "${LOGIN_COL} LIKE ?"
        val selectionArgs = arrayOf(login)
        val db = this.writableDatabase
        val deletedRows = db.delete(TABLE_NAME, selection, selectionArgs)
        db.close()
    }
}