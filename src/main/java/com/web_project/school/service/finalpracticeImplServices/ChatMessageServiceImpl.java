package com.web_project.school.service.finalpracticeImplServices;

import com.web_project.school.model.finalpracticemodels.*;
import com.web_project.school.repository.finalpracticerepository.ChatMessageRepository;
import com.web_project.school.service.finalpracticeservices.*;
import com.web_project.school.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl extends GenericServiceImpl<ChatMessage> implements ChatMessageService {

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
        super(chatMessageRepository);
    }
}