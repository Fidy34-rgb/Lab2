package comp31.fidy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/login")
    public String getLogin(@RequestParam String userId, Model model){
        model.addAttribute("userId", userId);
        return "home";
    }
}
