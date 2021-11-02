package ru.sikuda.mobile.sharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sikuda.mobile.sharedpref.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener{ onClick(it) }
        binding.btnSave.setOnClickListener{ onClick(it) }

    }

    fun onClick(v: View) {
        when (v.getId()) {
            R.id.btnSave -> saveText()
            R.id.btnLoad -> loadText()
            else -> {
                Toast.makeText(this, "What's the f...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveText() {
        getPreferences(MODE_PRIVATE)
            .edit()
            .putString(KEY_TEXT_FOR_SAVE, binding.etText.getText().toString())
            .apply()
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadText() {
        val savedText: String = getPreferences(MODE_PRIVATE).getString(KEY_TEXT_FOR_SAVE, "").toString()
        binding.etText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
    }

    companion object {
        val KEY_TEXT_FOR_SAVE = "SAVED_TEXT"
    }
}

