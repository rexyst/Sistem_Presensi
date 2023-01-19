package com.rexqueen.sistempresensi

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DBHelper.DB_NAME, null, DBHelper.DB_VERSION)  {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE_USER = "CREATE TABLE $TABLE_USER (" +
                ID_USER + " INTEGER PRIMARY KEY," +
                NAMA_USER + " TEXT," +
                PASSWORD_USER + " TEXT," +
                ROLE_USER + " INTEGER," +
                CLASS_USER + " INTEGER," +
                STATUS_USER + " INTEGER);"

        val CREATE_TABLE_ROLE = "CREATE TABLE $TABLE_ROLE (" +
                ID_ROLE + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ROLE + " TEXT);"

        val CREATE_TABLE_CLASS = "CREATE TABLE $TABLE_CLASS (" +
                ID_CLASS + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CLASS + " TEXT);"

        val CREATE_TABLE_PRESENSI = "CREATE TABLE $TABLE_PRESENSI (" +
                ID_PRES + " INTEGER PRIMARY KEY," +
                DATE_PRES + " DATE," +
                CLOCK_PRES + " TEXT," +
                OUT_PRES + " TEXT," +
                USER_PRES + " INTEGER," +
                STATUS_PRES + " INTEGER);"

        db.execSQL(CREATE_TABLE_USER)
        db.execSQL(CREATE_TABLE_ROLE)
        db.execSQL(CREATE_TABLE_CLASS)
        db.execSQL(CREATE_TABLE_PRESENSI)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val DROP_TABLE_USER = "DROP TABLE IF EXISTS " + TABLE_USER
        val DROP_TABLE_ROLE = "DROP TABLE IF EXISTS " + TABLE_ROLE
        val DROP_TABLE_CLASS = "DROP TABLE IF EXISTS " + TABLE_CLASS
        val DROP_TABLE_PRESENSI = "DROP TABLE IF EXISTS " + TABLE_PRESENSI
        db.execSQL(DROP_TABLE_USER)
        db.execSQL(DROP_TABLE_ROLE)
        db.execSQL(DROP_TABLE_CLASS)
        db.execSQL(DROP_TABLE_PRESENSI)
        onCreate(db)
    }

    fun addUser(datas: User): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID_USER, datas.id)
        values.put(ID_USER, datas.id)
        values.put(ID_USER, datas.id)
        values.put(ID_USER, datas.id)
        values.put(ID_USER, datas.id)
        values.put(ID_USER, datas.id)
        val _success = db.insert(TABLE_USER, null, values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    companion object {

//        db identifier
        private val DB_VERSION = 1
        private val DB_NAME = "presensi"

//        table user
        private val TABLE_USER = "Users"
        private val ID_USER = "Id"
        private val NAMA_USER = "Nama"
        private val PASSWORD_USER = "Password"
        private val ROLE_USER = "Role"
        private val CLASS_USER = "Kelas"
        private val STATUS_USER = "Status"

//        table role
        private val TABLE_ROLE = "Role"
        private val ID_ROLE = "Id"
        private val ROLE = "Role"

//        table kelas
        private val TABLE_CLASS = "Kelas"
        private val ID_CLASS = "Id"
        private val CLASS = "Kelas"

//        table Presensi
        private val TABLE_PRESENSI = "Presensi"
        private val ID_PRES = "Id"
        private val DATE_PRES = "Tanggal"
        private val CLOCK_PRES = "Jam"
        private val OUT_PRES = "Jam_Keluar"
        private val USER_PRES = "User"
        private val STATUS_PRES = "Status"
    }
}