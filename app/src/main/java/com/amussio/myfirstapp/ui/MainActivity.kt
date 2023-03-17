package com.amussio.myfirstapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.amussio.myfirstapp.ui.screens.SearchScreen
import com.amussio.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyFirstAppTheme {
                SearchScreen()
            }
        }
    }
}
