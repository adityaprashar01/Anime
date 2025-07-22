package com.example.anime.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.anime.viewmodel.AnimeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: AnimeViewModel = viewModel()) {
    val animeList by viewModel.animeList.collectAsState()
    val error by viewModel.error.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Top 10 Anime") })
        }
    ) { padding ->
            if (error.isNotEmpty()) {
                Column(modifier = Modifier.padding(padding)) {
                    Text(
                        text = error,
                        color = Color.Red,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(padding)
                ) {
                    items(animeList) { anime ->
                        Text(
                            text = "Rank - ${anime.rank}. Title- ${anime.title}",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
    }
}