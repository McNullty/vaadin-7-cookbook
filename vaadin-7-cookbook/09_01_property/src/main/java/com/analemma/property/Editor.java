package com.analemma.property;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Editor extends TabSheet {

  private ObjectProperty<String> htmlPage = new ObjectProperty<String>(
      "<h1>Vaadin</h1><p>is a <b>Java framework</b> for building modern web applications.</p>");
  private static final int HEIGHT = 300;

  public Editor() {
    addTab(createPreview());
    addTab(createHtmlEditor());
    addTab(createRichEditor());
  }

  private Layout createPreview() {
    Layout layout = createLayout("Preview");
    Label label = new Label("", ContentMode.HTML);
    label.setPropertyDataSource(htmlPage);
    layout.addComponent(label);
    return layout;
  }

  private Layout createHtmlEditor() {
    Layout layout = createLayout("HTML editor");
    TextArea editor = new TextArea();
    editor.setSizeFull();
    editor.setPropertyDataSource(htmlPage);
    layout.addComponent(editor);
    return layout;
  }

  private Layout createRichEditor() {
    Layout layout = createLayout("Rich text editor");
    RichTextArea editor = new RichTextArea();
    editor.setSizeFull();
    editor.setPropertyDataSource(htmlPage);
    layout.addComponent(editor);
    return layout;
  }

  private Layout createLayout(String caption) {
    Layout layout = new VerticalLayout();
    layout.setCaption(caption);
    layout.setHeight(HEIGHT, Unit.PIXELS);
    return layout;
  }

}
