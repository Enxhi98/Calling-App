package com.example.enxhikaziu.sample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//"ContactsAdapter" class
public class ContactsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contacts> contact;

    //Retrieves data from "Contact" array list and converts it into "View" objects
    public ContactsAdapter(Context context, ArrayList<Contacts> contact) {
        this.context = context;
        this.contact = contact;
    }
    //Methods of the layout inflater
    @Override
    public int getCount() {
        return contact.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.lay_contact,null);
        }
        else
        {
            view=convertView;
        }

        /*Text view "contactName" shows only the name of a contact when displaying the list; this happens because the inflater
        converts the data from "Name" getter into a "View" object*/
        TextView contactName= (TextView) view.findViewById(R.id.contactName);
        Contacts contacts=contact.get(position);
        contactName.setText(contacts.getName());
        System.getProperty("line.separator");
        Log.e("name", contacts.getName() + " ");
        //Returns the "Name" text view
        return view;

    }
}
