package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteDto;
import com.bridgelabz.fundoonotes.model.Note;
import com.bridgelabz.fundoonotes.model.Response;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.utility.ResponseInfo;
import com.bridgelabz.fundoonotes.utility.TokenGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@PropertySource("classpath:status.properties")
public class NoteServiceImplimentation implements NoteService {

    @Autowired
    private TokenGenerator tokenGenerator;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Environment environment;
    private Response response;
    private Optional<User> userData;


    @Override
    public Response create(NoteDto noteDto, String token) {
        int id = tokenGenerator.retrieveIdFromToken(token);
        userData = userRepository.findById(id);
        if (!(userData.isPresent() && userData.get().isVerified()))
            return response = ResponseInfo.getResponse(
                    Integer.parseInt(environment.getProperty("status.login.errorCode")),
                    environment.getProperty("status.user.existError"));
        Note noteData = modelMapper.map(noteDto, Note.class);
        noteData.setDescription(noteDto.getDescription());
        noteData.setTitle(noteDto.getTitle());
        noteData = noteRepository.save(noteData);

        if (noteData != null) {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.success.code")),
                    environment.getProperty("status.note.create.success"));
        }else {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.note.errorCode")),
                    environment.getProperty("status.note.errorMessage"));
        }
        return response;
    }


    @Override
    public Response update(NoteDto noteDto, String token, int noteId) {
        int userId = tokenGenerator.retrieveIdFromToken(token);
        userData = userRepository.findById(userId);
        if (!(userData.isPresent() && userData.get().isVerified()))
            return response = ResponseInfo.getResponse(
                    Integer.parseInt(environment.getProperty("status.login.errorCode")),
                    environment.getProperty("status.user.existError"));
        User user = userData.get();
        Note noteUpdate = null;
        if (noteRepository.findByIdAndUser(noteId, user).isPresent()) {
            noteUpdate = noteRepository.findByIdAndUser(noteId, user).get();
        } else if (noteUpdate == null) {
            return response = ResponseInfo.getResponse(
                    Integer.parseInt(environment.getProperty("status.note.errorCode")),
                    environment.getProperty("status.note.exists.error"));
        }
        if (!(noteDto.getTitle() == null || noteDto.getTitle().equals("")))
            noteUpdate.setTitle(noteDto.getTitle());
        if (!(noteDto.getDescription() == null || noteDto.getDescription().equals("")))
            noteUpdate.setDescription(noteDto.getDescription());
        noteUpdate = noteRepository.save(noteUpdate);
        if (noteUpdate != null) {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.success.code")),
                    environment.getProperty("status.note.update.success"));
        } else {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.note.errorCode")),
                    environment.getProperty("status.note.update.error"));
        }
        return response;
    }




    @Override
    public Response delete (String token,int noteId){
        int userId = tokenGenerator.retrieveIdFromToken(token);
        userData = userRepository.findById(userId);
        if (!(userData.isPresent() && userData.get().isVerified()))
            return response = ResponseInfo.getResponse(
                    Integer.parseInt(environment.getProperty("status.login.errorCode")),
                    environment.getProperty("status.user.existError"));
        User user = userData.get();
        Optional<Note> noteData = noteRepository.findByIdAndUser(noteId, user);
        if (!noteData.isPresent())
            return response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.note.errorCode")),
                    environment.getProperty("status.note.exists.error"));
        noteRepository.deleteById(noteId);
        if (!noteRepository.findByIdAndUser(noteId, user).isPresent()) {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.success.code")),
                    environment.getProperty("status.note.delete.success"));
        }else {
            response = ResponseInfo.getResponse(Integer.parseInt(environment.getProperty("status.note.errorCode")),
                    environment.getProperty("status.note.delete.error"));
        }
        return response;
    }
}
