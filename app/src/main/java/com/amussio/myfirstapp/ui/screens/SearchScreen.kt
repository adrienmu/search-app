package com.amussio.myfirstapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.amussio.myfirstapp.ui.components.SearchBar
import com.amussio.myfirstapp.ui.components.SearchResultsView
import com.amussio.myfirstapp.ui.models.SearchScreenUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(viewModel: SearchScreenViewModel = koinViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val uiState by viewModel.uiState.collectAsState()
        var query by remember { mutableStateOf("") }
        Column {
            SearchBar(
                value = query,
                onValueChange = {
                    query = it
                    viewModel.query(query)
                })
            when(uiState) {
                is SearchScreenUiState.Results -> { SearchResultsView((uiState as SearchScreenUiState.Results).pictures) }
                is SearchScreenUiState.Error -> Text("${(uiState as SearchScreenUiState.Error).message}")
                else -> Unit
            }
        }
    }
}