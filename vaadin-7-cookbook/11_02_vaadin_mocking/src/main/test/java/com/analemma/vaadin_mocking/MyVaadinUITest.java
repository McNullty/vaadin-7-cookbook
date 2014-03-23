package com.analemma.vaadin_mocking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.Component;

public class MyVaadinUITest {

  private MyVaadinUI ui;

  @Before
  public void setUp() {
    ui = new MyVaadinUI();
    ui.init(null);
  }

  @Test
  public void isContentLoginLayout() throws Exception {
    final Component content = ui.getContent();
    Assert.assertTrue(content instanceof SystemStatusLayout);
  }
}
