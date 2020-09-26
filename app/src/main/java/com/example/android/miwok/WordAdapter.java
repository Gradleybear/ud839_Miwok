package com.example.android.miwok;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import 	android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Words> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Words> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(

                    R.layout.list_item, parent, false);
        }
        Words current_word = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.englishTranslation);
        assert current_word != null;
        nameTextView.setText(current_word.getDefaultTranslation());
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTranslation);
        miwokTextView.setText(current_word.getMiwokTranslation());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.miwokImage);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        // Check if an image is provided for this word or not
        if (current_word.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            iconView.setImageResource(current_word.getImageResourceId());
            // Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            iconView.setVisibility(View.GONE);}
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
         textContainer.invalidate();

            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView
            return listItemView;
        }
    }
