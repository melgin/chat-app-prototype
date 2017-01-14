package com.example.melgin.myfirstapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melgin.myfirstapp.listener.GestureListener;
import com.example.melgin.myfirstapp.util.Commons;
import com.example.melgin.myfirstapp.util.LoggerUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatActivity extends AppCompatActivity implements View.OnKeyListener, View.OnTouchListener {

    private TextView mTitleName;
    private ImageView mProfilePicture;
    private ImageView mBackButton;
    private EditText mEditText;
    private ImageView mCameraIcon;
    private FloatingActionButton mActionButton;

    private GestureDetectorCompat mDetector;

    private static final LoggerUtil logger = LoggerUtil.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        if(ab != null){
            // Enable the Up button
            ab.setDisplayHomeAsUpEnabled(false);
            ab.setDisplayShowTitleEnabled(false);
        }

        String name = getIntent().getStringExtra(Commons.EXTRA_ITEM_NAME);
        Integer imageId = getIntent().getIntExtra(Commons.EXTRA_ITEM_ID, 0);
        String theirMessage = getIntent().getStringExtra(Commons.EXTRA_ITEM_QUOTE);

        mTitleName = (TextView) findViewById(R.id.activeChat);
        if(mTitleName != null){
            mTitleName.setText(name);
        }

        mCameraIcon = (ImageView) findViewById(R.id.camera);
        mActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEditText != null && mEditText.getText() != null && ! mEditText.getText().toString().isEmpty()){
                    findViewById(R.id.myMessageContainer).setVisibility(View.VISIBLE);

                    TextView messageText = (TextView) findViewById(R.id.myMessage);
                    messageText.setText(mEditText.getText().toString().trim());

                    TextView messageTimeText = (TextView) findViewById(R.id.myMessageTime);
                    messageTimeText.setText(new SimpleDateFormat("HH:mm").format(new Date()));

                    mEditText.setText("");
                }
            }
        });
        mProfilePicture = (ImageView) findViewById(R.id.imageView);

        if(mProfilePicture != null && imageId != 0){
            mProfilePicture.setImageResource(imageId);
        }

        mBackButton = (ImageView) findViewById(R.id.backButton);
        if(mBackButton != null){
            mBackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    returnBack();
                }
            });
        }

        mEditText = (EditText) findViewById(R.id.messageEditText);
        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                logger.error("Text after change: " + s.toString());

                if(s.toString().trim().isEmpty()){
                    mCameraIcon.setVisibility(View.VISIBLE);
                    mActionButton.setImageResource(R.drawable.abc_ic_voice_search_api_mtrl_alpha);
                } else {
                    mCameraIcon.setVisibility(View.GONE);
                    mActionButton.setImageResource(R.drawable.input_send);
                }
            }
        });

        mEditText.setOnKeyListener(this);
        mEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            logger.error("User performed action ID: " + actionId);

            if(actionId== EditorInfo.IME_ACTION_DONE){
                logger.error("User pressed on enter button");
            }
            return false;
            }
        });

        TextView theirMessageTextView = (TextView) findViewById(R.id.theirMessage);
        theirMessageTextView.setText(theirMessage);

        View mainView = findViewById(R.id.main_content);
        mainView.setOnTouchListener(this);

        mDetector = new GestureDetectorCompat(this, new GestureListener());
    }

    public void returnBack(){
        Bundle data = getIntent().getExtras();
        Intent intent = new Intent(getApplicationContext(), WhatsAppChat.class);
        intent.putExtras(data);
        setResult(RESULT_OK, getIntent());
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_whats_app_chat2, menu);
        return true;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_UP){

            if(keyCode == KeyEvent.KEYCODE_ENTER){
                EditText editText = (EditText) v;

                findViewById(R.id.myMessageContainer).setVisibility(View.VISIBLE);

                TextView messageText = (TextView) findViewById(R.id.myMessage);
                messageText.setText(editText.getText().toString().trim());

                TextView messageTimeText = (TextView) findViewById(R.id.myMessageTime);
                messageTimeText.setText(new SimpleDateFormat("HH:mm").format(new Date()));

                editText.setText("");
            }

            logger.error("User typed: " + keyCode);
        }


        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
