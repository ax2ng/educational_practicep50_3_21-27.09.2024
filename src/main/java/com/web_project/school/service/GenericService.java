package com.web_project.school.service;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T findById(Long id);
    T add(T entity);
    T update(T entity);
    void delete(Long id);
}