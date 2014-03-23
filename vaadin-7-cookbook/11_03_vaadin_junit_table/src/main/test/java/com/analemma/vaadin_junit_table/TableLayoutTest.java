package com.analemma.vaadin_junit_table;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

public class TableLayoutTest {
  private TableLayout tableLayout;

  @Before
  public void setUp() throws Exception {
    tableLayout = new TableLayout();
  }

  @Test
  public void isInitializedProperly() {
    tableLayout.init();
    final Component component = tableLayout.getComponent(0);
    Assert.assertTrue(component instanceof Table);
  }

  @Test
  public void areTableColumnsVisible() {
    tableLayout.init();
    final Table table = tableLayout.getTable();
    final Object[] visibleColumns = table.getVisibleColumns();
    Assert.assertEquals("name", visibleColumns[0]);
  }

  @Test
  public void doesTableContainItems() {
    final List<User> fakeUsers = new ArrayList<User>();
    final User wayneGretzky = new User("Wayne Gretzky");
    fakeUsers.add(wayneGretzky);
    final User jaromirJagr = new User("Jaromir Jagr");
    fakeUsers.add(jaromirJagr);
    final User sidneyCrosby = new User("Sidney Crosby");
    fakeUsers.add(sidneyCrosby);
    final UserService mockedUserService = Mockito.mock(UserService.class);
    Mockito.when(mockedUserService.findAll()).thenReturn(fakeUsers);
    tableLayout.setUserService(mockedUserService);

    tableLayout.init();
    final Table table = tableLayout.getTable();
    @SuppressWarnings("unchecked")
    final List<User> itemIds = (List<User>) table.getItemIds();

    Assert.assertEquals(3, itemIds.size());
    Assert.assertEquals(wayneGretzky, itemIds.get(0));
    Assert.assertEquals(jaromirJagr, itemIds.get(1));
    Assert.assertEquals(sidneyCrosby, itemIds.get(2));
  }

}
