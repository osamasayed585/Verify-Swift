package com.example.verifyswift.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.verifyswift.components.VerifySwiftTopBar
import com.example.verifyswift.theme.VerifySwiftTheme
import com.example.verifyswift.ui.sample.SampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isLightTheme by remember { mutableStateOf(false) }
            VerifySwiftTheme(isLightTheme) {

                Scaffold(
                    topBar = { VerifySwiftTopBar { isLightTheme = !isLightTheme } }
                ) { innerPadding ->
                    SampleScreen(innerPadding)

                }
            }
        }
    }
}