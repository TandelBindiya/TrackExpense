package com.vedis.trackexpense.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDao: ExpenseDao) {

    suspend fun fetchExpenses(): Flow<List<Expense>> {
        return expenseDao.getExpenses()
    }

    suspend fun addExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }
}