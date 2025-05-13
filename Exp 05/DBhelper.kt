package com.example.exp_5322

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context):SQLiteOpenHelper(context,"android", null,1){

    private val db = "android.db"
    private val table = "student"
    private val col1 = "regno"
    private val col2 = "name"
    private val col3 = "cgpa"
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $table (
                $col1 INTEGER PRIMARY KEY AUTOINCREMENT, 
                $col2 TEXT, 
                $col3 REAL
            )
        """.trimIndent()
        if (db != null) {
            db.execSQL(createTable)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS $table")
        }
        onCreate(db)
    }

    fun insert(regno:Int,name:String,cgpa:Float):Boolean{
        val db = writableDatabase
        val values=ContentValues().apply{
            put(col1,regno)
            put(col2,name)
            put(col3,cgpa)
        }
        val result=db.insert(table,null,values)
        return result!=-1L
    }
    fun update(regno:Int,name:String,cgpa:Float):Boolean{
        val db = writableDatabase
        val values=ContentValues().apply{
            put(col2,name)
            put(col3,cgpa)
        }
        val result=db.update(table,values,"$col1=?", arrayOf(regno.toString()))
        return result>0
    }
    fun delete(regno:Int):Boolean{
        val db=writableDatabase
        val result=db.delete(table,"$col1=?", arrayOf(regno.toString()))
        return result>0
    }
    fun select(regno: Int):Cursor{
        val db=readableDatabase
        return db.rawQuery("select * from student where $col1=?", arrayOf(regno.toString()))
    }
}