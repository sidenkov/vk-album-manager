package com.example.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch

@Composable
fun App() {
    val componentScope = rememberCoroutineScope()

    var counter by remember { mutableStateOf(0) }
    var status by remember { mutableStateOf("not requested yet") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { counter-- }) {
                Text("--")
            }

            Text(counter.toString())

            Button(onClick = { counter++ }) {
                Text("++")
            }
        }

        Text(status)

        Button(onClick = {
            componentScope.launch {
                status = HttpClient().get("https://ktor.io/").status.toString()
            }
        }) {
            Text("GET ktor.io/")
        }
    }
}
