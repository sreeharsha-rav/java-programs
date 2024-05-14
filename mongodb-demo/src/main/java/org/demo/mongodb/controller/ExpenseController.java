package org.demo.mongodb.controller;

import lombok.RequiredArgsConstructor;
import org.demo.mongodb.dto.ExpenseRequest;
import org.demo.mongodb.dto.ExpenseResponse;
import org.demo.mongodb.model.Expense;
import org.demo.mongodb.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * The ExpenseController class is a REST controller that exposes APIs to add, get, update, and delete expenses.
 * addExpense: API to add an expense.
 * getAllExpenses: API to get all expenses.
 * getExpenseById: API to get an expense by id.
 * getExpenseByName: API to get an expense by name.
 * updateExpense: API to update an expense.
 * deleteExpense: API to delete an expense.
 */
@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses() {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponse> getExpenseById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpenseById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<ExpenseResponse> getExpenseByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpenseByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable String id, @RequestBody ExpenseRequest expenseRequest) {
        expenseService.updateExpense(id, expenseRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
