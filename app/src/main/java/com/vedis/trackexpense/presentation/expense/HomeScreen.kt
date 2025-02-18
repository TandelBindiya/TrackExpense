package com.vedis.trackexpense.presentation.expense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vedis.trackexpense.core.toCurrency
import com.vedis.trackexpense.data.Expense
import com.vedis.trackexpense.presentation.main.MainEvent
import com.vedis.trackexpense.presentation.main.MainViewModel
import com.vedis.trackexpense.ui.route.ConstantAppScreenName

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    navController: NavHostController,
    expenseViewModel: ExpenseViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { TopBar(mainViewModel) },
        floatingActionButton = { AddExpenseButton(navController) }) { innerPadding ->
        ExpenseList(innerPadding, expenseViewModel)
    }
}

@Composable
fun AddExpenseButton(navController: NavHostController) {
    FloatingActionButton(onClick = {
        navController.navigate(ConstantAppScreenName.ADD_EXPENSE)
    }) {
        Icon(Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun ExpenseList(innerPadding: PaddingValues, expenseViewModel: ExpenseViewModel) {
    val expenses = expenseViewModel.expenses.observeAsState(emptyList())
    LazyColumn(modifier = Modifier.fillMaxWidth().padding(8.dp), contentPadding = innerPadding) {
        items(expenses.value.size) { index ->
            ExpenseItem(expenses.value[index])
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = expense.category)
            Text(text = expense.date)
        }
        Text(text = expense.amount.toCurrency())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(mainViewModel: MainViewModel) {
    TopAppBar(title = { Text("Track Expense") }, colors = TopAppBarDefaults.topAppBarColors(containerColor =MaterialTheme.colorScheme.primary ), actions = {
        IconButton(onClick = {
            mainViewModel.onEvent(MainEvent.ThemeChange)
        }) {
            Icon(Icons.Outlined.Edit, contentDescription = "Change Theme")
        }
    })
}