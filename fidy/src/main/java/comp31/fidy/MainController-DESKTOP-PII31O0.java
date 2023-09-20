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
        model.addAttribute("userId", userId);
        return "home";
    }

    @GetMapping("/image")
    public String getImage(@RequestParam String imageName, Model model){
        model.addAttribute("name", imageName);
        return "imagePage";
    }
}
