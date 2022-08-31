import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTitle extends DriverStart {

    @ParameterizedTest(name = "{index} +" + " " + "{0} has been verified")
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Check page title")
    @Tag("regression")
//    @Tag(value = "{0}")
    public void websiteTitleTest(String displayName, String websiteAddress, String expectedTitle) {
        getDriver().get(websiteAddress);
        System.out.println(displayName);
        assertThat(getDriver().getTitle()).isEqualTo(expectedTitle);

        getDriver().quit();
    }


}
