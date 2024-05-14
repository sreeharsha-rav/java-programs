package org.demo.mongodb.service;

import lombok.RequiredArgsConstructor;
import org.demo.mongodb.dto.ExpenseRequest;
import org.demo.mongodb.dto.ExpenseResponse;
import org.demo.mongodb.model.Expense;
import org.demo.mongodb.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * The ExpenseService class is annotated with @Service annotation to indicate that it is a service class.
 * addExpense: Method to add an expense.
 * getAllExpenses: Method to get all expenses.
 * getExpenseByName: Method to get an expense by name.
 * getExpenseById: Method to get an expense by id.
 * updateExpense: Method to update an expense.
 * deleteExpense: Method to delete an expense.
 */
@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<ExpenseResponse> getAllExpenses() {
        return expenseRepository.findAll().stream()
                .map(expense -> ExpenseResponse.builder()
                        .id(expense.getId())
                        .name(expense.getName())
                        .category(expense.getCategory().name())
                        .amount(expense.getAmount())
                        .build())
                .toList();
    }

    public ExpenseResponse getExpenseByName(String name) {
        Expense expense = expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense with name: %s", name)));

        return ExpenseResponse.builder()
                .id(expense.getId())
                .name(expense.getName())
                .category(expense.getCategory().name())
                .amount(expense.getAmount())
                .build();
    }

    public ExpenseResponse getExpenseById(String id) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense with id: %s", id)));

        return ExpenseResponse.builder()
                .id(expense.getId())
                .name(expense.getName())
                .category(expense.getCategory().name())
                .amount(expense.getAmount())
                .build();
    }

    public void updateExpense(String id, ExpenseRequest expenseRequest) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense with id: %s", id)));

        expense.setName(expenseRequest.getName());
        expense.setCategory(expenseRequest.getCategory());
        expense.setAmount(expenseRequest.getAmount());

        expenseRepository.save(expense);
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

}
