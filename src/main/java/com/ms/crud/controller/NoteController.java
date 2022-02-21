package com.ms.crud.controller;

import com.ms.crud.models.NoteModel;
import com.ms.crud.models.ResponseModel;
import com.ms.crud.repositories.NoteRepository;
import com.ms.crud.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/service/note")
public class NoteController {
    @Autowired
    NoteService noteService;

    @Autowired
    NoteRepository noteRepository;


    @PostMapping(value ="/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<ResponseModel> create(@Valid @RequestBody NoteModel entity) throws Exception {
        NoteModel noteModel = noteService.create(entity);
        try {
            return new ResponseEntity<>(new ResponseModel(noteModel.getNoteId(),1, "note created successfully"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseModel(0,0, "note hasn't created successfully", e.getMessage(), ""), HttpStatus.CREATED);
        }
    }

    @GetMapping("/getAll")
    public List<NoteModel> findAll() {

        return noteService.findAll();

    }

//
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    NoteModel updateNote(@PathVariable Long id, @RequestBody NoteModel entity){
        NoteModel note = noteRepository.findByNoteId(id);

        if(note != null) {
            noteService.updateNote(entity);
        }

        return note;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(new ResponseModel(),HttpStatus.OK);
    }
}
