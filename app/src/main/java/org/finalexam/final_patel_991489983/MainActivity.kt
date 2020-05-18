package org.finalexam.final_patel_991489983

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    private val SAVE_TAG = "Save_Button"
    private val CLEAR_TAG = "Clear_Button"
    private val VIEW_TAG = "View_Button"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {

            val dbHandler = MyDBOpenHelper(this, null)

            val product = Product(etName.text.toString(), etPrice.text.toString(), etDescription.text.toString())

            val status = dbHandler.addProduct(product)

            if (etName.length() == 0 || etPrice.length() == 0) {
                Toast.makeText(this,"Please Enter Both Name and Price !!!", Toast.LENGTH_LONG).show()
            }
            else {

                if (status > 0) {
                    Toast.makeText(
                        this, etName.text.toString() + " , " +
                                etPrice.text.toString() + "added to DB", Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        this, "User not Added", Toast.LENGTH_LONG
                    ).show()
                }
            }

            etName.setText("")
            etPrice.setText("")
            etDescription.setText("")

            Log.d(SAVE_TAG, "Data saved in database")


        }


        btnClear.setOnClickListener {


            etName.setText("")
            etPrice.setText("")
            etDescription.setText("")

            Log.d(CLEAR_TAG, "Data cleared")

        }


        btnView.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            Log.d(VIEW_TAG, "Moved to ssecond activity")
        }







    }

}
