package org.example.defualtSystem;

import org.example.models.Character;
import org.example.models.Industry;
import org.example.models.Property;

public class FastFoodShop extends Industry {

    /**
     * Industry type example (Business)
     * */
    private static final float INCOME = 0.3f;
    private static final float EMPLOYEE_INCOME = 0.02f;
    public FastFoodShop(String title, Property property, Character character) {
        super(title, property, character,EMPLOYEE_INCOME);
    }
}
