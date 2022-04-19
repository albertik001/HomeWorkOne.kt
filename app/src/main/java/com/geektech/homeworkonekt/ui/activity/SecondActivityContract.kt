package com.geektech.homeworkonekt.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.geektech.homeworkonekt.common.Constants.MAIN_KEY

class SecondActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, SecondActivity::class.java)
            .putExtra(MAIN_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? = when {
        resultCode != Activity.RESULT_OK -> null
        else -> intent?.getStringExtra(MAIN_KEY)
    }
}