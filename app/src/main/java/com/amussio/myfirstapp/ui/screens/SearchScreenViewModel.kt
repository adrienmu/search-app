package com.amussio.myfirstapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amussio.myfirstapp.domain.usecases.QueryPicturesUseCase
import com.amussio.myfirstapp.ui.mappers.toUi
import com.amussio.myfirstapp.ui.models.SearchScreenUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SearchScreenViewModel(private val queryPicturesUseCase: QueryPicturesUseCase): ViewModel() {

    private val _uiState: MutableStateFlow<SearchScreenUiState> = MutableStateFlow(SearchScreenUiState.Empty)
    val uiState = _uiState.asStateFlow()

    private var job: Job? = null

    fun query(keywords: String?) {

        job?.run { if (isActive) cancel() }

        job = viewModelScope.launch {

            if (keywords.isNullOrEmpty()) {
                _uiState.emit(SearchScreenUiState.Empty)
            } else {
                _uiState.emit(SearchScreenUiState.Loading)

                queryPicturesUseCase.invoke(query = keywords)
                    .flowOn(Dispatchers.IO)
                    .catch {
                        _uiState.emit(SearchScreenUiState.Error("${it.message}"))
                    }
                    .collect { pictures ->
                        if (pictures.isEmpty()) {
                            _uiState.emit(SearchScreenUiState.Empty)
                        } else {
                            _uiState.emit(SearchScreenUiState.Results(pictures.map { it.toUi() }))
                        }
                    }
            }

        }
    }
}