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
public class CallContent {

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
        addItem(new ContentItem(R.mipmap.ic_rachel_rosan, "Rachel Rosen", "Yesterday 14:57", "", true, "Two wrongs don't make a right."));
        addItem(new ContentItem(R.mipmap.ic_rick_deckard, "Rick Deckard", "December 12, 22:45", "", true, "The pen is mightier than the sword."));
        addItem(new ContentItem(R.mipmap.ic_guy_montag, "Guy Montag", "October 4, 11:23", "", false, "When in Rome, do as the Romans."));
    }

    private static void addItem(ContentItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
