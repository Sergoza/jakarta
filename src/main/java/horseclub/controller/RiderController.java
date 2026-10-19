package horseclub.controller;

import horseclub.entity.Rider;
import horseclub.service.RiderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping
    public String listRiders(Model model) {
        model.addAttribute("riders", riderService.getAllRiders());
        model.addAttribute("rider", new Rider());
        return "riders";
    }

    @PostMapping("/save")
    public String saveRider(@ModelAttribute("rider") Rider rider) {
        riderService.saveRider(rider);
        return "redirect:/riders";
    }

    @GetMapping("/edit/{id}")
    public String editRider(@PathVariable Long id, Model model) {
        Rider rider = riderService.getRiderById(id);
        if (rider != null) {
            model.addAttribute("rider", rider);
            model.addAttribute("riders", riderService.getAllRiders());
            return "riders";
        }
        return "redirect:/riders";
    }

    @GetMapping("/delete/{id}")
    public String deleteRider(@PathVariable Long id) {
        riderService.deleteRider(id);
        return "redirect:/riders";
    }
}