package com.wposs.diplofirebase0.MessageActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wposs.diplofirebase0.HomeActivity;
import com.wposs.diplofirebase0.MessageActivity.Interfaces.MessageView;
import com.wposs.diplofirebase0.R;

import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private EditText messageEditText;
    private Button sendButton;
    private Button returnButton;
    private ListView messageListView;
    private ArrayAdapter<String> adapter;
    private MessagePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);

        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        returnButton = findViewById(R.id.returnButton);
        messageListView = findViewById(R.id.messageListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        messageListView.setAdapter(adapter);

        presenter = new MessagePresenter((MessageView) new listenerPresenter());
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(MessageActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        sendButton.setOnClickListener(view -> {
            String message = messageEditText.getText().toString();
            if (!message.isEmpty()) {
                presenter.sendMessage(message);
            } else {
                Toast.makeText(MessageActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
            }
        });

        presenter.loadMessages();
    }

    public class listenerPresenter implements MessageView {


        @Override
        public void clearMessageInput() {
            messageEditText.setText("");
        }

        @Override
        public void loadMessages() {
            presenter.loadMessages();
        }


        @Override
        public void displayMessages(List<String> messages) {
            adapter.clear();
            for (String message : messages) {
                adapter.add(message);
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void showMessageError() {
            Toast.makeText(MessageActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
        }
    }
}