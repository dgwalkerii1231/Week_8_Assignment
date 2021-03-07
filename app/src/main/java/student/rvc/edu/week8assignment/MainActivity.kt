package student.rvc.edu.week8assignment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind objects
        val btnSend = findViewById<Button>(R.id.btnSend)
        val txtNameSend = findViewById<EditText>(R.id.txtNameSend)
        val txtBirthdateSend = findViewById<EditText>(R.id.txtBirthdateSend)
        val txtColorSend = findViewById<EditText>(R.id.txtColorSend)

        btnSend.setOnClickListener(View.OnClickListener {
            //Intent is used to send data between activities
            val intent = Intent(this, MainActivity2::class.java)
            //putExtra sets value to name SendStuff (Could be called whatever you want
            intent.putExtra("SendStuff", "Name: " + txtNameSend.text.toString() +
                    "\nDate of Birth: " + txtBirthdateSend.text.toString() +
                    "\nFavorite Color: " + txtColorSend.text.toString())
            //Go to second activity
            startActivity(intent)

        })

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }

    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}