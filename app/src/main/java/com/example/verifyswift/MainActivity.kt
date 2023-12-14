package com.example.verifyswift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.droidDevOs.verifyswift.SwiftAuthVerify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }

        SwiftAuthVerify.printText("main activity")
    }
}
