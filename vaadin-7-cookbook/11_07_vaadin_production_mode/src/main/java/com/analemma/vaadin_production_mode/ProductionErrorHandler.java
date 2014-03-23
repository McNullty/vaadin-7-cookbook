package com.analemma.vaadin_production_mode;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.server.ErrorHandler;

/**
 * @author Ondrej Kvasnovsky
 */
public class ProductionErrorHandler implements ErrorHandler {

  private static final long serialVersionUID = 6054253565263558692L;
  private static final Logger log = Logger.getLogger(ProductionErrorHandler.class.getName());

  @Override
  public void error(final com.vaadin.server.ErrorEvent errorEvent) {
    final Throwable throwable = errorEvent.getThrowable();
    log.log(Level.SEVERE, "UI error occurred.", throwable);
  }
}
