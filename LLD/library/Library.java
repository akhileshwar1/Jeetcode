class Member{
    String name;
    int id;
    int fine;

    public void levyFine(int amount);
    public void SearchBook(Catalog c, String bookName);
}

class Catalog{
    Book[] catalog;

    public void addBook(Book b);
    public void removeBook(Book b);
    public void SearchBook(String title);
}

class Book{
    String name;
    int id;
    int status;
    int borrowedAt;
    Member borrowedBy;
    int returnedAt;
    Member returnedBy;
    int dueDate;
    Member[] heldFor;

    public void borrowBook(Member borrower);

    public void returnBook(Member borrower);

    public void putHold(Member borrower);
}

// *NOTE: Here this object acts as an interface to the data it gets from the input, 
//        unlike the usual case where the object is an interface of the data it contains. 
//
// Design decision: I could have made catalog as a part of the staff object, but I didn't
//                  do it because all the staff objects should work on one catalog, so 
//                  passing it through input seemed the right choice.
class Staff{
    String name;
    int id;

    public void addBooktoCatalog(Catalog c, Book b){
        c.addBook(b);
    }

    public void returnBookToCatalog(Catalog c, Member m, Book b);
    public void borrowBookFromCatalog(Catalog c, Member m, Book b);
}

class Library {

  // the main method here can mimic a library manager.
  public static void main(String args[]){
      Book LOTR = new Book();
      Catalog c = new Catalog();
      Member m = new Member();
      Member m1 = new Member();
      Staff s = new Staff();
      s.addBooktoCatalog(c, LOTR);
      s.borrowBookFromCatalog(c, m, LOTR);
      s.returnBookToCatalog(c, m, LOTR);
  }

}


