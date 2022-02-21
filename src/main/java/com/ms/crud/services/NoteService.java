package com.ms.crud.services;

import com.ms.crud.models.NoteModel;
import com.ms.crud.models.UserModel;
import com.ms.crud.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public NoteModel create(NoteModel noteModel) throws Exception {
        noteModel.setCreatedAt(LocalDateTime.now());
        try {
            return noteRepository.save(noteModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<NoteModel> findAll() {
        return noteRepository.findAll();

    }

    public Optional<NoteModel> getById(Long id) {
        return noteRepository.findById(id);
    }

    public NoteModel updateNote(NoteModel noteModel) {
        return noteRepository.save(noteModel);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
        ;}
}
