package com.gather.trip.controller;

import com.gather.trip.domain.BoardVO;
import com.gather.trip.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService bservice;

    @Autowired
    public BoardController(BoardService bservice) {
        this.bservice = bservice;
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", bservice.list());
        return "list";
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("name","오구");
        return "index";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    @PostMapping("/insert")
    public String insert(BoardVO bvo){
        bservice.insert(bvo);

        return "redirect:/boards";
    }

    @GetMapping("/read")
    public String read(@RequestParam int num, Model model){
        model.addAttribute("board",bservice.read(num));
        return "read";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam int num){
        bservice.remove(num);
        return "redirect:/boards/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam int num, Model model){
        model.addAttribute("board",bservice.read(num));
        return "update";
    }

    @PostMapping("/update")
    public String update(BoardVO bvo){
        bservice.update(bvo.getNum(), bvo);
        return "redirect:/boards/list";
    }

}
