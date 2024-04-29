package sidorov.aleksey.pages;

import org.openqa.selenium.By;
import sidorov.aleksey.pageElements.PageHeader;

public class InventoryPage {
    private final PageHeader pageHeader = new PageHeader();
    public PageHeader getPageHeader(){
        return pageHeader;
    }
}
