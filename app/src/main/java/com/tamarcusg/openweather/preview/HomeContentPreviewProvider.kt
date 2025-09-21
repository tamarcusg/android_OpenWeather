package com.tamarcusg.openweather.preview

import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.tamarcusg.openweather.util.LoadingState

internal class HomeContentPreviewProvider : CollectionPreviewParameterProvider<HomeContentPreviewData>(
    listOf(
        HomeContentPreviewData(
            searchString = "",
            loadingState = LoadingState.None
        ),
        HomeContentPreviewData(
            searchString = "New York",
            loadingState = LoadingState.Loading
        ),
        HomeContentPreviewData(
            searchString = "New York",
            loadingState = LoadingState.Error
        )
    )
)

internal data class HomeContentPreviewData(
    val searchString: String,
    val loadingState: LoadingState
)