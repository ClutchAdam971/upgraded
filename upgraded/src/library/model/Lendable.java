package library.model;

/** Contrat commun des objets pouvant être empruntés. */
public interface Lendable {
    void borrow();
    void returnItem();
}
