package com.example.melgin.myfirstapp.content;

/**
 * Created by melgin on 02/01/2017.
 */
public class ContentItem {
    public final int id;
    public final String name;
    public final String content;
    public final String details;
    public final boolean hasIcon;
    public final String quote;

    public ContentItem(int id, String name, String content, String details, boolean hasIcon, String quote) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.details = details;
        this.hasIcon = hasIcon;
        this.quote = quote;
    }

    @Override
    public String toString() {
        return content;
    }

}
