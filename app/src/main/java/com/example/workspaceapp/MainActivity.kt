package com.example.workspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.workspaceapp.navigation.AppNavGraph
import com.example.workspaceapp.ui.theme.WorkspaceAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.workspaceapp.viewmodel.ReservationViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkspaceAppTheme {
                val navController = rememberNavController()
                val reservationViewModel: ReservationViewModel = hiltViewModel()
                AppNavGraph(
                    navController = navController,
                    reservationViewModel = reservationViewModel
                )
            }
        }
    }
}

