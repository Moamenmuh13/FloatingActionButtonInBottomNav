package mundroid.apps.floatingactionbuttoninbottomnav

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val switch = findViewById<SwitchMaterial>(R.id.switch_btn)

        bottomNavView.background = null
        bottomNavView.menu.getItem(2).isEnabled = false

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            when (isChecked) {
                true -> enableDarkMode(isChecked)
                false -> enableDarkMode(isChecked)
            }
        }


    }

    private fun enableDarkMode(enabled: Boolean): Boolean {
        return if (enabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(this, "Dark", Toast.LENGTH_SHORT).show()
            true
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            Toast.makeText(this, "Light", Toast.LENGTH_SHORT).show()
            false
        }
    }

}