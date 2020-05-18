package org.finalexam.final_patel_991489983

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        etList.setText("")

        val dbHandler = MyDBOpenHelper(this, null)

        val cursor = dbHandler.getAllProducts()

        if (cursor == null) {
            Toast.makeText(this, "product not Found", Toast.LENGTH_LONG).show()
        }
        else {
            cursor!!.moveToFirst()
            etList.append("Displaying Data from the Database:..")
            etList.append(" ")
            etList.append(
                (cursor.getString(
                    cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                )))

            etList.append(" | ")

            etList.append(
                (cursor.getString(
                            cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                        )))
            etList.append(" | ")


            etList.append(
                (cursor.getString(
                            cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME3)
                        )))

            etList.append("\n")



            while (cursor.moveToNext()) {
                etList.append(
                    (cursor.getString(
                        cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME1)
                    )))
                etList.append(" | ")

                etList.append(
                    (
                            cursor.getString(
                                cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME2)
                            )
                            )
                )
                etList.append(" | ")

                etList.append(
                    (cursor.getString(
                                cursor.getColumnIndex(MyDBOpenHelper.COLUMN_NAME3)
                            )))
                etList.append("\n")
            }
            cursor.close()
        }


        btnBack.setOnClickListener {

            finish()
        }


    }
}