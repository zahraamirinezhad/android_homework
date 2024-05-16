package com.example.androidhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidhomework.ui.theme.AndroidHomeworkTheme
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidHomeworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val constraints = Constraints.Builder()
                        .setRequiredNetworkType(androidx.work.NetworkType.NOT_REQUIRED)
                        .build()

                    val periodicWorkRequest = PeriodicWorkRequestBuilder<BluetoothStatusWorker>(2, TimeUnit.MINUTES)
                        .setConstraints(constraints)
                        .build()

                    WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequest)

                    val constraintsAir = Constraints.Builder()
                        .setRequiredNetworkType(androidx.work.NetworkType.NOT_REQUIRED)
                        .build()

                    val periodicWorkRequestAir = PeriodicWorkRequestBuilder<AirplaneModeWorker>(2, TimeUnit.MINUTES)
                        .setConstraints(constraintsAir)
                        .build()

                    WorkManager.getInstance(applicationContext).enqueue(periodicWorkRequestAir)

                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidHomeworkTheme {
        Greeting("Android")
    }
}