package com.clones.controller;

import com.clones.service.CloneService;
import com.clones.service.dto.CloneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clone")
public class CloneController {

    private final CloneService cloneService;

    @Autowired
    public CloneController(CloneService cloneService) {
        this.cloneService = cloneService;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<CloneDto> getAll() {
        return cloneService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CloneDto getById(@PathVariable(name = "id") Integer id) {
        return cloneService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody CloneDto dto) {
        cloneService.add(dto);
        return "Клон был добавлен";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody CloneDto dto) {
        cloneService.update(dto);
        return "Информация о клоне с ид '" + dto.getId() + "' была изменена";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        cloneService.delete(id);
        return "Клон с ид '" + id.toString() + "' был удален";
    }
}
