package com.analemma.vaadin_mvp.model;

public class ServiceException extends Exception {

  private static final long serialVersionUID = -7868824065184218293L;

  public ServiceException() {}

  public ServiceException(final String s) {
    super(s);
  }

  public ServiceException(final String s, final Throwable throwable) {
    super(s, throwable);
  }

  public ServiceException(final Throwable throwable) {
    super(throwable);
  }
}
