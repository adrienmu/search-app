package com.amussio.myfirstapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amussio.myfirstapp.data.ws.RetrofitBuilder
import com.amussio.myfirstapp.domain.usecases.QueryPicturesUseCase
import com.amussio.myfirstapp.domain.repository.PicturesRepositoryImpl
import com.amussio.myfirstapp.ui.models.SearchScreenUiState
import com.amussio.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel = SearchScreenViewModel(
        QueryPicturesUseCase(PicturesRepositoryImpl(RetrofitBuilder.pixabayApi))
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val uiState by viewModel.uiState.collectAsState()
            var query by remember { mutableStateOf("") }

            MyFirstAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        SearchBar(
                            value = query,
                            onValueChange = {
                                query = it
                                viewModel.query(query)
                            })
                        when(uiState) {
                            is SearchScreenUiState.Results -> { Results((uiState as SearchScreenUiState.Results).pictures.map { it.url }) }
                            is SearchScreenUiState.Error -> Text("${(uiState as SearchScreenUiState.Error).message}")
                            else -> Unit
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit) {
    TextField(modifier = Modifier.fillMaxWidth(), value = value, onValueChange = onValueChange)
}

@Composable
fun Results(urls: List<String>) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {

        urls.forEach {
            ItemResul(url = it)
        }
    }
}

@Composable
fun ItemResul(url: String) {
    Text(text = url)
}
