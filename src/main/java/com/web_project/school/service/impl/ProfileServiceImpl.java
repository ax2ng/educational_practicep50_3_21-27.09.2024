package com.web_project.school.service.impl;

import com.web_project.school.model.ProfileModel;
import com.web_project.school.repository.ProfileRepository;
import com.web_project.school.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends GenericServiceImpl<ProfileModel> implements ProfileService {

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        super(profileRepository);
    }
}