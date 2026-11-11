package library.service;

import java.util.ArrayList;
import java.util.List;
import library.model.Book;
import library.model.Lendable;

public class Library {
    private final List<Lendable> items = new ArrayList<Lendable>();

    public void addItem(Lendable item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(Lendable item) {
        items.remove(item);
    }

    public List<Lendable> getAvailableItems() {
        List<Lendable> availableItems = new ArrayList<Lendable>();
        for (Lendable item : items) {
            if (item instanceof Book && !((Book) item).isBorrowed()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public void listAllItems() {
        for (Lendable item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            } else {
                System.out.println("Unknown item type");
            }
        }
    }
}
