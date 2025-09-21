package com.tamarcusg.openweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tamarcusg.openweather.navigation.NavigationGraph
import com.tamarcusg.openweather.navigation.TopAppBarUIState
import com.tamarcusg.openweather.navigation.navigationGraph
import com.tamarcusg.openweather.ui.theme.OpenWeatherTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            OpenWeatherTheme {
                val mutableTopAppBarUIState = MutableStateFlow(TopAppBarUIState())
                val topAppBarUIState by mutableTopAppBarUIState.collectAsStateWithLifecycle()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        if (topAppBarUIState.isVisible) {
                            TopAppBar(
                                title = {
                                    Text(topAppBarUIState.title)
                                },
                                navigationIcon = {
                                    IconButton(
                                        onClick = topAppBarUIState.onBack
                                    ) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Back Button"
                                        )
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        modifier = Modifier
                            .padding(innerPadding),
                        navController = navController,
                        startDestination = NavigationGraph,
                        builder = {
                            navigationGraph(
                                navController = navController,
                                mutableTopAppBarUIState = mutableTopAppBarUIState
                            )
                        }
                    )
                }
            }
        }
    }
}