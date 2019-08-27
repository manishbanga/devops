package com.nagarro.nagp.handler;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.nagarro.nagp.Inventory;
import com.nagarro.nagp.domain.Category;
import com.nagarro.nagp.exception.InvalidRequestException;

@RunWith(Parameterized.class)
public class InventoryHandlerImplUnitTest {

	private InventoryHandler inventoryHandler;
	private Inventory inventory;
	private Inventory expectedInventory;
	private Category expectedCategory;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public InventoryHandlerImplUnitTest(Inventory inventory, Category expectedCategory) {
		this.inventory = inventory;
		this.expectedInventory = inventory;
		this.expectedCategory = expectedCategory;
	}

	@Before
	public void setup() {
		inventoryHandler = new InventoryHandler();
	}

	@Parameterized.Parameters
	public static Collection inventoryInput() {
		return Arrays.asList(new Object[][] { { new Inventory(Category.DURABLE), Category.DURABLE },
				{ new Inventory(Category.FRAGILE), Category.FRAGILE } });
	}

	@Test
	public void shouldCreateInventoryAndCategoryMatched() {
		assertEquals(expectedCategory, inventoryHandler.createInventory(inventory).getCategory());
	}

	@Test
	public void shouldCreateInventoryAndMatchedWithExpectedInventory() {
		assertEquals(expectedInventory, inventoryHandler.createInventory(inventory));
	}

	@Test(expected = InvalidRequestException.class)
	public void shouldThrowInvalidRequestExceptionWhenCategoryIsNull() {
		inventoryHandler.createInventory(new Inventory(null));
	}
}
