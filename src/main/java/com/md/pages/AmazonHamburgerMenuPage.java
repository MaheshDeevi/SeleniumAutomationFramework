/**
 * The {@code AmazonHamburgerMenuPage} class represents the page object for the Amazon
 * application's hamburger menu. It extends the {@link BasePage} class and provides
 * methods to interact with the main menu items.
 *
 * <p>This class is designed to be used for navigating the Amazon application's
 * hamburger menu and clicking on the specified main menu item to open the corresponding
 * sub-menu.
 *
 * <p>Usage example:
 * <pre>
 * AmazonHamburgerMenuPage hamburgerMenuPage = new AmazonHamburgerMenuPage();
 * AmazonHamburgerSubMenuPage subMenuPage = hamburgerMenuPage.clickMainMenu("Electronics");
 * </pre>
 *
 * @author Mahesh Deevi
 * @version 1.0
 * @since 2023-12-03
 */
package com.md.pages;

import org.openqa.selenium.By;

import com.md.enums.WaitStrategy;
import com.md.utils.DynamicXpathUtils;

/**
 * The {@code AmazonHamburgerMenuPage} class represents the page object for the Amazon
 * application's hamburger menu. It extends the {@link BasePage} class and provides
 * methods to interact with the main menu items.
 */
public final class AmazonHamburgerMenuPage extends BasePage {

    /**
     * Protected constructor to prevent direct instantiation of the class.
     * Instances of this class should be created using a suitable factory or page object.
     */
    protected AmazonHamburgerMenuPage() {}

    /** The XPath pattern for the main menu link. */
    private String linkMainMenu = "//div[text()='%s']/parent::a";

    /**
     * Clicks on the specified main menu item in the Amazon application's hamburger menu.
     * This method dynamically generates the XPath for the menu item using the provided text.
     *
     * @param menuText The text of the main menu item to be clicked.
     * @return An instance of {@link AmazonHamburgerSubMenuPage} representing the sub-menu
     *         opened after clicking the main menu item.
     */
    public AmazonHamburgerSubMenuPage clickMainMenu(String menuText) {
        String newXpath = DynamicXpathUtils.getXpath(linkMainMenu, menuText);
        click(By.xpath(newXpath), WaitStrategy.CLICKABLE, menuText + " is clicked");
        return new AmazonHamburgerSubMenuPage();
    }
}
