package org.springframework.samples.petclinic.pages;

public class HomePage extends Page {
    private static final String OWNER_TAB_SELECTOR="OWNERS";
    private static final String ALL_OWNERS_TAB_SELECTOR="ALL";

    public HomePage(){
super("Welcome");
goTo("http://localhost:8081/petclinic/");
    }
    public void clickOwners()
    {
        linkTextClick(OWNER_TAB_SELECTOR);
    }

    public void clickAllOwners()
    {
        linkTextClick(ALL_OWNERS_TAB_SELECTOR);
    }
    
}
