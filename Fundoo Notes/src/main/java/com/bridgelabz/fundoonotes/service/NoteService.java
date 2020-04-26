package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.Response;

public interface NoteService {
    Response create(NoteDto noteDto, String token);
    Response update(NoteDto noteDto, String token, int noteId);
    Response delete(String token, int noteId);
}
