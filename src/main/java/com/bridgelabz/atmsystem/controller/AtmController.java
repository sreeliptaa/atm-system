package com.bridgelabz.atmsystem.controller;

import com.bridgelabz.atmsystem.dto.AtmDto;
import com.bridgelabz.atmsystem.service.AtmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * Purpose: To demonstrate different http methods
 *
 * @author : SREELIPTA
 * @since : 04-12-2021
 */
@RestController
@RequestMapping(value = "/atm")
public class AtmController {

    @Autowired
    private AtmService atmService;

    /**
     * Purpose : Method to get all the atm objects in the repository via GET.
     *
     * @return : Returns list of atm objects in JSON format.
     */
    @GetMapping(value = "/get-all-atm")
    public List<AtmDto> getAllAtm() {
        return atmService.getAllAtm();
    }

    /**
     * Purpose : Method to add new atm objects in the repository via POST.
     *
     * @return : Returns String if atm object is added.
     */
    @PostMapping(value = "/add-atm")
    public String addAtm(@Valid @RequestBody AtmDto atmDto) {
        return atmService.addAtm(atmDto);
    }

    /**
     * Purpose : Method to update new atm objects in the repository via PUT.
     *
     * @return : Returns String if atm object is added.
     */
    @PutMapping(value = "/update-atm/{id}")
    public String updateAtm(@PathVariable int id,
                            @Valid
                            @RequestBody AtmDto atmDto) {
        return atmService.updateAtm(id, atmDto);
    }

    /**
     * Purpose : Method to delete new atm objects in the repository via DELETE.
     *
     * @return : Returns String if atm object is added.
     */
    @DeleteMapping(value = "/delete-atm")
    public String deleteAtm(@RequestParam int id) {
        return atmService.deleteAtm(id);
    }
}
