package org.demo.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/*
 * The Expense class is a model class that represents an expense.
 * id: the id of the expense.
 * name: the name of the expense.
 * category: the category of the expense.
 * amount: the amount of the expense.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "expenses")
public class Expense {

    @Id
    private String id;

    @Field(name = "name")
    @Indexed(unique = true)
    private String name;

    @Field(name = "category")
    private ExpenseCategory category;

    @Field(name = "amount")
    private double amount;

}
