package org.demo.mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * The ExpenseResponse class is a data transfer object that represents the expense response.
 * id: the id of the expense.
 * name: the name of the expense.
 * category: the category of the expense.
 * amount: the amount of the expense.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseResponse {
    private String id;
    private String name;
    private String category;
    private double amount;
}
