package com.analemma.read_it;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;

@SuppressWarnings("serial")
public class ReadIt extends HorizontalLayout {

  private final TextArea editor;
  private final TextArea viewer;
  private static final int WIDTH = 400;
  private static final int HEIGHT = 200;
  private static final int MIN_WORD_LENGTH = 4;

  public ReadIt() {
    setMargin(true);
    setSpacing(true);
    editor = createEditor();
    viewer = createViewer();
    addComponent(editor);
    addComponent(viewer);
  }

  private TextArea createEditor() {
    final TextArea editor = new TextArea("Original");
    editor.setWidth(WIDTH, Unit.PIXELS);
    editor.setHeight(HEIGHT, Unit.PIXELS);
    editor.setImmediate(true);
    editor.setTextChangeEventMode(TextChangeEventMode.EAGER);
    editor.addTextChangeListener(new TextChangeListener() {
      @Override
      public void textChange(final TextChangeEvent event) {
        viewer.setValue(transformText(event.getText()));
      }
    });
    return editor;
  }

  private TextArea createViewer() {
    final TextArea view = new TextArea("Transformed");
    view.setWidth(WIDTH, Unit.PIXELS);
    view.setHeight(HEIGHT, Unit.PIXELS);
    return view;
  }

  private String transformText(final String text) {
    String result = "";
    final String words[] = text.split(" ");
    for (final String word : words) {
      if (word.length() < MIN_WORD_LENGTH || areAllInnerCharsSame(word)) {
        result += word + " ";
      } else {
        result += shuffleChars(word) + " ";
      }
    }
    return result;
  }

  private String shuffleChars(final String word) {
    String result = "";
    result += word.charAt(0);
    final List<Character> characters = new ArrayList<>();
    for (int i = 1; i < word.length() - 1; i++) {
      characters.add(word.charAt(i));
    }
    Collections.shuffle(characters);

    for (final char character : characters) {
      result += character;
    }

    result += word.charAt(word.length() - 1);
    if (word.equals(result)) {
      result = shuffleChars(word);
    }
    return result;
  }

  private boolean areAllInnerCharsSame(final String word) {
    final Character firstChar = word.charAt(1);
    for (int i = 2; i < word.length() - 1; i++) {
      if (!firstChar.equals(word.charAt(i))) {
        return false;
      }
    }
    return true;
  }

}
