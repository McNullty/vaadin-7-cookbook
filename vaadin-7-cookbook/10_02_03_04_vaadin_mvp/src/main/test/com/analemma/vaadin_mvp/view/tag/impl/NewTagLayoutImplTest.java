package com.analemma.vaadin_mvp.view.tag.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.analemma.vaadin_mvp.view.tag.TagViewHandler;

public class NewTagLayoutImplTest {
  private NewTagLayoutImpl layout;
  private TagViewHandler handler;

  @Before
  public void setUp() {
    layout = new NewTagLayoutImpl();
    handler = mock(TagViewHandler.class);
    layout.setHandler(handler);
    layout.init();
  }

  @Test
  public void isTagAddedAfterButtonIsClicked() {
    layout.getBtnConfirm().click();

    verify(handler, times(1)).addTag();
  }

}
