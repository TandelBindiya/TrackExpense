package com.vedis.trackexpense.ui.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vedis.trackexpense.presentation.expense.AddExpenseScreen
import com.vedis.trackexpense.presentation.expense.HomeScreen
import com.vedis.trackexpense.presentation.main.MainViewModel

@Composable
fun NavGraph(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.HomeScreen.route
    ) {
        composable(route = AppScreen.HomeScreen.route) {
            HomeScreen(mainViewModel, navController)
        }
        composable(route = AppScreen.AddExpenseScreen.route) {
            AddExpenseScreen(mainViewModel, navController)
        }
    }
}