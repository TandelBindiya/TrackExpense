package com.vedis.trackexpense.ui.route

sealed class AppScreen(val route:String){
    object HomeScreen:AppScreen(ConstantAppScreenName.HOME_SCREEN)
    object AddExpenseScreen:AppScreen(ConstantAppScreenName.ADD_EXPENSE)
}
object ConstantAppScreenName{
    const val HOME_SCREEN="home_screen"
    const val ADD_EXPENSE="add_expense"
}