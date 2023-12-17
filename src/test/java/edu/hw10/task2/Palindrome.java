package edu.hw10.task2;


public interface Palindrome {
    @Cache(persist = true)
    public boolean isPalindrome(String s);
}
