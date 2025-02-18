package com.vedis.trackexpense.presentation.expense

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedis.trackexpense.data.Expense
import com.vedis.trackexpense.data.ExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(private val expenseRepository: ExpenseRepository) :
    ViewModel() {
    private val _expenses = MutableLiveData<List<Expense>>()
    val expenses: LiveData<List<Expense>> = _expenses
    init {
        loadExpenses()
    }

    fun loadExpenses() {
        viewModelScope.launch {
            expenseRepository.fetchExpenses().collectLatest {
                _expenses.postValue(it)
            }
        }
    }

    fun addExpense(
        category: String,
        date: String,
        amount: Double,
        description: String? = null
    ) {
        val expense =
            Expense(category = category, date = date, amount = amount, description = description)
        viewModelScope.launch {
            expenseRepository.addExpense(expense)
        }
    }
}