package com.analemma.vaadin_mvp.view.tag.impl;

import java.util.List;

import com.analemma.vaadin_mvp.model.tag.Tag;
import com.analemma.vaadin_mvp.view.tag.TagListLayout;
import com.analemma.vaadin_mvp.view.tag.TagViewHandler;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;

public class TagListLayoutImpl extends HorizontalLayout implements TagListLayout {

  private static final long serialVersionUID = -3865708245484385798L;
  private ListSelect tagList;
  private TagViewHandler handler;

  @Override
  public void init() {
    setCaption("Tag list");
    setSpacing(true);
    setMargin(true);

    tagList = new ListSelect();
    tagList.setItemCaptionPropertyId("name");
    addComponent(tagList);

    handler.showTagList();
  }

  @Override
  public void setHandler(final TagViewHandler handler) {
    this.handler = handler;
  }

  @Override
  public void afterSuccessfulFetch(final List<Tag> tags) {
    tagList.setContainerDataSource(new BeanItemContainer<Tag>(Tag.class, tags));
  }
}
