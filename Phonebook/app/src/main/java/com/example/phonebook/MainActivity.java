package com.example.phonebook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = getContactList();

        contactAdapter = new ContactAdapter(this, R.layout.contact_item, contactList);
        listView = findViewById(R.id.listView);
        listView.setAdapter(contactAdapter);

        // Bắt sự kiện nhấn vào một liên hệ
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("contact", (CharSequence) contactList.get(position));
            startActivity(intent);
        });

        // Đăng ký Context Menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Contact selectedContact = contactList.get(info.position);

        switch (item.getItemId()) {
            case R.id.callMenuItem:
                callContact(selectedContact.getPhone());
                break;
            case R.id.smsMenuItem:
                sendSms(selectedContact.getPhone());
                break;
            case R.id.emailMenuItem:
                sendEmail(selectedContact.getEmail());
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void callContact(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }

    private void sendSms(String phoneNumber) {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
        smsIntent.setData(Uri.parse("sms:" + phoneNumber));
        startActivity(smsIntent);
    }

    private void sendEmail(String emailAddress) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + emailAddress));
        startActivity(emailIntent);
    }

    private List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Trang1", "0111111111", "trang1@gmail.com"));
        contacts.add(new Contact(2, "Trang2", "0222222222", "trang2@gmail.com"));
        contacts.add(new Contact(3, "Trang3", "0333333333", "trang3@gmail.com"));
        contacts.add(new Contact(4, "Trang4", "0444444444", "trang4@gmail.com"));
        contacts.add(new Contact(5, "Trang5", "0555555555", "trang5@gmail.com"));
        contacts.add(new Contact(6, "Trang6", "0666666666", "trang6@gmail.com"));
        contacts.add(new Contact(7, "Trang7", "0777777777", "trang7@gmail.com"));
        contacts.add(new Contact(8, "Trang8", "0888888888", "trang8@gmail.com"));
        contacts.add(new Contact(9, "Trang9", "0999999999", "trang9@gmail.com"));

        return contacts;
    }
}
