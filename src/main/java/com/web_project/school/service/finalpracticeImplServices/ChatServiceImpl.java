package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.*;
import com.web_project.school.repository.finalpracticerepository.ChatRepository;
import com.web_project.school.service.finalpracticeservices.*;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl extends GenericServiceImpl<Chat> implements ChatService {

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        super(chatRepository);
    }
}