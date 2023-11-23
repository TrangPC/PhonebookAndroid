package com.example.phonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    private Context context;
    private int resource;
    private List<Contact> contactList;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> contactList) {
        super(context, resource, contactList);
        this.context = context;
        this.resource = resource;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource, null);
        }

        Contact contact = contactList.get(position);

        if (contact != null) {
            TextView nameTextView = view.findViewById(R.id.nameTextView);
            TextView phoneTextView = view.findViewById(R.id.phoneTextView);
            TextView emailTextView = view.findViewById(R.id.emailTextView);

            if (nameTextView != null) {
                nameTextView.setText(contact.getName());
            }

            if (phoneTextView != null) {
                phoneTextView.setText(contact.getPhone());
            }

            if (emailTextView != null) {
                emailTextView.setText(contact.getEmail());
            }
        }

        return view;
    }
}

