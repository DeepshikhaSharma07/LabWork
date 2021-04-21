package com.tts;

import java.util.ArrayList;
import java.util.List;

public class Library {

    ArrayList<Book> books;
    String libraryAddress;


    public Library(String libraryAddress) {
        this.books = new ArrayList<>();
        this.libraryAddress = libraryAddress;
    }

    // Add the missing implementation to this class


    public void returned(String bookTitle) {
        boolean found = false;

        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("You successfully returned " + libraryBookTitle + "!");
                    found = true;
                    break;
                }

                if (!found) {
                    System.out.println("Are you sure you got the book from here? It isn't in our system.");
                }
            }
        }

        System.out.println();


    }

    void printAvailableBooks() {
        boolean libraryIsEmpty = true;
        for(int i = 0; i < this.books.size(); ++i) {
            Book libraryBook = (Book)this.books.get(i);
            if (!libraryBook.isBorrowed()) {
                System.out.println(libraryBook.getTitle());
                libraryIsEmpty = false;
            }
        }

        if (libraryIsEmpty) {
            System.out.println("Sorry, our catalog is empty");
        }
    }

    public void borrowBook(String bookTitle) {
        {
            for(int i = 0; i < this.books.size(); ++i) {
                Book libraryBook = (Book)this.books.get(i);
                String libraryBookTitle = libraryBook.getTitle();
                if (libraryBookTitle.equals(bookTitle)) {
                    if (!libraryBook.isBorrowed()) {
                        libraryBook.borrowed();
                        System.out.println("We have " + libraryBookTitle + ", and you have successfully borrowed it!");

                    }

                    System.out.println("Someone else has " + libraryBookTitle + " right now :(");

                }
            }

            System.out.println("Your book was not found in our system, sorry.");

        }



    }

    public void printAddress() {
        System.out.println(this.libraryAddress);
    }

    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm");
    }

    public void addBook(Book book) {
        this.books.add(book);
    }


}