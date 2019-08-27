package com.nagarro.nagp.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.VerificationModeFactory;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.nagarro.nagp.Inventory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RepositoryHelper.class)
public class DurableInventoryRepositoryUnitTest {
	
	@InjectMocks
	private static DurableInventoryRepository durableInventoryRepository;
	
	@Mock
	Inventory inventory;
	
	@Test 
	public void shouldSaveDuarable() throws Exception {
		
		PowerMockito.mockStatic(RepositoryHelper.class);
		PowerMockito.doNothing().when(RepositoryHelper.class, "saveDurable", inventory);
		
		RepositoryHelper.saveDurable(inventory);
		PowerMockito.verifyStatic(VerificationModeFactory.times(1));
	}
	
}

