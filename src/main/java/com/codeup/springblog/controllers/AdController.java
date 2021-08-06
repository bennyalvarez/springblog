package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {
    private final AdRepository adDao;
    private final UserRepository userDao;

    public AdController(AdRepository adDao, UserRepository userDao) {
        this.adDao = adDao;
        this.userDao = userDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{n}")
    public String viewOne(@PathVariable long n, Model model) {
        Ad ad = adDao.findById(n);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/first/{title}")
    public String viewOneByTitle(@PathVariable String title, Model model) {
        Ad ad = adDao.findByTitle(title);
        model.addAttribute("ad", new Ad());
        return "ads/show";

    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model) {
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("ads/create")
    public String createAd(@ModelAttribute Ad ad) {
        ad.setUser(userDao.getById(1L));
        adDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("ads/{id}/edit")
    public String editAdForm(@PathVariable long id, Model model){
        Ad adToEdit = adDao.getById(id);
        model.addAttribute("ad", adToEdit);
        return "ads/create";
    }

    @PostMapping("/ads/{id}/edit")
    public String editAd(@PathVariable long id, @ModelAttribute Ad ad) {
        return createAd(ad);
    }

    @PostMapping("ads/{id}/delete")
    public String deleteAd(@PathVariable long id) {
        adDao.delete(adDao.findById(id));
        return "redirect:/ads";
    }
}
