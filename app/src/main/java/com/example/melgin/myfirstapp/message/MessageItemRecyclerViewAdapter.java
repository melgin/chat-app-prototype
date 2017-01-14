package com.example.melgin.myfirstapp.message;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melgin.myfirstapp.R;
import com.example.melgin.myfirstapp.content.ContentItem;
import com.example.melgin.myfirstapp.listener.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ContentItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 *
 */
public class MessageItemRecyclerViewAdapter extends RecyclerView.Adapter<MessageItemRecyclerViewAdapter.ViewHolder> {

    private final List<ContentItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final GestureDetectorCompat mDetector;

    public MessageItemRecyclerViewAdapter(List<ContentItem> items, OnListFragmentInteractionListener listener, GestureDetectorCompat detector) {
        mValues = items;
        mListener = listener;
        this.mDetector = detector;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_whats_app_message_item, parent, false);

        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {return mDetector.onTouchEvent(event);
            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ContentItem contentItem = mValues.get(position);
        holder.mItem = contentItem;
        holder.mIdView.setText(contentItem.name);
        holder.mContentView.setText(contentItem.content);
        holder.mImageView.setImageResource(contentItem.id);
        holder.mDateTextView.setText(contentItem.details);

        if(! contentItem.hasIcon){
            holder.mIconView.setVisibility(View.GONE);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onListFragmentInteraction(holder.mItem);
            }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mDateTextView;
        public final ImageView mImageView;
        public final ImageView mIconView;
        public ContentItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
            mDateTextView = (TextView) view.findViewById(R.id.messageDate);
            mIconView = (ImageView) view.findViewById(R.id.callArrow);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
