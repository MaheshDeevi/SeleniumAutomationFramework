package com.md.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * @since Dec 01, 2023
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.factories.ExplicitWaitFactory
 * @see com.md.pages.BasePage
 */
public enum WaitStrategy {
	
	CLICKABLE,
	PRESENCE,
	VISIBILE,
	NONE

}
