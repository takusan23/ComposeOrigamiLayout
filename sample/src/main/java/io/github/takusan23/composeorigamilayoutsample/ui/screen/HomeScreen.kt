package io.github.takusan23.composeorigamilayoutsample.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.takusan23.composeorigamilayout.OrigamiLayout

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxHeight(),
    ) {
        // 文字列配列
        val list = remember { mutableStateListOf<String>() }
        // テキストボックスに入れてる文字列
        val editTextValue = remember { mutableStateOf("") }
        // 折り返すやつ
        OrigamiLayout(
            isAcceptSort = true
        ) {
            // テキスト配置
            list.forEach { text ->
                OutlinedButton(
                    onClick = { },
                    modifier = Modifier.padding(2.dp)
                ) {
                    Text(
                        text = text
                    )
                }
            }
        }
        // 追加
        Row {
            // テキストボックス
            TextField(
                modifier = Modifier.weight(1f),
                value = editTextValue.value,
                onValueChange = { editTextValue.value = it }
            )
            // 追加ボタン
            Button(
                onClick = {
                    list.add(editTextValue.value)
                },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(text = "Add Text")
            }
        }
    }
}