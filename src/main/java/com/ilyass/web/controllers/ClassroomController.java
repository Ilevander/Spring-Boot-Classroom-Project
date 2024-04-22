package com.ilyass.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ilyass.web.dto.ClassroomDto;
import com.ilyass.web.services.ClassroomService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("")
    public String listClassrooms(Model model) {
        List<ClassroomDto> classrooms = classroomService.findAllClassrooms();
        model.addAttribute("classrooms", classrooms);
        return "classrooms-list";
    }

    @GetMapping("/{classroomId}")
    public String classroomDetail(@PathVariable("classroomId") int classroomId, Model model) {
        ClassroomDto classroomDto = classroomService.findClassroomById(classroomId);
        model.addAttribute("classroom", classroomDto);
        return "classroom-detail";
    }

    @GetMapping("/new")
    public String createClassroomForm(Model model) {
        ClassroomDto classroomDto = new ClassroomDto();
        model.addAttribute("classroom", classroomDto);
        return "classroom-create";
    }

    @PostMapping("/new")
    public String saveClassroom(@Valid @ModelAttribute("classroom") ClassroomDto classroomDto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("classroom", classroomDto);
            return "classroom-create";
        }
        classroomService.createClassroom(classroomDto);
        return "redirect:/classrooms";
    }
  
    @GetMapping("/{classroomId}/edit")
    public String editClassroomForm(@PathVariable("classroomId") int classroomId, Model model) {
        ClassroomDto classroomDto = classroomService.findClassroomById(classroomId);
        model.addAttribute("classroom", classroomDto);
        return "classroom-edit";
    }

    @PostMapping("/{classroomId}/edit")
    public String updateClassroom(@PathVariable("classroomId") int classroomId,
                                  @Valid @ModelAttribute("classroom") ClassroomDto classroomDto,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("classroom", classroomDto);
            return "classroom-edit";
        }
        classroomDto.setClassroomId(classroomId); 
        classroomService.updateClassroom(classroomId, classroomDto);
        return "redirect:/classrooms";
    }


    @GetMapping("/{classroomId}/delete")
    public String deleteClassroom(@PathVariable("classroomId") int classroomId) {
        classroomService.deleteClassroom(classroomId);
        return "redirect:/classrooms";
    }
}
