package library.service;

import java.util.ArrayList;
import java.util.List;
import library.model.Lendable;

public class Customer {
    private final String name;
    private final List<Lendable> checkedOutItems;

    public Customer(String name) {
        this.name = name;
        this.checkedOutItems = new ArrayList<Lendable>();
    }

    public void checkOutItem(Lendable item) {
        if (item != null && !checkedOutItems.contains(item)) {
            item.borrow();
            checkedOutItems.add(item);
        }
    }

    public void returnItem(Lendable item) {
        if (item != null && checkedOutItems.remove(item)) {
            item.returnItem();
        }
    }

}
