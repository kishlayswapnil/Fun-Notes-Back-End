package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.Response;
import com.bridgelabz.fundoonotes.service.NoteService;
import com.bridgelabz.fundoonotes.utility.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/creation")
    public ResponseEntity<Response> create(@RequestBody NoteDto noteDto, @RequestHeader String token) {
        Response response =null;
        if(noteDto.getTitle().equals("") && noteDto.getDescription().equals("")) {
            response = ResponseInfo.getResponse(-700, "Entering Data in title and description is mandatory");
        }else
            response = noteService.create(noteDto, token);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody NoteDto noteDTO, @RequestHeader String token, @PathVariable int id) {
        Response response = noteService.update(noteDTO, token, id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@RequestHeader String token, @PathVariable int id) {
        Response response = noteService.delete(token, id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
