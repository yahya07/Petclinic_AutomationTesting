package org.springframework.samples.petclinic.pages.visit;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;

public class EditVisitPage extends Page {

    private static final String DATE_FIELD_CSS = "#visit > div.form-group.has-feedback > div:nth-child(1) > div > input";
    private static final String DESCRIPTION_FILED_CSS = "#description";
    private static final String SUBMIT_BUTTON_CSS = "#visit > div:nth-child(2) > div > button:nth-child(4)";

    public EditVisitPage(WebDriver driver) {
        super("Edit Visit",driver);
    }

    public void reFillEditForm() {
        implicitlyWait(10);
        clearField(DATE_FIELD_CSS);
        cssFill(DATE_FIELD_CSS,"2019-10-09");
        cssFill(DESCRIPTION_FILED_CSS,"description has been updated here!");
    }

    public OwnerInformationPage submitEditForm() {
        cssClick(SUBMIT_BUTTON_CSS);
        return new OwnerInformationPage(driver);
    }

    public void reFillInvalidData() {
        implicitlyWait(10);
        clearFieldForMac(DATE_FIELD_CSS);
        cssFill(DATE_FIELD_CSS,"kl-po-iuyi");
        cssFill(DESCRIPTION_FILED_CSS,"+dekfkbej@@@@@@@vewa");
    }

    public void emptyFields() {
        implicitlyWait(2);
        clearField(DATE_FIELD_CSS);
        cssFill(DATE_FIELD_CSS," ");
        cssFill(DESCRIPTION_FILED_CSS," ");
    }
}

