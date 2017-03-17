package org.mainacad.accGoods.controller;


import org.mainacad.accGoods.service.StuffService;
import org.mainacad.accGoods.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Fujitsu on 06.03.2017.
 */

@Controller
public class StuffController {

    private StuffService stuffService;

    @Autowired(required = true)
    public void setStuffService(StuffService stuffService) {
        this.stuffService = stuffService;
    }

    @RequestMapping(value = "/stuffs")
    public String listStuffs(Model model) {
        model.addAttribute("stuffAttribute", stuffService.listStuff());
        return "stuffList";
    }

    @RequestMapping(value = "stuffs/new")
    public String newStuff(Model model) {
        model.addAttribute("stuffs", new Stuff());
        return "stuffForm";

    }

    @RequestMapping(value = "stuffs/new", method = RequestMethod.POST)
    public String addStuff(Stuff stuff){
        stuffService.saveStuff(stuff);
        return "redirect:/stuffs";
    }


    @RequestMapping("remove/id")
    public String removeId(@PathVariable int id) {
        stuffService.deleteStuff(id);

        return "redirect:/stuffs";
    }


    @RequestMapping("stuffs/{id}")
    public String showStuff(@PathVariable int id, Model model) {
        model.addAttribute("student", stuffService.getStuff(id));
        return "stuffToShow";
    }

    @RequestMapping("stuffs/edit/{id}")
    public String editStuff(@PathVariable int id, Model model) {
        model.addAttribute("student", stuffService.getStuff(id));
        return "stuffForm";
    }


}


