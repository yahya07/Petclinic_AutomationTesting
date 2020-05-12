package org.springframework.samples.petclinic.pages.visit;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;
import org.springframework.samples.petclinic.pages.Page;

public class AddVisitPage extends Page {

    private final String URL="http://localhost:8081/petclinic/pets/8/visits/add";
    private final String DATE_FIELD_CSS = "#visit > div.form-group.has-feedback > div:nth-child(1) > div > input";
    private final String DESCRIPTION_FILED_CSS = "#description";
    private final String SUBMIT_BUTTON_CSS = "#visit > div:nth-child(2) > div > button:nth-child(4)";
    private final String VALID_DATE_VALUE = "2019-09-08";
    private final String INVALID_DATE_VALUE = "hgkj-hg-mm";
    private final String VALID_DESCRIPTION_VALUE  = "Visit description has been written for add test.";
    private final String INVALID_DESCRIPTION_VALUE  = "$%^&**(&%%$";

    public AddVisitPage(WebDriver driver) {
        super("New Visit",driver);
    }

    public void fillValidVisitForm() {
        cssFill(DATE_FIELD_CSS, VALID_DATE_VALUE);
        cssFill(DESCRIPTION_FILED_CSS, VALID_DESCRIPTION_VALUE);
    }

    public void fillInValidVisitForm() {
        cssFill(DATE_FIELD_CSS, INVALID_DATE_VALUE);
        cssFill(DESCRIPTION_FILED_CSS, INVALID_DESCRIPTION_VALUE);
    }

    public OwnerInformationPage submitVisitForm() {
        cssClick(SUBMIT_BUTTON_CSS);
        return new OwnerInformationPage(driver);
    }

    public boolean visitAddedSuccessfully() {
        implicitlyWait(10);
        return VALID_DESCRIPTION_VALUE.equals(getText("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list[1]/table/tr/td[2]/app-visit-list/table/tr[1]/td[2]"));
    }
    public boolean isOnSamePage(){
        return isCurrentUrl(URL);
    }

}
