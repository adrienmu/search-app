package com.amussio.myfirstapp.ui.models

sealed interface SearchScreenUiState {
    class Error(val message: String): SearchScreenUiState
    object Empty: SearchScreenUiState
    object Loading: SearchScreenUiState
    class Results(val pictures: List<PictureUi>): SearchScreenUiState
}
