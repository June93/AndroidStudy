package com.june.androidstudy.coroutine

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
import com.june.androidstudy.ui.theme.AndroidStudyTheme
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * @author: zhuw
 **/
class CoroutineActivity : ComponentActivity() {

    private val tag = "CoroutineActivity"
    private lateinit var binding: ActivityCoroutineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AndroidViewBinding(
                        factory = ActivityCoroutineBinding::inflate,
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

}