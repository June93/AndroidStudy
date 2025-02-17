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
import com.june.androidstudy.databinding.ActivityThirdBinding
import com.june.androidstudy.ui.theme.AndroidStudyTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author: zhuw
 **/
class ThirdActivity : ComponentActivity() {

    private val tag = "CoroutineActivity"
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("activity","onCreate:${this.javaClass.simpleName}")
        enableEdgeToEdge()
        setContent {
            AndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidViewBinding(
                        factory = ActivityThirdBinding::inflate,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        binding = this
                        testException1()
                        testException2()
                    }
                }
            }
        }
    }


    private fun testException1() {
        binding.eBt1.setOnClickListener {
            runBlocking {
                Log.d(tag, "runBlocking 里面开始。。。。。。")
                delay(200)
                Log.d(tag, "runBlocking 里面结束。。。。。。")
            }
            Log.d(tag, "runBlocking 外面。。。。。。")
        }
    }

    private fun testException2() {
        binding.eBt2.setOnClickListener {
            GlobalScope.launch {
                coroutineScope {  }
                val job = launch {
                    Log.d(Thread.currentThread().name, " 抛出未捕获异常")
                    throw NullPointerException("异常测试")
                }
                job.join()
                Log.d(Thread.currentThread().name, "end")
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("activity","onNewIntent:${this.javaClass.simpleName}")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activity","onRestart:${this.javaClass.simpleName}")
    }

    override fun onStart() {
        super.onStart()
        Log.d("activity","onStart:${this.javaClass.simpleName}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity","onResume:${this.javaClass.simpleName}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity","onPause:${this.javaClass.simpleName}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("activity","onStop:${this.javaClass.simpleName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity","onDestroy:${this.javaClass.simpleName}")
    }

}