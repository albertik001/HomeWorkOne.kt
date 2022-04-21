package com.geektech.homeworkonekt.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.homeworkonekt.R
import com.geektech.homeworkonekt.common.Constants.MAIN_KEY
import com.geektech.homeworkonekt.common.Constants.SECOND_KEY
import com.geektech.homeworkonekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(ActivityMainBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transit()
    }

    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data;
            binding.etInfo.setText(intent!!.getStringExtra(SECOND_KEY))
            binding.etInfo.setSelection(binding.etInfo.text.length)
            println("${intent.getStringExtra(SECOND_KEY)}")
        }
    }

    private fun transit() {
        binding.btnNext.setOnClickListener {
            if (binding.etInfo.text.isEmpty())
                Toast.makeText(this, getString(R.string.placeholder_field), Toast.LENGTH_SHORT)
                    .show()
            else
                openSomeActivityForResult(binding.etInfo.text.toString())
        }
    }

    private fun openSomeActivityForResult(toString: String) {
        val intent = Intent(this, SecondActivity::class.java).putExtra(
            MAIN_KEY,
            toString
        )
        resultLauncher.launch(intent)
    }
}