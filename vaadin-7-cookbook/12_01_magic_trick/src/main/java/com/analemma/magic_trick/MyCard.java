package com.analemma.magic_trick;

import org.vaadin.artur.playingcards.Card;
import org.vaadin.artur.playingcards.client.ui.Suite;

@SuppressWarnings("serial")
public class MyCard extends Card {

  public MyCard(final Suite suite, final int rank) {
    super(suite, rank);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + getRank();
    result = prime * result + ((getSuite() == null) ? 0 : getSuite().hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final MyCard other = (MyCard) obj;
    if (getRank() != other.getRank()) {
      return false;
    }
    if (getSuite() != other.getSuite()) {
      return false;
    }
    return true;
  }



}
