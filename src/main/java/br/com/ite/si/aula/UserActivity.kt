package br.com.ite.si.aula

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_form_field.view.*


class UserActivity : AppCompatActivity() {
    companion object {
        fun extractUserData(of: Intent): Pair<String, Int> {
            return of.run {
                Pair(
                    getStringExtra("name")!!,
                    getIntExtra("age", 18)
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        formfield_name.apply {
            text_form_field_label.text = "Nome"
            edit_form_field_value.run {
                hint = "Digite seu nome"
                inputType = InputType.TYPE_NUMBER_FLAG_SIGNED
            }
        }

        // Bloco de verificação
        button_toast.setOnClickListener {
            val name = formfield_name.run {
                edit_form_field_value.text.toString()
            }
            val age = formfield_age.text

            if (name.isBlank() || age.isBlank() || age.toInt() < 18) {
                Toast.makeText(
                    this,
                    "Preencha os campos",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            val ageNumber = age.toInt()
            setResult(
                Activity.RESULT_OK,
                Intent().apply {
                    putExtra("name", name)
                    putExtra("age", ageNumber)
                }
            )
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
