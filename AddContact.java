package com.example.enxhikaziu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


//Class that adds new contacts
public class AddContact extends Activity {
    //Declaration of variables
    Button contactAddButton;
    ListView listContacts;
    //Creation of an array list in order for the application to be able to store the new contacts
    ArrayList<Contacts> arrayListContact;
    ContactsAdapter contactAdapter;
    Contacts contacts;

    //2 variables that will have 2 different functions explained below
    final int C_View=1,C_Delete=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        arrayListContact=new ArrayList<Contacts>();

        listContacts= (ListView) findViewById(R.id.listView);

        contactAddButton= (Button) findViewById(R.id.contactAddButton);

        //Button listener
        contactAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This new intent takes the user to the data class/layout
                Intent intent = new Intent(AddContact.this, Data.class);
                startActivityForResult(intent, 1);


            }
        });

        //Adapter is needed to manage the link between the list view and the array list
        contactAdapter=new ContactsAdapter(AddContact.this,arrayListContact);

        listContacts.setAdapter(contactAdapter);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                registerForContextMenu(listContacts);

            }
        });

    }

    //Context menu that appears when a certain button is long pressed
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //Two options appear
        if (v.getId() == R.id.listView) {
            menu.add(0, C_View, 1, "View");
            menu.add(0, C_Delete, 2, "Delete");

        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case C_View:
                //1.View details of the contact
                Intent intent6=new Intent(AddContact.this,ContactDetails.class);
                AdapterView.AdapterContextMenuInfo info1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index1 = info1.position;

                intent6.putExtra("details", arrayListContact.get(index1));

                startActivity(intent6);

                break;

            case C_Delete:
                //2.Delete the contact
                Toast.makeText(AddContact.this,"Delete", Toast.LENGTH_SHORT).show();

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index = info.position;

                Log.e("index",index+" ");
                arrayListContact.remove(index);
                contactAdapter.notifyDataSetChanged();

                break;

        }
        return  true;


    }

    //Entered information gets stored in the list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode==2) {

            contacts = (Contacts) data.getSerializableExtra("data");

            arrayListContact.add(contacts);
            contactAdapter.notifyDataSetChanged();
        }


    }

}
