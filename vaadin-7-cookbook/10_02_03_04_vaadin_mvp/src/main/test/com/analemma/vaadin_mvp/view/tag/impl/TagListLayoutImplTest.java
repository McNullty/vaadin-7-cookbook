package com.analemma.vaadin_mvp.view.tag.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.analemma.vaadin_mvp.view.tag.TagViewHandler;

public class TagListLayoutImplTest {

  private TagListLayoutImpl layout;
  private TagViewHandler handler;

  @Before
  public void setUp() {
    layout = new TagListLayoutImpl();
    handler = mock(TagViewHandler.class);
    layout.setHandler(handler);
  }

  @Test
  public void areTagsFetchedAfterInitilization() {
    layout.init();

    verify(handler, times(1)).showTagList();
  }
}
