package br.com.ite.si.aula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_form_field.*
import kotlinx.android.synthetic.main.view_form_field.view.*

class Foo {
    var name: String? = null
        set(value) {
            field = value
            // muda
        }

    fun printName() {
        println(name)
    }
}

fun sample() {
    val foo1 = Foo()
    var foo2 = Foo()

    foo1.name = "valdemar"
    foo2.name = ""

    foo1.printName()
    foo2.printName()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_form_field_label)

        val view = formfield_name.apply {
            text_form_field_label.text = "Nome"
            edit_form_field_value.run {
                hint = "Digite seu nome"
                inputType = InputType.TYPE_TEXT_VARIATION_NORMAL
            }
        }

        view == formfield_name //true

        button_toast.setOnClickListener {
            val toast = Toast.makeText(
                this,
                "Toastyyy",
                Toast.LENGTH_SHORT
            )
            toast.view = layoutInflater.inflate(R.layout.view_form_field, null)
            toast.show()
        }
    }
}
