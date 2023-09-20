package comp31.fidy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.fidy.services.EmployeeService;

@Controller
public class MainController {

    EmployeeService employeeService;

    public MainController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
        /**
         * Add some employees to the employee list.
         * Choose any employee and department names
         * Add some template pages to match the departments you choose
         */
        employeeService.addEmployee("Tori", "admin");
        employeeService.addEmployee("Trevor", "developer");
        employeeService.addEmployee("Emma", "user");
        employeeService.addEmployee("Ethan", "developer");
        employeeService.addEmployee("Fidy", "guest");
        employeeService.addEmployee("Jack", "admin");
        employeeService.addEmployee("Tony", "guest");
        employeeService.addEmployee("James", "user");
    }

    @GetMapping("/")
    public String getRoot() {
        return "login";
    }

    @GetMapping("/login")
    public String getLogin(Model model, @RequestParam String userId){
        model.addAttribute("userId", userId);

        String department = employeeService.findDepartment(userId);
        
        if (department == null) 
            model.addAttribute("department", "home");
        else
            model.addAttribute("department", department);
        
        if (department == null)
            return "home";
        else 
            return "departments/" + department;
    }

    @GetMapping("/image")
    public String getImage(@RequestParam String imageName, Model model) {
        model.addAttribute("name", imageName);
        return "imagePage";
    }
}
