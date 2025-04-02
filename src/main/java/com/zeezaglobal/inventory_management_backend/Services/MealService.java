package com.zeezaglobal.inventory_management_backend.Services;

import com.zeezaglobal.inventory_management_backend.Entity.Meal;
import com.zeezaglobal.inventory_management_backend.Repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> getMealsByDate(LocalDate date) {
        return mealRepository.findByDate(date);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}
