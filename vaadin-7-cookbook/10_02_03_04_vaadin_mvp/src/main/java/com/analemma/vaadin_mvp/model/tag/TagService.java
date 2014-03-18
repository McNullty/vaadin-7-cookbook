package com.analemma.vaadin_mvp.model.tag;

import java.util.List;

import com.analemma.vaadin_mvp.model.ServiceException;

public interface TagService {

  List<Tag> findAll() throws ServiceException;

  void save(Tag tag) throws ServiceException;
}
