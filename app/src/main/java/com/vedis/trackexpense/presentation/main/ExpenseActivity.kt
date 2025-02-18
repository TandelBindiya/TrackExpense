package com.vedis.trackexpense.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.vedis.trackexpense.ui.route.NavGraph
import com.vedis.trackexpense.ui.theme.TrackExpenseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseActivity : ComponentActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackExpenseTheme(appTheme = mainViewModel.appState.appTheme) {
               NavGraph(mainViewModel)
            }
        }
    }


}
/*enum class SheetType {
    NONE, ADD, FILTER
}
@Preview(showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun HomeScreen() {
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var currentSheet by remember { mutableStateOf(SheetType.NONE) }
    ModalBottomSheet(
        sheetState =sheetState,
        onDismissRequest = {
            currentSheet = SheetType.NONE
        }
    ) { }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(background)
        .padding(16.dp)){
        Text(text = "Track Expense", fontSize = 28.sp, fontWeight = FontWeight.Medium)
    }
}*/

