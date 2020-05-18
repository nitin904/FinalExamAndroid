package org.finalexam.final_patel_991489983

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBOpenHelper(
    context: Context?,

    factory: SQLiteDatabase.CursorFactory?

) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

            val CREATE_PRODUCT_TABLE = ("CREATE TABLE " +
                    TABLE_NAME + "("
                    + COLUMN_ID + "INTEGER PRIMARY KEY," +
                    COLUMN_NAME1 + " TEXT," +
                    COLUMN_NAME2 + " Text," +
                    COLUMN_NAME3 + " Text" +")")
            db?.execSQL(CREATE_PRODUCT_TABLE)
        }



    companion object {
        private val version = 1
        private val name = "MyName.db"
        val TABLE_NAME = "products"
        val COLUMN_ID = "_id"
        val COLUMN_NAME1 = "prodname"
        val COLUMN_NAME2 = "price"
        val COLUMN_NAME3 = "description"
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // Insert product
    fun addProduct(name: Product):Long {
        val values = ContentValues()
        values.put(COLUMN_NAME1, name.prodName)
        values.put(COLUMN_NAME2, name.price)
        values.put(COLUMN_NAME3, name.description)
        val db = this.writableDatabase
        val status = db.insert(TABLE_NAME, null, values)
        getAllProducts()
        return status
        //db.close()

    }



    // get all products
   fun getAllProducts(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }



}
