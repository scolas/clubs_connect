package com.example.android.clubsconnect.interfaces;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T value);
}
