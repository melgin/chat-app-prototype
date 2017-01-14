package com.example.melgin.myfirstapp.content;

import com.example.melgin.myfirstapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class ContactContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ContentItem> ITEMS = new ArrayList<ContentItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ContentItem> ITEM_MAP = new HashMap<String, ContentItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        addItem(new ContentItem(R.mipmap.ic_contact_12, "Christopher Smith", "Busy", "MOBILE", true, "No man is an island!"));
        addItem(new ContentItem(R.mipmap.ic_contact_7, "Edward Kandrot", "Available", "WORK", true, "The squeaky wheel gets the grease!"));
        addItem(new ContentItem(R.mipmap.ic_guy_montag, "Guy Montag", "Hey there! I am using WhatsApp.", "WORK", true, "You can't make an omelet without breaking a few eggs."));
        addItem(new ContentItem(R.mipmap.ic_contact_10, "Jackie Lincoln-Owyang", "Busy", "MOBILE", true, "Fortune favors the bold!"));
        addItem(new ContentItem(R.mipmap.ic_contact_9, "Jeff Chien", "Busy", "MOBILE", true, "People who live in glass houses should not throw stones!"));
        addItem(new ContentItem(R.mipmap.ic_contact_3, "John Nguyen", "Busy", "MOBILE", true, "Hope for the best, but prepare for the worst."));
        addItem(new ContentItem(R.mipmap.ic_contact_11, "Karen Gauthier", "Hey there! I am using WhatsApp.", "MOBILE", true, "Better late than never!"));
        addItem(new ContentItem(R.mipmap.ic_contact_5, "Kelly Davis", "Available", "WORK", true, "Birds of a feather flock together!"));
        addItem(new ContentItem(R.mipmap.ic_contact_15, "Maria Petri", "Busy", "MOBILE", true, "There's no such thing as a free lunch."));
        addItem(new ContentItem(R.mipmap.ic_contact_13, "Maria Weisberg", "Available", "MOBILE", true, "When the going gets tough, the tough get going."));
        addItem(new ContentItem(R.mipmap.ic_rachel_rosan, "Rachel Rosen", "Hey there! I am using WhatsApp.", "MOBILE", true, "Two wrongs don't make a right."));
        addItem(new ContentItem(R.mipmap.ic_rick_deckard, "Rick Deckard", "Available", "WORK", true, "The pen is mightier than the sword!"));
        addItem(new ContentItem(R.mipmap.ic_contact_14, "Rick Wulff", "Busy", "MOBILE", true, "There's no place like home."));
        addItem(new ContentItem(R.mipmap.ic_contact_2, "Russel Williams", "Busy", "MOBILE", true, "Discretion is the greater part of valor!"));
        addItem(new ContentItem(R.mipmap.ic_contact_6, "Sandra Alves", "Busy", "MOBILE", true, "The early bird catches the worm!"));
        addItem(new ContentItem(R.mipmap.ic_contact_8, "Tai Luxon", "Available", "MOBILE", true, "Never look a gift horse in the mouth!"));
        addItem(new ContentItem(R.mipmap.ic_contact_1, "Thomas Knoll", "Hey there! I am using WhatsApp.", "MOBILE", true, "When in Rome, do as the Romans."));
        addItem(new ContentItem(R.mipmap.ic_walter, "Walter White", "Busy", "MOBILE", true, "Keep your friends close and your enemies closer!"));
        addItem(new ContentItem(R.mipmap.ic_contact_4, "Yoko Nakagawa", "Busy", "MOBILE", true, "God helps those who help themselves!"));

    }

    private static void addItem(ContentItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }
}
