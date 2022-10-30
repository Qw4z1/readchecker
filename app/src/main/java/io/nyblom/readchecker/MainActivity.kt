package io.nyblom.readchecker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import io.nyblom.readchecker.ui.ReadsList
import io.nyblom.readchecker.ui.theme.ReadCheckerTheme


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReadCheckerTheme {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                ) {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(viewModel.isRefreshing.value),
                        onRefresh = { viewModel.refresh() }
                    ) {
                        ReadsList(readState = viewModel.uiState.value)
                    }
                }
            }
        }
    }
}

