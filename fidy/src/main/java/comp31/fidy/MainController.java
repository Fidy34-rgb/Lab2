package comp31.fidy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String getRoot() {
        return "login";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam String userId, Model model){
        String site;
        switch(userId.toLowerCase()) {
            case "sam":
                model.addAttribute("userId", userId);
                site = "sales";
                break;
            case "sue":
                model.addAttribute("userId", userId);
                site = "sales";
                break;
            case "olivia":
                model.addAttribute("userId", userId);
                site = "orders";
                break;
            case "ollie":
                model.addAttribute("userId", userId);
                site = "orders";
                break;
            case "rachel":
                model.addAttribute("userId", userId);
                site = "repairs";
                break;
            case "ralph":
                model.addAttribute("userId", userId);
                site = "repairs";
                break;
            default:
                model.addAttribute("userId", userId);
                site = "home";
                break;
        }
        return site;
    }

    @GetMapping("/image")
    public String getImage(@RequestParam String imageName, Model model) {
        model.addAttribute("name", imageName);
        return "imagePage";
    }
}
