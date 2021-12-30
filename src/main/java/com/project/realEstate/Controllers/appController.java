package com.project.realEstate.Controllers;

import com.project.realEstate.Entities.Property;
import com.project.realEstate.Services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
 @RequestMapping("/views/admin")
public class appController {

    @Autowired
    private PropertyService propertyService;


    @GetMapping("/")
    public String showAll(Model model){

        List<Property> show = propertyService.showAll();
        model.addAttribute("properties", show);

        return "propertyList";
    }

    @GetMapping("/create")
    public String admin(Model model){

        Property property = new Property();
         model.addAttribute("title", "Create a new property");
         model.addAttribute("property", property);

        return "admin";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute Property property, Model model, RedirectAttributes redirectAttributes){

        try {
            propertyService.createProperty(property);
            redirectAttributes.addFlashAttribute("message", "Property created");
            return "redirect:/views/admin/";
        }catch (Exception e){
            Property property1 = property;
            model.addAttribute("error", e.getMessage());
            model.addAttribute("title", "Create a new property");
            model.addAttribute("property", property1);
            return "admin";
        }

    }
    @GetMapping("entrada")
    public String entrada(){
        return "entrada";
    }


}
