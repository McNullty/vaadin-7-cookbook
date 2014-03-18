package com.analemma.vaadin_mvp.view.tag.impl;

import com.analemma.vaadin_mvp.view.tag.TagView;
import com.analemma.vaadin_mvp.view.tag.TagViewHandler;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

public class TagViewImpl extends VerticalLayout implements TagView {

  private static final long serialVersionUID = -4433371101938771823L;
  private NewTagLayoutImpl newTagLayout;
  private TagListLayoutImpl tagListLayout;

  @Override
  public void enter(final ViewChangeListener.ViewChangeEvent viewChangeEvent) {}

  @Override
  public NewTagLayoutImpl getNewTagLayout() {
    return newTagLayout;
  }

  @Override
  public TagListLayoutImpl getTagListLayout() {
    return tagListLayout;
  }

  @Override
  public void setHandler(final TagViewHandler handler) {
    newTagLayout.setHandler(handler);
    tagListLayout.setHandler(handler);
  }

  @Override
  public void init() {
    setSpacing(true);
    setMargin(true);

    newTagLayout = new NewTagLayoutImpl();
    addComponent(newTagLayout);
    tagListLayout = new TagListLayoutImpl();
    addComponent(tagListLayout);
  }
}
