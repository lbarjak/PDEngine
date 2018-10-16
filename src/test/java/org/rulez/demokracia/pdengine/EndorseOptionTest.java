package org.rulez.demokracia.pdengine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.rulez.demokracia.pdengine.annotations.tested_behaviour;
import org.rulez.demokracia.pdengine.annotations.tested_feature;
import org.rulez.demokracia.pdengine.annotations.tested_operation;
import org.rulez.demokracia.pdengine.exception.ReportedException;
import org.rulez.demokracia.pdengine.testhelpers.CreatedDefaultChoice;

public class EndorseOptionTest extends CreatedDefaultChoice{

	@Before
	public void setUp() throws ReportedException {
		super.setUp();
	}

	@tested_feature("Vote")
	@tested_operation("Endorse option")
	@tested_behaviour("if adminKey is not user, the userName is registered as endorserName for the choice")
	@Test
	public void endorsement_is_registered() {
		voteManager.endorseChoice(adminInfo.adminKey, adminInfo.voteId, choiceId, "testuser");
		assertTrue(getChoice(choiceId).endorsers.contains("testuser"));
	}

}