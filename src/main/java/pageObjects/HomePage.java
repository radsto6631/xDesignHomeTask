package pageObjects;

import com.google.common.collect.Ordering;
import managers.DriverBoss;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DoAction;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(DriverBoss.getInstance(), this);
    }

    @FindAll({@FindBy(xpath = "//ul[@class='launch-list']//span[@class='launch-item__date']")})
    private List<WebElement> launchDatesList;

    @FindAll({@FindBy(xpath = "//li[@class='launch-item']//span[@class='launch-item__label']")})
    private List<WebElement> launchLabelsList;

    @FindAll({@FindBy(xpath = "//ul[@class='launch-list']/li")})
    private List<WebElement> launchList;
    @FindBy(xpath = "//ul[@class='launch-list']")
    private WebElement launchWindow;
    @FindBy(xpath = "//select[@name='Filter By Year']")
    private WebElement yearFilter;

    @FindBy(xpath = "//button[contains(@class, 'button--sort')]")
    private WebElement sortButton;

    public HomePage verifyLaunchListItemsAreFromYear(String year) {
        Assert.assertEquals(
                "List includes launches not in " + year,
                false,
                launchDatesList.stream().anyMatch(launchYear -> !launchYear.getText().endsWith(year))
        );
        return new HomePage();
    }

    public HomePage checkIfLaunchListLoaded() {
        DoAction.waitForElement(launchWindow);
        Assert.assertEquals(
                "Launch list is empty",
                false,
                launchDatesList.size() == 0
        );
        return new HomePage();
    }

    public HomePage clickOnYearFilter() {
        DoAction.click(yearFilter);
        return new HomePage();
    }

    public HomePage selectYearFromDropdown(String year) {
        DoAction.selectFromDropdown(yearFilter, year);
        return new HomePage();
    }

    public HomePage verifyFilterIsNotOn() {
        Select select = new Select(yearFilter);
        Assert.assertEquals(
                "Year Filter is On",
                true,
                select.getFirstSelectedOption().getText().equals("Filter By Year")
        );
        return new HomePage();
    }

    public HomePage setSortingTo(String order) {
        DoAction.waitForElement(sortButton);
        if (!sortButton.getText().contains(order)) {
            DoAction.click(sortButton);
            Assert.assertEquals(
                    "Sorting is not set to " + order,
                    true,
                    sortButton.getText().contains(order)
            );
        }
        return new HomePage();
    }

    public HomePage verifyItemsAreSortedAlphabetically() {
        List<String> list = launchLabelsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList()
                );
        boolean isSorted = Ordering.natural().isOrdered(list);
        Assert.assertEquals(
                "Elements are not sorted",
                true,
                isSorted
        );
        return new HomePage();
    }

}
