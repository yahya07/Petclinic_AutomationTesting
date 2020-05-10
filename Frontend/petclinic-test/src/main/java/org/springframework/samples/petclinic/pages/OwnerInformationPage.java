package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class OwnerInformationPage extends Page {
    private static final String URL ="http://localhost:8081/petclinic/owners/100";

    public OwnerInformationPage() {
        super("Owner Information", new ChromeDriver());
    }


    public void goTOwnerPage() {
        goTo(URL);
    }
    public boolean checkVisitButton(){
        return allTableElements("/html/body/app-root/app-owner-detail/div/div/table[2]").isEmpty();

    }

}
