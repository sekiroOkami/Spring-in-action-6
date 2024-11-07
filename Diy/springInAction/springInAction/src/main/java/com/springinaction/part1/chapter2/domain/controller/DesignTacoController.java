package com.springinaction.part1.chapter2.domain.controller;

import com.springinaction.part1.chapter2.domain.Ingredient;
import com.springinaction.part1.chapter2.domain.Taco;
import com.springinaction.part1.chapter2.domain.TacoOrder;
import com.springinaction.part1.chapter2.domain.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder") // tacoOrder obj that is put into the model should be maintained in session
public class DesignTacoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @ModelAttribute
    public void addIngredientsTotModel(Model model) {
        List<Ingredient> ingredients =
            Arrays.asList( new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                    new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                    new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                    new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                    new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                    new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                    new Ingredient("CHED", "Cheddar", Type.CHEESE),
                    new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                    new Ingredient("SLSA", "Salsa", Type.SAUCE),
                    new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
            );
        Type[] types = Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.type().equals(type))
                .collect(Collectors.toList());
    }

    // This method ensure that a TacoOrder obj is added to the model with the name tacoOrder
    // b4 any request handling method in controller is invoked.
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping()
    public String showDesignForm() {
        return "design-page";
    }

    @PostMapping()
    public String processTaco(Taco taco, @ModelAttribute(name = "tacoOrder") TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        logger.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

}
