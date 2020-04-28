package br.com.ite.si.aula

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class LoadScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_screen)

        var button = findViewById<Button>(R.id.button_acao_demorada)

        button.setOnClickListener {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.my_dialog)
            dialog.setCancelable(false)

            dialog.show()

            Timer().schedule(object : TimerTask() {
                override fun run() {

                    dialog.dismiss()
                }
            }, 10000)

        }


    }

}