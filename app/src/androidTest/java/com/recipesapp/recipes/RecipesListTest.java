package com.recipesapp.recipes;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class RecipesListTest {
    @Rule
    public ActivityScenarioRule<RecipesList> activityRule = new ActivityScenarioRule<>(RecipesList.class);

    @Test
    public void ClickMenu1(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void ClickMenu2(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }@Test
    public void ClickMenu3(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
    }@Test
    public void ClickMenu4(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
    }@Test
    public void ClickMenu5(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
    }@Test
    public void ClickMenu6(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
    }@Test
    public void ClickMenu7(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));
    }@Test
    public void ClickMenu8(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
    }@Test
    public void ClickMenu9(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(8, click()));
    }@Test
    public void ClickMenu10(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(9, click()));
    }@Test
    public void ClickMenu11(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(10, click()));
    }@Test
    public void ClickMenu12(){
        onView(withId(R.id.recipesRV))
                .perform(RecyclerViewActions.actionOnItemAtPosition(11, click()));
    }
}
