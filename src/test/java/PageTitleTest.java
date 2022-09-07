import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.devtools.v85.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTitleTest extends DriverStart {
    private static Logger logger = LoggerFactory.getLogger(PageTitleTest.class);

    @ParameterizedTest(name = "{index} +" + " " + "{0} has been verified")
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Check age title")
    @Tag("regression")
    public void pageTitleTest(String websiteAddress, String expectedTitle) {
        getDriver().get(websiteAddress);
        logger.info("My website address is: " + websiteAddress);

        assertThat(getDriver().getTitle()).isEqualTo(expectedTitle);
    }


}
