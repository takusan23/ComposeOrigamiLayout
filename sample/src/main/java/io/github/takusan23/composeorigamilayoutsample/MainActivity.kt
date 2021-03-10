package io.github.takusan23.composeorigamilayoutsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import io.github.takusan23.composeorigamilayout.OrigamiLayout
import io.github.takusan23.composeorigamilayoutsample.ui.screen.HomeScreen
import io.github.takusan23.composeorigamilayoutsample.ui.theme.ComposeOrigamiLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOrigamiLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // HomeScreen()
                    OrigamiLayout {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Tag")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Tag")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Tag")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Tag")
                        }
                    }
                }
            }
        }
    }
}
