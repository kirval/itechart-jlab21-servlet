package com.itechart;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 */
@WebListener()
public class SimpleServletListener implements ServletContextListener,
    ServletContextAttributeListener {

  private static final Logger log =
      Logger.getLogger("jlab21.SimpleServletListener");

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("Context initialized");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    log.info("Context destroyed");
  }

  @Override
  public void attributeAdded(ServletContextAttributeEvent event) {
    log.log(Level.INFO, "Attribute {0} has been added, with value: {1}",
        new Object[]{event.getName(), event.getValue()});
  }

  @Override
  public void attributeRemoved(ServletContextAttributeEvent event) {
    log.log(Level.INFO, "Attribute {0} has been removed",
        event.getName());
  }

  @Override
  public void attributeReplaced(ServletContextAttributeEvent event) {
    log.log(Level.INFO, "Attribute {0} has been replaced, with value: {1}",
        new Object[]{event.getName(), event.getValue()});
  }
}
