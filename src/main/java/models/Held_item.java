
package models;

import java.util.List;



public class Held_item {

    private Item item;
    private List<Version_detail> version_details = null;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Version_detail> getVersion_details() {
        return version_details;
    }

    public void setVersion_details(List<Version_detail> version_details) {
        this.version_details = version_details;
    }

}
