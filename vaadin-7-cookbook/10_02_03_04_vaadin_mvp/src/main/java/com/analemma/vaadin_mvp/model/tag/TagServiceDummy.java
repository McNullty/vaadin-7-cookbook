package com.analemma.vaadin_mvp.model.tag;

import java.util.ArrayList;
import java.util.List;

public class TagServiceDummy implements TagService {

  ArrayList<Tag> tags = new ArrayList<Tag>();

  public TagServiceDummy() {
    final Tag java = new Tag("Java");
    final Tag groovy = new Tag("Groovy");
    final Tag scala = new Tag("Scala");
    tags.add(java);
    tags.add(groovy);
    tags.add(scala);
  }

  @Override
  public List<Tag> findAll() {
    return tags;
  }

  @Override
  public void save(final Tag tag) {
    tags.add(tag);
  }
}
