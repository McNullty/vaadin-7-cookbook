package com.analemma.vaadin_mvp.view.tag;

import java.util.List;

import com.analemma.vaadin_mvp.model.tag.Tag;


public interface TagListLayout extends TagLayout {

  void afterSuccessfulFetch(List<Tag> tags);
}
