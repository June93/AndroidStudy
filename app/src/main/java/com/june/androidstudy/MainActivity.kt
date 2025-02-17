package com.june.androidstudy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.june.androidstudy.coroutine.CoroutineActivity
import com.june.androidstudy.launchmode.OneActivity
import com.june.androidstudy.ui.theme.AndroidStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("activity","onCreate:${this.javaClass.simpleName}")
        enableEdgeToEdge()
        setContent {
            AndroidStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android", modifier = Modifier.padding(innerPadding)
                        )
                        Coroutine(activity = this@MainActivity)
                        SingleTop(activity = this@MainActivity)
                    }
                }
            }
        }
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Composable
fun Coroutine(activity: MainActivity) {
    Button(onClick = {
        activity.startActivity(Intent(activity, CoroutineActivity::class.java))
    }) {
        Text(
            text = "协程", modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        )
    }
}

@Composable
fun SingleTop(activity: MainActivity) {
    Button(onClick = {
        activity.startActivity(Intent(activity, OneActivity::class.java))
    }) {
        Text(
            text = "启动第一个", modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidStudyTheme {
        Greeting("Android")
    }
}