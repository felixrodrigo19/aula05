package br.com.ite.si.aula

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    companion object {
        private const val REQUEST_CODE_ADD = 5
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_list, menu!!)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_new -> {
                val intent = Intent(this, UserActivity::class.java)
                // startActivity(intent)
                startActivityForResult(intent, REQUEST_CODE_ADD)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(
        requestCode: Int, resultCode: Int, data: Intent?
    ) {
        when (requestCode) {
            REQUEST_CODE_ADD -> when (resultCode) {
                Activity.RESULT_CANCELED -> {
                }
                Activity.RESULT_OK -> {
                    val useData = UserActivity.extractUserData(data!!)
                    val (name, age) = useData

                    text_users.text = "${text_users.text} $name, $age\n"
                }
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
