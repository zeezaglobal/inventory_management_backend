package com.zeezaglobal.inventory_management_backend.Controller;

import com.zeezaglobal.inventory_management_backend.Entity.Meal;
import com.zeezaglobal.inventory_management_backend.Services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        System.out.println("Incoming Meal: " + meal);
        return mealService.addMeal(meal);
    }

    @GetMapping("/date/{date}")
    public List<Meal> getMealsByDate(@PathVariable String date) {
        return mealService.getMealsByDate(LocalDate.parse(date));
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @DeleteMapping("/{id}")
    public void deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
    }
}