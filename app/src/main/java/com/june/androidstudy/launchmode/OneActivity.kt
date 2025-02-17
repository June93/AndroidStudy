package com.june.androidstudy.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.june.androidstudy.databinding.ActivityCoroutineBinding
import com.june.androidstudy.databinding.ActivityOneBinding
import com.june.androidstudy.ui.theme.AndroidStudyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author: zhuw
 **/
class OneActivity : ComponentActivity() {

    private val tag = "CoroutineActivity"
    private lateinit var binding: ActivityOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("activity", "onCreate:${this.javaClass.simpleName}")
        enableEdgeToEdge()
        setContent {
            AndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidViewBinding(
                        factory = ActivityOneBinding::inflate,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        binding = this
                        binding.eBt1.setOnClickListener {
                            startActivity(Intent(this@OneActivity, OneActivity::class.java))
                        }
                        binding.eBt2.setOnClickListener {
                            startActivity(Intent(this@OneActivity, SecondActivity::class.java))
                        }
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("activity", "onNewIntent:${this.javaClass.simpleName}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activity", "onRestart:${this.javaClass.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.d("activity", "onStart:${this.javaClass.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity", "onResume:${this.javaClass.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity", "onPause:${this.javaClass.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("activity", "onStop:${this.javaClass.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity", "onDestroy:${this.javaClass.simpleName}")
    }

}