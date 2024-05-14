package org.demo.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.demo.mongodb.model.ExpenseCategory;

/*
 * The ExpenseRequest class is a data transfer object that represents the expense request.
 * name: the name of the expense.
 * category: the category of the expense.
 * amount: the amount of the expense.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequest {
    private String name;
    private ExpenseCategory category;
    private double amount;
}
