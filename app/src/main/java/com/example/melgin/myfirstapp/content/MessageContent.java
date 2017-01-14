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
public class MessageContent {

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
        addItem(new ContentItem(R.mipmap.ic_rachel_rosan, "Rachel Rosen", "Two wrongs don't make a right.", "18:12", true, "Two wrongs don't make a right."));
        addItem(new ContentItem(R.mipmap.ic_contact_7, "Edward Kandrot",  "The squeaky wheel gets the grease.", "15:22", false, "The squeaky wheel gets the grease."));
        addItem(new ContentItem(R.mipmap.ic_contact_13, "Maria Weisberg", "When the going gets tough get going.", "09:32", true, "When the going gets tough, the tough get going."));
    }

    private static void addItem(ContentItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.name, item);
    }
}
