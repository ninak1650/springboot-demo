package com.example.springboot_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class LuckyNumberController {

    private static final String[] MESSAGES = {
        "✨ May this number bring you a little extra magic today!",
        "🌈 Today is the perfect day to believe in small miracles.",
        "🍀 Let this number lead you to something unexpectedly great.",
        "🔮 Trust your instincts — they're better than you think.",
        "💫 You deserve something good today. This number agrees!",
        "🌟 This number won’t change your fate, but maybe your mood.",
        "🌻 A little luck goes a long way. You've got this!"
    };

    private final Random random = new Random();

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/lucky-number")
    public String getLuckyNumber(@RequestParam String name, Model model) {
        int luckyNumber = random.nextInt(99) + 1;
        String message = MESSAGES[random.nextInt(MESSAGES.length)];

        model.addAttribute("name", name);
        model.addAttribute("number", luckyNumber);
        model.addAttribute("message", message);

        return "result";
    }
}
