package horseclub.controller;

import horseclub.entity.Horse;
import horseclub.service.HorseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/horses")
public class HorseController {

    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping
    public String listHorses(Model model) {
        model.addAttribute("horses", horseService.getAllHorses());
        model.addAttribute("horse", new Horse());
        return "horses"; // Имя HTML-шаблона
    }

    @PostMapping("/save")
    public String saveHorse(@ModelAttribute("horse") Horse horse) {
        horseService.saveHorse(horse);
        return "redirect:/horses";
    }

    @GetMapping("/edit/{id}")
    public String editHorse(@PathVariable Long id, Model model) {
        Horse horse = horseService.getHorseById(id);
        if (horse != null) {
            model.addAttribute("horse", horse);
            model.addAttribute("horses", horseService.getAllHorses());
            return "horses";
        }
        return "redirect:/horses";
    }

    @GetMapping("/delete/{id}")
    public String deleteHorse(@PathVariable Long id) {
        horseService.deleteHorse(id);
        return "redirect:/horses";
    }
}