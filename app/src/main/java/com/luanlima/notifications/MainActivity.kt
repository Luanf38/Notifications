package com.luanlima.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getSystemService
import com.luanlima.notifications.data.notiication.Notification
import com.luanlima.notifications.ui.theme.NotificationsTheme

const val CHANNEL_ID = "DEFAULT_ID"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotificationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }


    fun createChannel(): Unit {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "NotificationChannel"
            val descriptionText = "Default channel to show notification in the app \"Notifications\""
            val importance = NotificationManager.IMPORTANCE_HIGH
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = application.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }


}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    ElevatedButton(
        modifier = modifier,
        onClick = {}

    ) {
        Text(text = "Show notification")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotificationsTheme {
        Greeting()
    }
}